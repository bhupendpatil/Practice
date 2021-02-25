## System Configuration

* Install LFS-Bootscripts
```console
tar -xvf lfs-bootscripts-20200818.tar.xz
cd lfs-bootscripts-20200818
make install
cd ..
rm -Rf lfs-bootscripts-20200818
```

* Creating Network Interface Configuration Files
in new root terminal
```console
export LFS=/mnt/lfs
cd /etc
mkdir sysconfig
cd /etc/sysconfig/
cat > ifconfig.eth0 << "EOF"
ONBOOT=yes
IFACE=eth0
SERVICE=ipv4-static
IP=192.168.0.45
GATEWAY=192.168.0.1
PREFIX=24
BROADCAST=192.168.1.255
EOF
cp /etc/sysconfig/ifconfig.eth0 $LFS/etc/sysconfig
cp /etc/resolv.conf $LFS/etc
cp /etc/hostname $LFS/etc
cp /etc/hosts $LFS/etc

cd /etc/
cat > /etc/inittab << "EOF"
# Begin /etc/inittab
id:3:initdefault:
si::sysinit:/etc/rc.d/init.d/rc S
l0:0:wait:/etc/rc.d/init.d/rc 0
l1:S1:wait:/etc/rc.d/init.d/rc 1
l2:2:wait:/etc/rc.d/init.d/rc 2
l3:3:wait:/etc/rc.d/init.d/rc 3
l4:4:wait:/etc/rc.d/init.d/rc 4
l5:5:wait:/etc/rc.d/init.d/rc 5
l6:6:wait:/etc/rc.d/init.d/rc 6
ca:12345:ctrlaltdel:/sbin/shutdown -t1 -a -r now
su:S016:once:/sbin/sulogin
1:2345:respawn:/sbin/agetty --noclear tty1 9600
2:2345:respawn:/sbin/agetty tty2 9600
3:2345:respawn:/sbin/agetty tty3 9600
4:2345:respawn:/sbin/agetty tty4 9600
5:2345:respawn:/sbin/agetty tty5 9600
6:2345:respawn:/sbin/agetty tty6 9600
# End /etc/inittab
EOF
cp /etc/inittab $LFS/etc
cd /etc/sysconfig/
cat > /etc/sysconfig/clock << "EOF"
# Begin /etc/sysconfig/clock
UTC=1
# Set this to any options you might need to give to hwclock,
# such as machine hardware clock type for Alphas.
CLOCKPARAMS=
# End /etc/sysconfig/clock
EOF
cp /etc/sysconfig/clock $LFS/etc/sysconfig
cat > /etc/sysconfig/console << "EOF"
# Begin /etc/sysconfig/console
UNICODE="1"
KEYMAP="de-latin1"
KEYMAP_CORRECTIONS="euro2"
LEGACY_CHARSET="iso-8859-15"
FONT="LatArCyrHeb-16 -m 8859-15"
# End /etc/sysconfig/console
EOF
cp /etc/sysconfig/console $LFS/etc/sysconfig
```

* Bash Shell Startup Files
```console
LC_ALL=en_IN.utf8 locale charmap
cat > /etc/profile << "EOF"
# Begin /etc/profile
export LANG=en_IN.utf8
# End /etc/profile
EOF
cd /etc/
cp /etc/inputrc $LFS/etc
cp /etc/shells $LFS/etc

```