#!/usr/bin/env bash

function header_info {
  clear
  cat <<"EOF"
    __  __                        ___              _      __              __     ____  _____
   / / / /___  ____ ___  ___     /   |  __________(_)____/ /_____ _____  / /_   / __ \/ ___/
  / /_/ / __ \/ __ `__ \/ _ \   / /| | / ___/ ___/ / ___/ __/ __ `/ __ \/ __/  / / / /\__ \ 
 / __  / /_/ / / / / / /  __/  / ___ |(__  |__  ) (__  ) /_/ /_/ / / / / /_   / /_/ /___/ / 
/_/ /_/\____/_/ /_/ /_/\___/  /_/  |_/____/____/_/____/\__/\__,_/_/ /_/\__/   \____//____/  

EOF
}
header_info
echo -e "\n Loading..."
GEN_MAC=02:$(openssl rand -hex 5 | awk '{print toupper($0)}' | sed 's/\(..\)/\1:/g; s/.$//')
NEXTID=$(pvesh get /cluster/nextid)
VERSIONS=(stable beta dev)
for version in "${VERSIONS[@]}"; do
  eval "$version=$(curl -s https://raw.githubusercontent.com/home-assistant/version/master/$version.json | grep "ova" | cut -d '"' -f 4)"
done
YW=$(echo "\033[33m")
BL=$(echo "\033[36m")
HA=$(echo "\033[1;34m")
RD=$(echo "\033[01;31m")
BGN=$(echo "\033[4;92m")
GN=$(echo "\033[1;92m")
DGN=$(echo "\033[32m")
CL=$(echo "\033[m")
BFR="\\r\\033[K"
HOLD="-"
CM="${GN}✓${CL}"
CROSS="${RD}✗${CL}"
THIN="discard=on,ssd=1,"
set -Eeuo pipefail
trap 'error_handler $LINENO "$BASH_COMMAND"' ERR
trap cleanup EXIT
function error_handler() {
  local exit_code="$?"
  local line_number="$1"
  local command="$2"
  local error_message="${RD}[ERROR]${CL} in line ${RD}$line_number${CL}: exit code ${RD}$exit_code${CL}: while executing command ${YW}$command${CL}"
  echo -e "\n$error_message\n"
  cleanup_vmid
}
function cleanup_vmid() {
  if qm status $VMID &>/dev/null; then
    qm stop $VMID &>/dev/null
    qm destroy $VMID &>/dev/null
  fi
}
function cleanup() {
  popd >/dev/null
  rm -rf $TEMP_DIR
}
TEMP_DIR=$(mktemp -d)
pushd $TEMP_DIR >/dev/null
if whiptail --title "HOME ASSISTANT OS VM" --yesno "This will create a New Home Assistant OS VM. Proceed?" 10 58; then
  :
else
  header_info && echo -e "⚠ User exited script \n" && exit
fi

function msg_info() {
  local msg="$1"
  echo -ne " ${HOLD} ${YW}${msg}..."
}
function msg_ok() {
  local msg="$1"
  echo -e "${BFR} ${CM} ${GN}${msg}${CL}"
}
function msg_error() {
  local msg="$1"
  echo -e "${BFR} ${CROSS} ${RD}${msg}${CL}"
}
function PVE_CHECK() {
  if [ $(pveversion | grep -c "pve-manager/7\.[2-9]") -eq 0 ]; then
    echo -e "${CROSS} This version of Proxmox Virtual Environment is not supported"
    echo -e "Requires PVE Version 7.2 or higher"
    echo -e "Exiting..."
    sleep 2
    exit
  fi
}
function ARCH_CHECK() {
  if [ "$(dpkg --print-architecture)" != "amd64" ]; then
    echo -e "\n ${CROSS} This script will not work with PiMox! \n"
    echo -e "Exiting..."
    sleep 2
    exit
  fi
}
function default_settings() {
  BRANCH="$stable"
  VMID="$NEXTID"
  FORMAT=",efitype=4m"
  MACHINE=""
  HN="haos$stable"
  CORE_COUNT="2"
  RAM_SIZE="4096"
  BRG="vmbr0"
  MAC="$GEN_MAC"
  VLAN=""
  MTU=""
  START_VM="yes"
  echo -e "${DGN}Using HAOS Version: ${BGN}${BRANCH}${CL}"
  echo -e "${DGN}Using Virtual Machine ID: ${BGN}${VMID}${CL}"
  echo -e "${DGN}Using Machine Type: ${BGN}i440fx${CL}"
  echo -e "${DGN}Using Hostname: ${BGN}${HN}${CL}"
  echo -e "${DGN}Allocated Cores: ${BGN}${CORE_COUNT}${CL}"
  echo -e "${DGN}Allocated RAM: ${BGN}${RAM_SIZE}${CL}"
  echo -e "${DGN}Using Bridge: ${BGN}${BRG}${CL}"
  echo -e "${DGN}Using MAC Address: ${BGN}${MAC}${CL}"
  echo -e "${DGN}Using VLAN: ${BGN}Default${CL}"
  echo -e "${DGN}Using Interface MTU Size: ${BGN}Default${CL}"
  echo -e "${DGN}Start VM when completed: ${BGN}yes${CL}"
  echo -e "${BL}Creating a HAOS VM using the above default settings${CL}"
}
function advanced_settings() {
  BRANCH=$(whiptail --title "HAOS VERSION" --radiolist "Choose Version" --cancel-button Exit-Script 10 58 3 \
    "$stable" "Stable  " ON \
    "$beta" "Beta  " OFF \
    "$dev" "Dev  " OFF \
    3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ $exitstatus = 0 ]; then echo -e "${DGN}Using HAOS Version: ${BGN}$BRANCH${CL}"; fi
  while true; do
    VMID=$(whiptail --inputbox "Set Virtual Machine ID" 8 58 $NEXTID --title "VIRTUAL MACHINE ID" --cancel-button Exit-Script 3>&1 1>&2 2>&3)
    exitstatus=$?
    if [ -z "$VMID" ]; then
      VMID="$NEXTID"
      echo -e "${DGN}Virtual Machine ID: ${BGN}$VMID${CL}"
      break
    else
      if pct status "$VMID" &>/dev/null || qm status "$VMID" &>/dev/null; then
        echo -e "${CROSS}${RD} ID $VMID is already in use${CL}"
        sleep 2
        continue
      fi
      echo -e "${DGN}Virtual Machine ID: ${BGN}$VMID${CL}"
      break
    fi
  done

  MACH=$(whiptail --title "MACHINE TYPE" --radiolist --cancel-button Exit-Script "Choose Type" 10 58 2 \
    "i440fx" "Machine i440fx" ON \
    "q35" "Machine q35" OFF \
    3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ $MACH = q35 ]; then
    echo -e "${DGN}Using Machine Type: ${BGN}$MACH${CL}"
    FORMAT=""
    MACHINE=" -machine q35"
  else
    echo -e "${DGN}Using Machine Type: ${BGN}$MACH${CL}"
    FORMAT=",efitype=4m"
    MACHINE=""
  fi
  VM_NAME=$(whiptail --inputbox "Set Hostname" 8 58 haos${BRANCH} --title "HOSTNAME" --cancel-button Exit-Script 3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ -z $VM_NAME ]; then
    HN="haos${BRANCH}"
    echo -e "${DGN}Using Hostname: ${BGN}$HN${CL}"
  else
    if [ $exitstatus = 0 ]; then
      HN=$(echo ${VM_NAME,,} | tr -d ' ')
      echo -e "${DGN}Using Hostname: ${BGN}$HN${CL}"
    fi
  fi
  CORE_COUNT=$(whiptail --inputbox "Allocate CPU Cores" 8 58 2 --title "CORE COUNT" --cancel-button Exit-Script 3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ -z $CORE_COUNT ]; then
    CORE_COUNT="2"
    echo -e "${DGN}Allocated Cores: ${BGN}$CORE_COUNT${CL}"
  else
    if [ $exitstatus = 0 ]; then echo -e "${DGN}Allocated Cores: ${BGN}$CORE_COUNT${CL}"; fi
  fi
  RAM_SIZE=$(whiptail --inputbox "Allocate RAM in MiB" 8 58 4096 --title "RAM" --cancel-button Exit-Script 3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ -z $RAM_SIZE ]; then
    RAM_SIZE="4096"
    echo -e "${DGN}Allocated RAM: ${BGN}$RAM_SIZE${CL}"
  else
    if [ $exitstatus = 0 ]; then echo -e "${DGN}Allocated RAM: ${BGN}$RAM_SIZE${CL}"; fi
  fi
  BRG=$(whiptail --inputbox "Set a Bridge" 8 58 vmbr0 --title "BRIDGE" --cancel-button Exit-Script 3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ -z $BRG ]; then
    BRG="vmbr0"
    echo -e "${DGN}Using Bridge: ${BGN}$BRG${CL}"
  else
    if [ $exitstatus = 0 ]; then echo -e "${DGN}Using Bridge: ${BGN}$BRG${CL}"; fi
  fi
  MAC1=$(whiptail --inputbox "Set a MAC Address" 8 58 $GEN_MAC --title "MAC ADDRESS" --cancel-button Exit-Script 3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ -z $MAC1 ]; then
    MAC="$GEN_MAC"
    echo -e "${DGN}Using MAC Address: ${BGN}$MAC${CL}"
  else
    if [ $exitstatus = 0 ]; then
      MAC="$MAC1"
      echo -e "${DGN}Using MAC Address: ${BGN}$MAC1${CL}"
    fi
  fi
  VLAN1=$(whiptail --inputbox "Set a Vlan(leave blank for default)" 8 58 --title "VLAN" --cancel-button Exit-Script 3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ $exitstatus = 0 ]; then
    if [ -z $VLAN1 ]; then
      VLAN1="Default" VLAN=""
      echo -e "${DGN}Using Vlan: ${BGN}$VLAN1${CL}"
    else
      VLAN=",tag=$VLAN1"
      echo -e "${DGN}Using Vlan: ${BGN}$VLAN1${CL}"
    fi
  fi
  MTU1=$(whiptail --inputbox "Set Interface MTU Size (leave blank for default)" 8 58 --title "MTU SIZE" --cancel-button Exit-Script 3>&1 1>&2 2>&3)
  exitstatus=$?
  if [ $exitstatus = 0 ]; then
    if [ -z $MTU1 ]; then
      MTU1="Default" MTU=""
      echo -e "${DGN}Using Interface MTU Size: ${BGN}$MTU1${CL}"
    else
      MTU=",mtu=$MTU1"
      echo -e "${DGN}Using Interface MTU Size: ${BGN}$MTU1${CL}"
    fi
  fi
  if (whiptail --title "START VIRTUAL MACHINE" --yesno "Start VM when completed?" 10 58); then
    echo -e "${DGN}Start VM when completed: ${BGN}yes${CL}"
    START_VM="yes"
  else
    echo -e "${DGN}Start VM when completed: ${BGN}no${CL}"
    START_VM="no"
  fi
  if (whiptail --title "ADVANCED SETTINGS COMPLETE" --yesno "Ready to create HAOS ${BRANCH} VM?" --no-button Do-Over 10 58); then
    echo -e "${RD}Creating a HAOS VM using the above advanced settings${CL}"
  else
    header_info
    echo -e "${RD}Using Advanced Settings${CL}"
    advanced_settings
  fi
}
function START_SCRIPT() {
  if (whiptail --title "SETTINGS" --yesno "Use Default Settings?" --no-button Advanced 10 58); then
    header_info
    echo -e "${BL}Using Default Settings${CL}"
    default_settings
  else
    header_info
    echo -e "${RD}Using Advanced Settings${CL}"
    advanced_settings
  fi
}
ARCH_CHECK
PVE_CHECK
START_SCRIPT
msg_info "Validating Storage"
while read -r line; do
  TAG=$(echo $line | awk '{print $1}')
  TYPE=$(echo $line | awk '{printf "%-10s", $2}')
  FREE=$(echo $line | numfmt --field 4-6 --from-unit=K --to=iec --format %.2f | awk '{printf( "%9sB", $6)}')
  ITEM="  Type: $TYPE Free: $FREE "
  OFFSET=2
  if [[ $((${#ITEM} + $OFFSET)) -gt ${MSG_MAX_LENGTH:-} ]]; then
    MSG_MAX_LENGTH=$((${#ITEM} + $OFFSET))
  fi
  STORAGE_MENU+=("$TAG" "$ITEM" "OFF")
done < <(pvesm status -content images | awk 'NR>1')
VALID=$(pvesm status -content images | awk 'NR>1')
if [ -z "$VALID" ]; then
  msg_error "Unable to detect a valid storage location."
  exit
elif [ $((${#STORAGE_MENU[@]} / 3)) -eq 1 ]; then
  STORAGE=${STORAGE_MENU[0]}
else
  while [ -z "${STORAGE:+x}" ]; do
    STORAGE=$(whiptail --title "Storage Pools" --radiolist \
      "Which storage pool you would like to use for the HAOS VM?\n\n" \
      16 $(($MSG_MAX_LENGTH + 23)) 6 \
      "${STORAGE_MENU[@]}" 3>&1 1>&2 2>&3) || exit
  done
fi
msg_ok "Using ${CL}${BL}$STORAGE${CL} ${GN}for Storage Location."
msg_ok "Virtual Machine ID is ${CL}${BL}$VMID${CL}."
msg_info "Retrieving the URL for Home Assistant ${BRANCH} Disk Image"
if [ "$BRANCH" == "$dev" ]; then
  URL=https://os-builds.home-assistant.io/${BRANCH}/haos_ova-${BRANCH}.qcow2.xz
else
  URL=https://github.com/home-assistant/operating-system/releases/download/${BRANCH}/haos_ova-${BRANCH}.qcow2.xz
fi
sleep 2
msg_ok "${CL}${BL}${URL}${CL}"
wget -q --show-progress $URL
echo -en "\e[1A\e[0K"
FILE=$(basename $URL)
msg_ok "Downloaded ${CL}${BL}haos_ova-${BRANCH}.qcow2.xz${CL}"
msg_info "Extracting KVM Disk Image"
unxz $FILE
STORAGE_TYPE=$(pvesm status -storage $STORAGE | awk 'NR>1 {print $2}')
case $STORAGE_TYPE in
nfs | dir)
  DISK_EXT=".raw"
  DISK_REF="$VMID/"
  DISK_IMPORT="-format raw"
  THIN=""
  ;;
btrfs)
  DISK_EXT=".raw"
  DISK_REF="$VMID/"
  DISK_IMPORT="-format raw"
  FORMAT=",efitype=4m"
  THIN=""
  ;;
esac
for i in {0,1}; do
  disk="DISK$i"
  eval DISK${i}=vm-${VMID}-disk-${i}${DISK_EXT:-}
  eval DISK${i}_REF=${STORAGE}:${DISK_REF:-}${!disk}
done
msg_ok "Extracted KVM Disk Image"
msg_info "Creating HAOS VM"
qm create $VMID -agent 1${MACHINE} -tablet 0 -localtime 1 -bios ovmf -cores $CORE_COUNT -memory $RAM_SIZE \
  -name $HN -net0 virtio,bridge=$BRG,macaddr=$MAC$VLAN$MTU -onboot 1 -ostype l26 -scsihw virtio-scsi-pci
pvesm alloc $STORAGE $VMID $DISK0 4M 1>&/dev/null
qm importdisk $VMID ${FILE%.*} $STORAGE ${DISK_IMPORT:-} 1>&/dev/null
qm set $VMID \
  -efidisk0 ${DISK0_REF}${FORMAT} \
  -scsi0 ${DISK1_REF},${THIN}size=32G \
  -boot order=scsi0 \
  -description "# Home Assistant OS
### https://github.com/bhupendpatil
[![blackmorph](https://cdn.jsdelivr.net/gh/bhupendpatil/CDN@master/blackmorph/img/logo_white.png)](https://blackmorph.com)" >/dev/null
msg_ok "Created HAOS VM ${CL}${BL}(${HN})"
if [ "$START_VM" == "yes" ]; then
  msg_info "Starting Home Assistant OS VM"
  qm start $VMID
  msg_ok "Started Home Assistant OS VM"
fi
msg_ok "Completed Successfully!\n"