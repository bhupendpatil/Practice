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
    export export LFS=/mnt/lfs
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

* Installation Cross GCC
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