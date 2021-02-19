## Installing Basic System Software

* change directory to sources
```console
cd /sources
```

* Install Man-pages
```console
tar -xvf man-pages-5.08.tar.xz
cd man-pages-5.08
make install
cd ..
rm -Rf man-pages-5.08
```

* Install Tcl
```console
tar -xvf tcl8.6.10-src.tar.gz
cd tcl8.6.10-src
tar -xf ../tcl8.6.10-html.tar.gz --strip-components=1
SRCDIR=$(pwd)
cd unix
./configure --prefix=/usr --mandir=/usr/share/man $([ "$(uname -m)" = x86_64 ] && echo --enable-64bit)
make
sed -e "s|$SRCDIR/unix|/usr/lib|" -e "s|$SRCDIR|/usr/include|" -i tclConfig.sh
sed -e "s|$SRCDIR/unix/pkgs/tdbc1.1.1|/usr/lib/tdbc1.1.1|" -e "s|$SRCDIR/pkgs/tdbc1.1.1/generic|/usr/include|" -e "s|$SRCDIR/pkgs/tdbc1.1.1/library|/usr/lib/tcl8.6|" -e "s|$SRCDIR/pkgs/tdbc1.1.1|/usr/include|" -i pkgs/tdbc1.1.1/tdbcConfig.sh
sed -e "s|$SRCDIR/unix/pkgs/itcl4.2.0|/usr/lib/itcl4.2.0|" -e "s|$SRCDIR/pkgs/itcl4.2.0/generic|/usr/include|" -e "s|$SRCDIR/pkgs/itcl4.2.0|/usr/include|" -i pkgs/itcl4.2.0/itclConfig.sh
unset SRCDIR
make test
make install
chmod -v u+w /usr/lib/libtcl8.6.so
make install-private-headers
ln -sfv tclsh8.6 /usr/bin/tclsh
cd ..
rm -Rf tcl8.6.10-src
```

* Install Expect
```console
tar -xvf expect5.45.4.tar.gz
cd expect5.45.4
./configure --prefix=/usr --with-tcl=/usr/lib --enable-shared --mandir=/usr/share/man --with-tclinclude=/usr/include
make
make test
make install
ln -svf expect5.45.4/libexpect5.45.4.so /usr/lib
cd ..
rm -Rf expect5.45.4
```

* Install DejaGNU
```console
tar -xvf dejagnu-1.6.2.tar.gz
cd dejagnu-1.6.2
./configure --prefix=/usr
makeinfo --html --no-split -o doc/dejagnu.html doc/dejagnu.texi
makeinfo --plaintext -o doc/dejagnu.txt doc/dejagnu.texi
make install
install -v -dm755 /usr/share/doc/dejagnu-1.6.2
install -v -m644 doc/dejagnu.{html,txt} /usr/share/doc/dejagnu-1.6.2
make check
cd ..
rm -Rf dejagnu-1.6.2
```

* Install Iana-Etc
```console
tar -xvf iana-etc-20200821.tar.gz
cd iana-etc-20200821
cp services protocols /etc
cd ..
rm -Rf iana-etc-20200821
```

* Install Glibc
```console
tar -xvf glibc-2.32.tar.xz
cd glibc-2.32
patch -Np1 -i ../glibc-2.32-fhs-1.patch
mkdir -v build
cd build
../configure --prefix=/usr --disable-werror --enable-kernel=3.2 --enable-stack-protector=strong --with-headers=/usr/include libc_cv_slibdir=/lib
make
case $(uname -m) in
    i?86) ln -sfnv $PWD/elf/ld-linux.so.2 /lib ;;
    x86_64) ln -sfnv $PWD/elf/ld-linux-x86-64.so.2 /lib ;;
esac
make check
touch /etc/ld.so.conf
sed '/test-installation/s@$(PERL)@echo not running@' -i ../Makefile
make install
cp -v ../nscd/nscd.conf /etc/nscd.conf
mkdir -pv /var/cache/nscd
mkdir -pv /usr/lib/locale
localedef -i POSIX -f UTF-8 C.UTF-8 2> /dev/null || true
localedef -i cs_CZ -f UTF-8 cs_CZ.UTF-8
localedef -i de_DE -f ISO-8859-1 de_DE
localedef -i de_DE@euro -f ISO-8859-15 de_DE@euro
localedef -i de_DE -f UTF-8 de_DE.UTF-8
localedef -i el_GR -f ISO-8859-7 el_GR
localedef -i en_GB -f UTF-8 en_GB.UTF-8
localedef -i en_HK -f ISO-8859-1 en_HK
localedef -i en_PH -f ISO-8859-1 en_PH
localedef -i en_US -f ISO-8859-1 en_US
localedef -i en_US -f UTF-8 en_US.UTF-8
localedef -i es_MX -f ISO-8859-1 es_MX
localedef -i fa_IR -f UTF-8 fa_IR
localedef -i fr_FR -f ISO-8859-1 fr_FR
localedef -i fr_FR@euro -f ISO-8859-15 fr_FR@euro
localedef -i fr_FR -f UTF-8 fr_FR.UTF-8
localedef -i it_IT -f ISO-8859-1 it_IT
localedef -i it_IT -f UTF-8 it_IT.UTF-8
localedef -i ja_JP -f EUC-JP ja_JP
localedef -i ja_JP -f SHIFT_JIS ja_JP.SIJS 2> /dev/null || true
localedef -i ja_JP -f UTF-8 ja_JP.UTF-8
localedef -i ru_RU -f KOI8-R ru_RU.KOI8-R
localedef -i ru_RU -f UTF-8 ru_RU.UTF-8
localedef -i tr_TR -f UTF-8 tr_TR.UTF-8
localedef -i zh_CN -f GB18030 zh_CN.GB18030
localedef -i zh_HK -f BIG5-HKSCS zh_HK.BIG5-HKSCS
make localedata/install-locales
cat > /etc/nsswitch.conf << "EOF"
# Begin /etc/nsswitch.conf
passwd: files
group: files
shadow: files
hosts: files dns
networks: files
protocols: files
services: files
ethers: files
rpc: files
# End /etc/nsswitch.conf
EOF
tar -xf ../../tzdata2020a.tar.gz
ZONEINFO=/usr/share/zoneinfo
mkdir -pv $ZONEINFO/{posix,right}
for tz in etcetera southamerica northamerica europe africa antarctica \
asia australasia backward pacificnew systemv; do
zic -L /dev/null -d $ZONEINFO ${tz}
zic -L /dev/null -d $ZONEINFO/posix ${tz}
zic -L leapseconds -d $ZONEINFO/right ${tz}
done
cp -v zone.tab zone1970.tab iso3166.tab $ZONEINFO
zic -d $ZONEINFO -p America/New_York
unset ZONEINFO
#tzselect
ln -sfv /usr/share/zoneinfo/Asia/Kolkata /etc/localtime
cat > /etc/ld.so.conf << "EOF"
# Begin /etc/ld.so.conf
/usr/local/lib
/opt/lib
EOF
cat >> /etc/ld.so.conf << "EOF"
# Add an include directory
include /etc/ld.so.conf.d/*.conf
EOF
mkdir -pv /etc/ld.so.conf.d
cd ../..
rm -Rf glibc-2.32
```

* Install Zlib
```console
tar -xvf zlib-1.2.11.tar.xz
cd zlib-1.2.11
./configure --prefix=/usr
make
make check
make install
mv -v /usr/lib/libz.so.* /lib
ln -sfv ../../lib/$(readlink /usr/lib/libz.so) /usr/lib/libz.so
cd ..
rm -Rf zlib-1.2.11
```  

* Install Bzip2
```console
tar -xvf bzip2-1.0.8.tar.gz
cd bzip2-1.0.8
patch -Np1 -i ../bzip2-1.0.8-install_docs-1.patch
sed -i 's@\(ln -s -f \)$(PREFIX)/bin/@\1@' Makefile
sed -i "s@(PREFIX)/man@(PREFIX)/share/man@g" Makefile
make -f Makefile-libbz2_so
make clean
make
make PREFIX=/usr install
cp -v bzip2-shared /bin/bzip2
cp -av libbz2.so* /lib
ln -sv ../../lib/libbz2.so.1.0 /usr/lib/libbz2.so
rm -v /usr/bin/{bunzip2,bzcat,bzip2}
ln -sv bzip2 /bin/bunzip2
ln -sv bzip2 /bin/bzcat
cd ..
rm -Rf bzip2-1.0.8
```

* Install Xz
```console
tar -xvf xz-5.2.5.tar.xz
cd xz-5.2.5
./configure --prefix=/usr --disable-static --docdir=/usr/share/doc/xz-5.2.5
make
make check
make install
mv -v /usr/bin/{lzma,unlzma,lzcat,xz,unxz,xzcat} /bin
mv -v /usr/lib/liblzma.so.* /lib
ln -svf ../../lib/$(readlink /usr/lib/liblzma.so) /usr/lib/liblzma.so
cd ..
rm -Rf xz-5.2.5
```

* Install Zstd
```console
tar -xvf zstd-1.4.5.tar.gz
cd zstd-1.4.5
make
make prefix=/usr install
rm -v /usr/lib/libzstd.a
mv -v /usr/lib/libzstd.so.* /lib
ln -sfv ../../lib/$(readlink /usr/lib/libzstd.so) /usr/lib/libzstd.so
cd ..
rm -Rf zstd-1.4.5
```

* Install File
```console
tar -xvf file-5.39.tar.gz
cd file-5.39
./configure --prefix=/usr
make
make check
make install
cd ..
rm -Rf file-5.39
```

* Install Readline
```console
tar -xvf readline-8.0.tar.gz
cd readline-8.0
sed -i '/MV.*old/d' Makefile.in
sed -i '/{OLDSUFF}/c:' support/shlib-install
./configure --prefix=/usr --disable-static --with-curses --docdir=/usr/share/doc/readline-8.0
make SHLIB_LIBS="-lncursesw"
make SHLIB_LIBS="-lncursesw" install
mv -v /usr/lib/lib{readline,history}.so.* /lib
chmod -v u+w /lib/lib{readline,history}.so.*
ln -sfv ../../lib/$(readlink /usr/lib/libreadline.so) /usr/lib/libreadline.so
ln -sfv ../../lib/$(readlink /usr/lib/libhistory.so ) /usr/lib/libhistory.so
install -v -m644 doc/*.{ps,pdf,html,dvi} /usr/share/doc/readline-8.0
cd ..
rm -Rf readline-8.0
```

* Install M4
```console
tar -xvf m4-1.4.18.tar.xz
cd m4-1.4.18
sed -i 's/IO_ftrylockfile/IO_EOF_SEEN/' lib/*.c
echo "#define _IO_IN_BACKUP 0x100" >> lib/stdio-impl.h
./configure --prefix=/usr
make
make check
make install
cd ..
rm -Rf m4-1.4.18
```

* Install Bc
```console
tar -xvf bc-3.1.5.tar.xz
cd bc-3.1.5
PREFIX=/usr CC=gcc CFLAGS="-std=c99" ./configure.sh -G -O3
make
make test
make install
cd ..
rm -Rf bc-3.1.5
```

* Install Flex
```console
tar -xvf flex-2.6.4.tar.gz
cd flex-2.6.4
./configure --prefix=/usr --docdir=/usr/share/doc/flex-2.6.4
make
make check
make install
ln -sv flex /usr/bin/lex
cd ..
rm -Rf flex-2.6.4
```

* Install Binutils
```console
tar -xvf binutils-2.35.tar.xz
cd binutils-2.35
expect -c "spawn ls"

cd ..
rm -Rf binutils-2.35
```


```console
tar -xvf 
cd 
cd ..
rm -Rf 
```