## Final Preparations

### Creating a limited directory layout in LFS filesystem

* Create the required directory layout as root
```console
mkdir -pv $LFS/{bin,etc,lib,sbin,usr,var}
case $(uname -m) in
    x86_64) mkdir -pv $LFS/lib64 ;;
esac

```

* Cross-compiler in seprate directory
```console
mkdir -pv $LFS/tools
```


### Adding the LFS User

* Using root is dangerous, to make it simple and less harmful lets create new user and group called "lfs"
```console
groupadd lfs
useradd -s /bin/bash -g lfs -m -k /dev/null lfs

```

* Set password
```console
passwd lfs
```

* Grant lfs full access
```console
chown -v lfs $LFS/{usr,lib,var,etc,bin,sbin,tools}
case $(uname -m) in
    x86_64) chown -v lfs $LFS/lib64 ;;
esac

```

* For seprate working directory
```console
chown -v lfs $LFS/sources
```

* Login as lfs
```console
su - lfs
```


### Setting Up the Environment

* Create two new startup files for the bash shell
    ** .bash_profile
    ```console
    cat > ~/.bash_profile << "EOF"
    exec env -i HOME=$HOME TERM=$TERM PS1='\u:\w\$ ' /bin/bash
    EOF

    ```
    ** .bashrc
    ```console
    cat > ~/.bashrc << "EOF"
    set +h
    umask 022
    LFS=/mnt/lfs
    LC_ALL=POSIX
    LFS_TGT=$(uname -m)-lfs-linux-gnu
    PATH=/usr/bin
    if [ ! -L /bin ]; then PATH=/bin:$PATH; fi
    PATH=$LFS/tools/bin:$PATH
    export LFS LC_ALL LFS_TGT PATH
    EOF
    
    ```