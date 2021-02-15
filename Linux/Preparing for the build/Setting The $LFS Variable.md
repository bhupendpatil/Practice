## Setting The $LFS Variable

* If you arebuilding LFS on a separate partition, this directory will be the mount point for the partition. Choose a directory location and set the variable with the following command
```console
export LFS=/mnt/lfs
```

* To check that the LFS variable is set up properly
```console
echo $LFS
```