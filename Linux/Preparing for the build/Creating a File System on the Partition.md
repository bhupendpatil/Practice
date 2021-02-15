## Creating a File System on the Partition

* Execute following command to start-off with root level access
```console
sudo su -
```

* Execute following command to check and list disks
```console
fdisk -l
```

* Execute following command to see desired partition to work on I'm using `/dev/sbd`
```console
fdisk /dev/sdb
```

* Execute following command to select option `p` to print the partition table
```console
p
```

* Execute following command to add a new partition
```console
n
```

* Execute following command to select option `p` to print the partition table
```console
p
```

* set the size of the swap partition
```console
+1G
```

* Execute following command to change a partition's system id
```console
t
```

* Execute following command to list known partition id's
```console
l
```

* Select the id to create
```console
82
```

* Execute following command to add a new partition
```console
n
```

* Execute following command to select option `p` to print the partition table
```console
p
```

* Execute following command to write table to disk and exit
```console
w
```