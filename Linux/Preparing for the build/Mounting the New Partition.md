## Mounting the New Partition

* The following command will format `/dev/sdb2` as ext4
```console
mkfs.ext4 /dev/sdb2
```

* Create the mount point and mount the LFS file system by running I'll use `/dev/sdb2`
```console
mkdir -pv $LFS
mount -v -t ext4 /dev/sdb2 $LFS
```

* If you are using a swap partition, ensure that it is enabled using the swapon command I'll use `/dev/sdb1`
```console
mkswap /dev/sdb1
```