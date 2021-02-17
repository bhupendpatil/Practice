## Cross Compiling Temporary Tools

* Check `$LFS`
```console
echo $LFS
```
* Install M4
```console
tar -xvf m4-1.4.18.tar.xz
cd m4-1.4.18
sed -i 's/IO_ftrylockfile/IO_EOF_SEEN/' lib/*.c
echo "#define _IO_IN_BACKUP 0x100" >> lib/stdio-impl.h
./configure --prefix=/usr --host=$LFS_TGT --build=$(build-aux/config.guess)
make
make DESTDIR=$LFS install
cd ..
rm -Rf m4-1.4.18
```

* Install Ncurses
```console
tar -xvf ncurses-6.2.tar.gz
cd ncurses-6.2
sed -i s/mawk// configure
mkdir build
pushd build
    ../configure
    make -C include
    make -C progs tic
popd
./configure --prefix=/usr --host=$LFS_TGT --build=$(./config.guess) --mandir=/usr/share/man --with-manpage-format=normal --with-shared --without-debug --without-ada --without-normal --enable-widec
make
make DESTDIR=$LFS TIC_PATH=$(pwd)/build/progs/tic install
echo "INPUT(-lncursesw)" > $LFS/usr/lib/libncurses.so
mv -v $LFS/usr/lib/libncursesw.so.6* $LFS/lib
ln -sfv ../../lib/$(readlink $LFS/usr/lib/libncursesw.so) $LFS/usr/lib/libncursesw.so
cd ..
rm -Rf ncurses-6.2
```

* Install Bash
```console
tar -xvf bash-5.0.tar.gz
cd bash-5.0
./configure --prefix=/usr --build=$(support/config.guess) --host=$LFS_TGT --without-bash-malloc
make
make DESTDIR=$LFS install
mv $LFS/usr/bin/bash $LFS/bin/bash
ln -sv bash $LFS/bin/sh
cd ..
rm -Rf bash-5.0
```

* Install Coreutils
```console
tar -xvf coreutils-8.32.tar.xz 
cd coreutils-8.32
./configure --prefix=/usr --host=$LFS_TGT --build=$(build-aux/config.guess) --enable-install-program=hostname --enable-no-install-program=kill,uptime
make
make DESTDIR=$LFS install
mv -v $LFS/usr/bin/{cat,chgrp,chmod,chown,cp,date,dd,df,echo} $LFS/bin
mv -v $LFS/usr/bin/{false,ln,ls,mkdir,mknod,mv,pwd,rm} $LFS/bin
mv -v $LFS/usr/bin/{rmdir,stty,sync,true,uname} $LFS/bin
mv -v $LFS/usr/bin/{head,nice,sleep,touch} $LFS/bin
mv -v $LFS/usr/bin/chroot $LFS/usr/sbin
mkdir -pv $LFS/usr/share/man/man8
mv -v $LFS/usr/share/man/man1/chroot.1 $LFS/usr/share/man/man8/chroot.8
sed -i 's/"1"/"8"/' $LFS/usr/share/man/man8/chroot.8
cd ..
rm -Rf coreutils-8.32
```

* Install Diffutils
```console
tar -xvf diffutils-3.7.tar.xz
cd diffutils-3.7
./configure --prefix=/usr --host=$LFS_TGT
make
make DESTDIR=$LFS install
cd ..
rm -Rf diffutils-3.7
```

* Install File
```console
tar -xvf file-5.39.tar.gz
cd file-5.39
./configure --prefix=/usr --host=$LFS_TGT
make
make DESTDIR=$LFS install
cd ..
rm -Rf file-5.39
```

* Install Findutils
```console
tar -xvf findutils-4.7.0.tar.xz
cd findutils-4.7.0
./configure --prefix=/usr --host=$LFS_TGT --build=$(build-aux/config.guess)
make
make DESTDIR=$LFS install
mv -v $LFS/usr/bin/find $LFS/bin
sed -i 's|find:=${BINDIR}|find:=/bin|' $LFS/usr/bin/updatedb
cd ..
rm -Rf findutils-4.7.0
```

* Install Gawk
```console
tar -xvf gawk-5.1.0.tar.xz
cd gawk-5.1.0
sed -i 's/extras//' Makefile.in
./configure --prefix=/usr --host=$LFS_TGT --build=$(./config.guess)
make
make DESTDIR=$LFS install
cd ..
rm -Rf gawk-5.1.0
```

* Install Grep
```console
tar -xvf grep-3.4.tar.xz 
cd grep-3.4
./configure --prefix=/usr --host=$LFS_TGT --bindir=/bin
make
make DESTDIR=$LFS install
cd ..
rm -Rf grep-3.4
```

* Install Gzip
```console
tar -xvf gzip-1.10.tar.xz
cd gzip-1.10
./configure --prefix=/usr --host=$LFS_TGT
make
make DESTDIR=$LFS install
mv -v $LFS/usr/bin/gzip $LFS/bin
cd ..
rm -Rf gzip-1.10
```

* Install Make
```console
tar -xvf make-4.3.tar.gz 
cd make-4.3
./configure --prefix=/usr --without-guile --host=$LFS_TGT --build=$(build-aux/config.guess)
make
make DESTDIR=$LFS install
cd ..
rm -Rf make-4.3
```

* Install Patch
```console
tar -xvf patch-2.7.6.tar.xz 
cd patch-2.7.6
./configure --prefix=/usr --host=$LFS_TGT --build=$(build-aux/config.guess)
make
make DESTDIR=$LFS install
cd ..
rm -Rf patch-2.7.6
```

* Install Sed
```console
tar -xvf sed-4.8.tar.xz 
cd sed-4.8
./configure --prefix=/usr --host=$LFS_TGT --bindir=/bin
make
make DESTDIR=$LFS install
cd ..
rm -Rf sed-4.8
```

* Install Tar
```console
tar -xvf tar-1.32.tar.xz
cd tar-1.32
./configure --prefix=/usr --host=$LFS_TGT --build=$(build-aux/config.guess) --bindir=/bin
make
make DESTDIR=$LFS install
cd ..
rm -Rf tar-1.32
```

* Install Xz
```console
tar -xvf xz-5.2.5.tar.xz 
cd xz-5.2.5
./configure --prefix=/usr --host=$LFS_TGT --build=$(build-aux/config.guess) --disable-static --docdir=/usr/share/doc/xz-5.2.5
make
make DESTDIR=$LFS install
mv -v $LFS/usr/bin/{lzma,unlzma,lzcat,xz,unxz,xzcat} $LFS/bin
mv -v $LFS/usr/lib/liblzma.so.* $LFS/lib
ln -svf ../../lib/$(readlink $LFS/usr/lib/liblzma.so) $LFS/usr/lib/liblzma.so
cd ..
rm -Rf xz-5.2.5
```

* Install Binutils
```console
tar -xvf binutils-2.35.tar.xz
cd binutils-2.35
mkdir -v build
cd build
../configure --prefix=/usr --build=$(../config.guess) --host=$LFS_TGT --disable-nls --enable-shared --disable-werror --enable-64-bit-bfd
make
make DESTDIR=$LFS install
cd ../..
rm -Rf binutils-2.35
```

* Install GCC
```console
tar -xvf gcc-10.2.0.tar.xz
cd gcc-10.2.0
tar -xf ../mpfr-4.1.0.tar.xz
mv -v mpfr-4.1.0 mpfr
tar -xf ../gmp-6.2.0.tar.xz
mv -v gmp-6.2.0 gmp
tar -xf ../mpc-1.1.0.tar.gz
mv -v mpc-1.1.0 mpc
case $(uname -m) in
    x86_64)
        sed -e '/m64=/s/lib64/lib/' -i.orig gcc/config/i386/t-linux64
    ;;
esac
mkdir -v build
cd build
mkdir -pv $LFS_TGT/libgcc
ln -s ../../../libgcc/gthr-posix.h $LFS_TGT/libgcc/gthr-default.h
../configure --build=$(../config.guess) --host=$LFS_TGT --prefix=/usr CC_FOR_TARGET=$LFS_TGT-gcc --with-build-sysroot=$LFS --enable-initfini-array --disable-nls --disable-multilib --disable-decimal-float --disable-libatomic --disable-libgomp --disable-libquadmath --disable-libssp --disable-libvtv --disable-libstdcxx --enable-languages=c,c++
make
make DESTDIR=$LFS install
ln -sv gcc $LFS/usr/bin/cc
cd ../..
rm -Rf gcc-10.2.0
```