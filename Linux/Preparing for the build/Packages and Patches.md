## Packages and Patches

* Create directory using following command and as user root, before starting the download session
```console
mkdir -v $LFS/sources
```

* Enable the write and sticky modes
```console
chmod -v a+wt $LFS/sources
```

* Get `wget-list`
```console
wget https://raw.githubusercontent.com/bhupendpatil/Practice/master/Linux/Preparing%20for%20the%20build/wget-list -P $LFS/sources
```

* Download all packages and patches
```console
wget --input-file=wget-list --no-check-certificate --directory-prefix=$LFS/sources
```

* Remove downloaded `wget-list`
```console
rm $LFS/sources/wget-list
```

* Check or verify all correct packages and patches
```console
wget http://www.linuxfromscratch.org/lfs/view/stable/md5sums -P $LFS/sources
pushd $LFS/sources
    md5sum -c md5sums
popd
rm $LFS/sources/md5sums

```