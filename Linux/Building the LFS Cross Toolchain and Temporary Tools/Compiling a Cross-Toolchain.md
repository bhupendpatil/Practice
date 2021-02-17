## Compiling a Cross-Toolchain

* Check `$LFS`
```console
echo $LFS
```

* Changing `$LFS/sources` to read only
  * change to root
    ```console
    su -
    ```
  * then add the following commands
    ```console
    export LFS=/mnt/lfs
    cd $LFS/sources
    chmod u-w *
    su - lfs
    cd $LFS/sources

    ```

* Install cross Binutils 
```console
tar -xvf binutils-2.35.tar.xz
cd binutils-2.35
mkdir -v build
cd build
../configure --prefix=$LFS/tools --with-sysroot=$LFS --target=$LFS_TGT --disable-nls --disable-werror
make
make install
cd ../..
rm -Rf binutils-2.35

```

* Install cross GCC
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
        sed -e '/m64=/s/lib64/lib/' \
            -i.orig gcc/config/i386/t-linux64
    ;;
esac
mkdir -v build
cd build
../configure --target=$LFS_TGT --prefix=$LFS/tools --with-glibc-version=2.11 --with-sysroot=$LFS --with-newlib --without-headers --enable-initfini-array --disable-nls --disable-shared --disable-multilib --disable-decimal-float --disable-threads --disable-libatomic --disable-libgomp --disable-libquadmath --disable-libssp --disable-libvtv --disable-libstdcxx --enable-languages=c,c++
make
make install
cd ..
cat gcc/limitx.h gcc/glimits.h gcc/limity.h > `dirname $($LFS_TGT-gcc -print-libgcc-file-name)`/install-tools/include/limits.h
cd ..
rm -Rf gcc-10.2.0

```

* Install Linux API Headers
```console
tar -xvf linux-5.8.3.tar.xz 
cd linux-5.8.3
make mrproper
make headers
find usr/include -name '.*' -delete
rm usr/include/Makefile
cp -rv usr/include $LFS/usr
cd ..
rm -Rf linux-5.8.3

```

* Install Glibc
```console
tar -xvf glibc-2.32.tar.xz
cd glibc-2.32
case $(uname -m) in
i?86) ln -sfv ld-linux.so.2 $LFS/lib/ld-lsb.so.3
;;
x86_64) ln -sfv ../lib/ld-linux-x86-64.so.2 $LFS/lib64
ln -sfv ../lib/ld-linux-x86-64.so.2 $LFS/lib64/ld-lsb-x86-64.so.3
;;
esac
patch -Np1 -i ../glibc-2.32-fhs-1.patch
mkdir -v build
cd build
../configure --prefix=/usr --host=$LFS_TGT --build=$(../scripts/config.guess) --enable-kernel=3.2 --with-headers=$LFS/usr/include libc_cv_slibdir=/lib
make
make DESTDIR=$LFS install
```
* test now, output should be `[Requesting program interpreter: /lib64/ld-linux-x86-64.so.2]` for the code below
```console
echo 'int main(){}' > dummy.c
$LFS_TGT-gcc dummy.c
readelf -l a.out | grep '/ld-linux'
```
* once all is well, clean up the test files
```console
rm -v dummy.c a.out
```
* lets finalize the installation
```console
$LFS/tools/libexec/gcc/$LFS_TGT/10.2.0/install-tools/mkheaders
cd ../..
rm -Rf glibc-2.32
```

* Install Target Libstdc++
```console
tar -xvf gcc-10.2.0.tar.xz
cd gcc-10.2.0
mkdir -v build
cd build
../libstdc++-v3/configure --host=$LFS_TGT --build=$(../config.guess) --prefix=/usr --disable-multilib --disable-nls --disable-libstdcxx-pch --with-gxx-include-dir=/tools/$LFS_TGT/include/c++/10.2.0
make
make DESTDIR=$LFS install
cd ../..
rm -Rf gcc-10.2.0
```