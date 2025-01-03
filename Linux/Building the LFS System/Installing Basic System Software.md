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
cd tcl8.6.10
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
rm -Rf tcl8.6.10
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
sed -i '/@\tincremental_copy/d' gold/testsuite/Makefile.in
mkdir -v build
cd build
../configure --prefix=/usr --enable-gold --enable-ld=default --enable-plugins --enable-shared --disable-werror --enable-64-bit-bfd --with-system-zlib
make tooldir=/usr
make tooldir=/usr install
cd ..
rm -Rf binutils-2.35
```

* Install GMP
```console
tar -xvf gmp-6.2.0.tar.xz
cd gmp-6.2.0
./configure --prefix=/usr --enable-cxx --disable-static --docdir=/usr/share/doc/gmp-6.2.0
make
make html
make check 2>&1 | tee gmp-check-log
awk '/# PASS:/{total+=$3} ; END{print total}' gmp-check-log
make install
make install-html
cd ..
rm -Rf gmp-6.2.0
```

* Install MPFR
```console
tar -xvf mpfr-4.1.0.tar.xz
cd mpfr-4.1.0
./configure --prefix=/usr --disable-static --enable-thread-safe --docdir=/usr/share/doc/mpfr-4.1.0
make
make html
make check
make install
make install-html
cd ..
rm -Rf mpfr-4.1.0
```

* Install MPC
```console
tar -xvf mpc-1.1.0.tar.gz
cd mpc-1.1.0
./configure --prefix=/usr --disable-static --docdir=/usr/share/doc/mpc-1.1.0
make
make html
make check
make install
make install-html
cd ..
rm -Rf mpc-1.1.0
```

* Install Attr
```console
tar -xvf attr-2.4.48.tar.gz
cd attr-2.4.48
./configure --prefix=/usr --bindir=/bin --disable-static --sysconfdir=/etc --docdir=/usr/share/doc/attr-2.4.48
make
make check
make install
mv -v /usr/lib/libattr.so.* /lib
ln -sfv ../../lib/$(readlink /usr/lib/libattr.so) /usr/lib/libattr.so
cd ..
rm -Rf attr-2.4.48
```

* Install Acl
```console
tar -xvf acl-2.2.53.tar.gz
cd acl-2.2.53
./configure --prefix=/usr --bindir=/bin --disable-static --libexecdir=/usr/lib --docdir=/usr/share/doc/acl-2.2.53
make
make install
mv -v /usr/lib/libacl.so.* /lib
ln -sfv ../../lib/$(readlink /usr/lib/libacl.so) /usr/lib/libacl.so
cd ..
rm -Rf acl-2.2.53
```

* Install Libcap
```console
tar -xvf libcap-2.42.tar.xz
cd libcap-2.42
sed -i '/install -m.*STACAPLIBNAME/d' libcap/Makefile
make lib=lib
make test
make lib=lib PKGCONFIGDIR=/usr/lib/pkgconfig install
chmod -v 755 /lib/libcap.so.2.42
mv -v /lib/libpsx.a /usr/lib
rm -v /lib/libcap.so
ln -sfv ../../lib/libcap.so.2 /usr/lib/libcap.so
cd ..
rm -Rf libcap-2.42
```

* Install Shadow
```console
tar -xvf shadow-4.8.1.tar.xz
cd shadow-4.8.1
sed -i 's/groups$(EXEEXT) //' src/Makefile.in
find man -name Makefile.in -exec sed -i 's/groups\.1 / /' {} \;
find man -name Makefile.in -exec sed -i 's/getspnam\.3 / /' {} \;
find man -name Makefile.in -exec sed -i 's/passwd\.5 / /' {} \;
sed -e 's:#ENCRYPT_METHOD DES:ENCRYPT_METHOD SHA512:' -e 's:/var/spool/mail:/var/mail:' -i etc/login.defs
sed -i 's/1000/999/' etc/useradd
touch /usr/bin/passwd
./configure --sysconfdir=/etc --with-group-name-max-length=32
make
make install
pwconv
grpconv
sed -i 's/yes/no/' /etc/default/useradd
passwd root
```
Enter Password 
```console
cd ..
rm -Rf shadow-4.8.1
```

* Install GCC
```console
tar -xvf gcc-10.2.0.tar.xz
cd gcc-10.2.0
case $(uname -m) in
    x86_64)
        sed -e '/m64=/s/lib64/lib/' \
            -i.orig gcc/config/i386/t-linux64
    ;;
esac
mkdir -v build
cd build
../configure --prefix=/usr \
LD=ld \
--enable-languages=c,c++ --disable-multilib --disable-bootstrap --with-system-zlib
make
ulimit -s 32768
chown -Rv tester .
su tester -c "PATH=$PATH make -k check"
../contrib/test_summary
make install
rm -rf /usr/lib/gcc/$(gcc -dumpmachine)/10.2.0/include-fixed/bits/
chown -v -R root:root /usr/lib/gcc/*linux-gnu/10.2.0/include{,-fixed}
ln -sv ../usr/bin/cpp /lib
install -v -dm755 /usr/lib/bfd-plugins
ln -sfv ../../libexec/gcc/$(gcc -dumpmachine)/10.2.0/liblto_plugin.so /usr/lib/bfd-plugins/
echo 'int main(){}' > dummy.c
cc dummy.c -v -Wl,--verbose &> dummy.log
readelf -l a.out | grep ': /lib'
```
output should be `[Requesting program interpreter: /lib64/ld-linux-x86-64.so.2]`
```console
grep -o '/usr/lib.*/crt[1in].*succeeded' dummy.log
```
output should be 
`/usr/lib/gcc/x86_64-pc-linux-gnu/10.2.0/../../../../lib/crt1.o succeeded
/usr/lib/gcc/x86_64-pc-linux-gnu/10.2.0/../../../../lib/crti.o succeeded
/usr/lib/gcc/x86_64-pc-linux-gnu/10.2.0/../../../../lib/crtn.o succeeded`
```console
grep -B4 '^ /usr/include' dummy.log
```
output should be 
`#include <...> search starts here:
/usr/lib/gcc/x86_64-pc-linux-gnu/10.2.0/include
/usr/local/include
/usr/lib/gcc/x86_64-pc-linux-gnu/10.2.0/include-fixed
/usr/include`
```console
grep 'SEARCH.*/usr/lib' dummy.log |sed 's|; |\n|g'
```
output should be
`SEARCH_DIR("/usr/x86_64-pc-linux-gnu/lib64")
SEARCH_DIR("/usr/local/lib64")
SEARCH_DIR("/lib64")
SEARCH_DIR("/usr/lib64")
SEARCH_DIR("/usr/x86_64-pc-linux-gnu/lib")
SEARCH_DIR("/usr/local/lib")
SEARCH_DIR("/lib")
SEARCH_DIR("/usr/lib");`
or 
`SEARCH_DIR("/usr/i686-pc-linux-gnu/lib32")
SEARCH_DIR("/usr/local/lib32")
SEARCH_DIR("/lib32")
SEARCH_DIR("/usr/lib32")
SEARCH_DIR("/usr/i686-pc-linux-gnu/lib")
SEARCH_DIR("/usr/local/lib")
SEARCH_DIR("/lib")
SEARCH_DIR("/usr/lib");`
```console
grep "/lib.*/libc.so.6 " dummy.log
```
output should be `attempt to open /lib/libc.so.6 succeeded`
```console
grep found dummy.log
```
output should be `found ld-linux-x86-64.so.2 at /lib/ld-linux-x86-64.so.2`
```console
rm -v dummy.c a.out dummy.log
mkdir -pv /usr/share/gdb/auto-load/usr/lib
mv -v /usr/lib/*gdb.py /usr/share/gdb/auto-load/usr/lib
cd ../..
rm -Rf gcc-10.2.0
```

* Install Pkg-config
```console
tar -xvf pkg-config-0.29.2.tar.gz
cd pkg-config-0.29.2
./configure --prefix=/usr --with-internal-glib --disable-host-tool --docdir=/usr/share/doc/pkg-config-0.29.2
make
make check
make install
cd ..
rm -Rf pkg-config-0.29.2
```

* Install Ncurses
```console
tar -xvf ncurses-6.2.tar.gz
cd ncurses-6.2
sed -i '/LIBTOOL_INSTALL/d' c++/Makefile.in
./configure --prefix=/usr --mandir=/usr/share/man --with-shared --without-debug --without-normal --enable-pc-files --enable-widec
make
make install
mv -v /usr/lib/libncursesw.so.6* /lib
ln -sfv ../../lib/$(readlink /usr/lib/libncursesw.so) /usr/lib/libncursesw.so
for lib in ncurses form panel menu ; do
    rm -vf /usr/lib/lib${lib}.so
    echo "INPUT(-l${lib}w)" > /usr/lib/lib${lib}.so
    ln -sfv ${lib}w.pc /usr/lib/pkgconfig/${lib}.pc
done
rm -vf /usr/lib/libcursesw.so
echo "INPUT(-lncursesw)" > /usr/lib/libcursesw.so
ln -sfv libncurses.so /usr/lib/libcurses.so
mkdir -v /usr/share/doc/ncurses-6.2
cp -v -R doc/* /usr/share/doc/ncurses-6.2
cd ..
rm -Rf ncurses-6.2
```

* Install Sed
```console
tar -xvf sed-4.8.tar.xz
cd sed-4.8
./configure --prefix=/usr --bindir=/bin
make
make html
chown -Rv tester .
su tester -c "PATH=$PATH make check"
make install
install -d -m755 /usr/share/doc/sed-4.8
install -m644 doc/sed.html /usr/share/doc/sed-4.8
cd ..
rm -Rf sed-4.8
```

* Install Psmisc
```console
tar -xvf psmisc-23.3.tar.xz
cd psmisc-23.3
./configure --prefix=/usr
make
make install
mv -v /usr/bin/fuser /bin
mv -v /usr/bin/killall /bin
cd ..
rm -Rf psmisc-23.3
```

* Install Gettext
```console
tar -xvf gettext-0.21.tar.xz
cd gettext-0.21
./configure --prefix=/usr --disable-static --docdir=/usr/share/doc/gettext-0.21
make
make check
make install
chmod -v 0755 /usr/lib/preloadable_libintl.so
cd ..
rm -Rf gettext-0.21
```

* Install Bison
```console
tar -xvf bison-3.7.1.tar.xz
cd bison-3.7.1
./configure --prefix=/usr --docdir=/usr/share/doc/bison-3.7.1
make
make check
make install
cd ..
rm -Rf bison-3.7.1
```

* Install Grep
```console
tar -xvf grep-3.4.tar.xz
cd grep-3.4
./configure --prefix=/usr --bindir=/bin
make
make check
make install
cd ..
rm -Rf grep-3.4
```

* Install Bash
```console
tar -xvf bash-5.0.tar.gz
cd bash-5.0
patch -Np1 -i ../bash-5.0-upstream_fixes-1.patch
./configure --prefix=/usr --docdir=/usr/share/doc/bash-5.0 --without-bash-malloc --with-installed-readline
make
chown -Rv tester .
su tester << EOF
PATH=$PATH make tests < $(tty)
EOF
make install
mv -vf /usr/bin/bash /bin
exec /bin/bash --login +h
cd ..
rm -Rf bash-5.0
```

* Install Libtool
```console
tar -xvf libtool-2.4.6.tar.xz
cd libtool-2.4.6
./configure --prefix=/usr
make
make check
make install
cd ..
rm -Rf libtool-2.4.6
```

* Install GDBM
```console
tar -xvf gdbm-1.18.1.tar.gz
cd gdbm-1.18.1
sed -r -i '/^char.*parseopt_program_(doc|args)/d' src/parseopt.c
./configure --prefix=/usr --disable-static --enable-libgdbm-compat
make
make check
make install
cd ..
rm -Rf gdbm-1.18.1
```

* Install Gperf
```console
tar -xvf gperf-3.1.tar.gz
cd gperf-3.1.tar
./configure --prefix=/usr --docdir=/usr/share/doc/gperf-3.1
make
make -j1 check
make install
cd ..
rm -Rf gperf-3.1.tar
```

* Install Expat
```console
tar -xvf expat-2.2.9.tar.xz
cd expat-2.2.9
./configure --prefix=/usr --disable-static --docdir=/usr/share/doc/expat-2.2.9
make
make check
make install
install -v -m644 doc/*.{html,png,css} /usr/share/doc/expat-2.2.9
cd ..
rm -Rf expat-2.2.9
```

* Install Inetutils
```console 
tar -xvf inetutils-1.9.4.tar.xz
cd inetutils-1.9.4
./configure --prefix=/usr --localstatedir=/var --disable-logger --disable-whois --disable-rcp --disable-rexec --disable-rlogin --disable-rsh --disable-servers
make
make check
make install
mv -v /usr/bin/{hostname,ping,ping6,traceroute} /bin
mv -v /usr/bin/ifconfig /sbin
cd ..
rm -Rf inetutils-1.9.4
```

* Install Perl
```console
tar -xvf perl-5.32.0.tar.xz
cd perl-5.32.0
export BUILD_ZLIB=False
export BUILD_BZIP2=0
sh Configure -des \
-Dprefix=/usr \
-Dvendorprefix=/usr \
-Dprivlib=/usr/lib/perl5/5.32/core_perl -Darchlib=/usr/lib/perl5/5.32/core_perl -Dsitelib=/usr/lib/perl5/5.32/site_perl -Dsitearch=/usr/lib/perl5/5.32/site_perl -Dvendorlib=/usr/lib/perl5/5.32/vendor_perl -Dvendorarch=/usr/lib/perl5/5.32/vendor_perl -Dman1dir=/usr/share/man/man1 -Dman3dir=/usr/share/man/man3 -Dpager="/usr/bin/less -isR" -Duseshrplib -Dusethreads
make
make test
make install
unset BUILD_ZLIB BUILD_BZIP2
cd ..
rm -Rf perl-5.32.0
```

* Install XML::Parser
```console
tar -xvf XML-Parser-2.46.tar.gz
cd XML-Parser-2.46
perl Makefile.PL
make
make test
make install
cd ..
rm -Rf XML-Parser-2.46
```

* Install Intltool
```console
tar -xvf intltool-0.51.0.tar.gz
cd intltool-0.51.0
sed -i 's:\\\${:\\\$\\{:' intltool-update.in
make
make check
make install
install -v -Dm644 doc/I18N-HOWTO /usr/share/doc/intltool-0.51.0/I18N-HOWTO
cd ..
rm -Rf intltool-0.51.0
```

* Install Autoconf2
```console
tar -xvf autoconf-2.69.tar.xz
cd autoconf-2.69
sed -i '361 s/{/\\{/' bin/autoscan.in
./configure --prefix=/usr
make
make check
make install
cd ..
rm -Rf autoconf-2.69
```

* Install Automake
```console
tar -xvf automake-1.16.2.tar.xz
cd automake-1.16.2
sed -i "s/''/etags/" t/tags-lisp-space.sh
./configure --prefix=/usr --docdir=/usr/share/doc/automake-1.16.2
make
make -j4 check
make install
cd ..
rm -Rf automake-1.16.2
```

* Install Kmod
```console
tar -xvf kmod-27.tar.xz
cd kmod-27
./configure --prefix=/usr --bindir=/bin --sysconfdir=/etc --with-rootlibdir=/lib --with-xz --with-zlib
make
make install
for target in depmod insmod lsmod modinfo modprobe rmmod; do
    ln -sfv ../bin/kmod /sbin/$target
done
ln -sfv kmod /bin/lsmod
cd ..
rm -Rf kmod-27
```

* Install Libelf
```console
tar -xvf elfutils-0.180.tar.bz2
cd elfutils-0.180
./configure --prefix=/usr --disable-debuginfod --libdir=/lib
make
make check
make -C libelf install
install -vm644 config/libelf.pc /usr/lib/pkgconfig
rm /lib/libelf.a
cd ..
rm -Rf elfutils-0.180
```

* Install Libffi
```console
tar -xvf libffi-3.3.tar.gz
cd libffi-3.3
./configure --prefix=/usr --disable-static --with-gcc-arch=native
make
make check
make install
cd ..
rm -Rf libffi-3.3
```

* Install OpenSSL
```console
tar -xvf openssl-1.1.1g.tar.gz
cd openssl-1.1.1g
./config --prefix=/usr --openssldir=/etc/ssl --libdir=lib shared zlib-dynamic
make
make test
sed -i '/INSTALL_LIBS/s/libcrypto.a libssl.a//' Makefile
make MANSUFFIX=ssl install
mv -v /usr/share/doc/openssl /usr/share/doc/openssl-1.1.1g
cp -vfr doc/* /usr/share/doc/openssl-1.1.1g
cd ..
rm -Rf openssl-1.1.1g
```

* Install Python
```console
tar -xvf Python-3.8.5.tar.xz
cd Python-3.8.5
./configure --prefix=/usr --enable-shared --with-system-expat --with-system-ffi --with-ensurepip=yes
make
make install
chmod -v 755 /usr/lib/libpython3.8.so
chmod -v 755 /usr/lib/libpython3.so
ln -sfv pip3.8 /usr/bin/pip3
install -v -dm755 /usr/share/doc/python-3.8.5/html
tar --strip-components=1 --no-same-owner --no-same-permissions -C /usr/share/doc/python-3.8.5/html -xvf ../python-3.8.5-docs-html.tar.bz2
cd ..
rm -Rf Python-3.8.5
```

* Install Ninja
```console
tar -xvf ninja-1.10.0.tar.gz
cd ninja-1.10.0
export NINJAJOBS=4
sed -i '/int Guess/a \
int j = 0;\
char* jobs = getenv( "NINJAJOBS" );\
if ( jobs != NULL ) j = atoi( jobs );\
if ( j > 0 ) return j;\
' src/ninja.cc
python3 configure.py --bootstrap
./ninja ninja_test
./ninja_test --gtest_filter=-SubprocessTest.SetWithLots
install -vm755 ninja /usr/bin/
install -vDm644 misc/bash-completion /usr/share/bash-completion/completions/ninja
install -vDm644 misc/zsh-completion /usr/share/zsh/site-functions/_ninja
cd ..
rm -Rf ninja-1.10.0
```

* Install Meson
```console
tar -xvf meson-0.55.0.tar.gz
cd meson-0.55.0
python3 setup.py build
python3 setup.py install --root=dest
cp -rv dest/* /
cd ..
rm -Rf meson-0.55.0
```

* Install Coreutils
```console
tar -xvf coreutils-8.32.tar.xz
cd coreutils-8.32
patch -Np1 -i ../coreutils-8.32-i18n-1.patch
sed -i '/test.lock/s/^/#/' gnulib-tests/gnulib.mk
autoreconf -fiv
FORCE_UNSAFE_CONFIGURE=1 ./configure --prefix=/usr --enable-no-install-program=kill,uptime
make
make NON_ROOT_USERNAME=tester check-root
echo "dummy:x:102:tester" >> /etc/group
chown -Rv tester .
su tester -c "PATH=$PATH make RUN_EXPENSIVE_TESTS=yes check"
sed -i '/dummy/d' /etc/group
make install
mv -v /usr/bin/{cat,chgrp,chmod,chown,cp,date,dd,df,echo} /bin
mv -v /usr/bin/{false,ln,ls,mkdir,mknod,mv,pwd,rm} /bin
mv -v /usr/bin/{rmdir,stty,sync,true,uname} /bin
mv -v /usr/bin/chroot /usr/sbin
mv -v /usr/share/man/man1/chroot.1 /usr/share/man/man8/chroot.8
sed -i 's/"1"/"8"/' /usr/share/man/man8/chroot.8
mv -v /usr/bin/{head,nice,sleep,touch} /bin
cd ..
rm -Rf coreutils-8.32
```

* Install Check
```console
tar -xvf check-0.15.2.tar.gz
cd check-0.15.2
./configure --prefix=/usr --disable-static
make
make check
make docdir=/usr/share/doc/check-0.15.2 install
cd ..
rm -Rf check-0.15.2
```

* Install Diffutils
```console
tar -xvf diffutils-3.7.tar.xz
cd diffutils-3.7
./configure --prefix=/usr
make
make check
make install
cd ..
rm -Rf diffutils-3.7
```

* Install Gawk
```console
tar -xvf gawk-5.1.0.tar.xz
cd gawk-5.1.0
sed -i 's/extras//' Makefile.in
./configure --prefix=/usr
make
make check
make install
mkdir -v /usr/share/doc/gawk-5.1.0
cp -v doc/{awkforai.txt,*.{eps,pdf,jpg}} /usr/share/doc/gawk-5.1.0
cd ..
rm -Rf gawk-5.1.0
```

* Install Findutils
```console
tar -xvf findutils-4.7.0.tar.xz
cd findutils-4.7.0
./configure --prefix=/usr --localstatedir=/var/lib/locate
make
chown -Rv tester .
su tester -c "PATH=$PATH make check"
make install
mv -v /usr/bin/find /bin
sed -i 's|find:=${BINDIR}|find:=/bin|' /usr/bin/updatedb
cd ..
rm -Rf findutils-4.7.0
```

* Install Groff
```console
tar -xvf groff-1.22.4.tar.gz
cd groff-1.22.4
PAGE=A4 ./configure --prefix=/usr
make -j1
make install
cd ..
rm -Rf groff-1.22.4
```

* Install GRUB
```console
tar -xvf grub-2.04.tar.xz
cd grub-2.04
./configure --prefix=/usr --sbindir=/sbin --sysconfdir=/etc --disable-efiemu --disable-werror
make
make install
mv -v /etc/bash_completion.d/grub /usr/share/bash-completion/completions
cd ..
rm -Rf grub-2.04
```

* Install Less
```console
tar -xvf less-551.tar.gz
cd less-551
./configure --prefix=/usr --sysconfdir=/etc
make
make install
cd ..
rm -Rf less-551
```

* Install Gzip
```console
tar -xvf gzip-1.10.tar.xz
cd gzip-1.10
./configure --prefix=/usr
make
make check
make install
mv -v /usr/bin/gzip /bin
cd ..
rm -Rf gzip-1.10
```

* Install IPRoute2
```console
tar -xvf iproute2-5.8.0.tar.xz
cd iproute2-5.8.0
sed -i /ARPD/d Makefile
rm -fv man/man8/arpd.8
sed -i 's/.m_ipt.o//' tc/Makefile
make
make DOCDIR=/usr/share/doc/iproute2-5.8.0 install
cd ..
rm -Rf iproute2-5.8.0
```

* Install Kbd
```console
tar -xvf kbd-2.3.0.tar.xz
cd kbd-2.3.0
patch -Np1 -i ../kbd-2.3.0-backspace-1.patch
sed -i '/RESIZECONS_PROGS=/s/yes/no/' configure
sed -i 's/resizecons.8 //' docs/man/man8/Makefile.in
./configure --prefix=/usr --disable-vlock
make
make check
make install
rm -v /usr/lib/libtswrap.{a,la,so*}
mkdir -v /usr/share/doc/kbd-2.3.0
cp -R -v docs/doc/* /usr/share/doc/kbd-2.3.0
cd ..
rm -Rf kbd-2.3.0
```

* Install Libpipeline
```console
tar -xvf libpipeline-1.5.3.tar.gz
cd libpipeline-1.5.3
./configure --prefix=/usr
make
make check
make install
cd ..
rm -Rf libpipeline-1.5.3
```

* Install Make
```console
tar -xvf make-4.3.tar.gz
cd make-4.3
./configure --prefix=/usr
make
make check
make install
cd ..
rm -Rf make-4.3
```

* Install Patch
```console
tar -xvf patch-2.7.6.tar.xz
cd patch-2.7.6
./configure --prefix=/usr
make
make check
make install
cd ..
rm -Rf patch-2.7.6
```

* Install Man-DB
```console
tar -xvf man-db-2.9.3.tar.xz
cd man-db-2.9.3
./configure --prefix=/usr --docdir=/usr/share/doc/man-db-2.9.3 --sysconfdir=/etc --disable-setuid --enable-cache-owner=bin --with-browser=/usr/bin/lynx --with-vgrind=/usr/bin/vgrind --with-grap=/usr/bin/grap --with-systemdtmpfilesdir= --with-systemdsystemunitdir=
make
make check
make install
cd ..
rm -Rf man-db-2.9.3
```

* Install Tar
```console
tar -xvf tar-1.32.tar.xz
cd tar-1.32
FORCE_UNSAFE_CONFIGURE=1 ./configure --prefix=/usr --bindir=/bin
make
make check
make install
make -C doc install-html docdir=/usr/share/doc/tar-1.32
cd ..
rm -Rf tar-1.32
```

* Install Texinfo
```console
tar -xvf texinfo-6.7.tar.xz
cd texinfo-6.7
./configure --prefix=/usr --disable-static
make
make check
make install
make TEXMF=/usr/share/texmf install-tex
pushd /usr/share/info
    rm -v dir
    for f in *
        do install-info $f dir 2>/dev/null
    done
popd
cd ..
rm -Rf texinfo-6.7
```

* Install Vim
```console
tar -xvf vim-8.2.1361.tar.gz
cd vim-8.2.1361
echo '#define SYS_VIMRC_FILE "/etc/vimrc"' >> src/feature.h
./configure --prefix=/usr
make
chown -Rv tester .
su tester -c "LANG=en_US.UTF-8 make -j1 test" &> vim-test.log
```
```console
make install
ln -sv vim /usr/bin/vi
for L in /usr/share/man/{,*/}man1/vim.1; do
    ln -sv vim.1 $(dirname $L)/vi.1
done
ln -sv ../vim/vim82/doc /usr/share/doc/vim-8.2.1361
cat > /etc/vimrc << "EOF"
" Begin /etc/vimrc
" Ensure defaults are set before customizing settings, not after
source $VIMRUNTIME/defaults.vim
let skip_defaults_vim=1
set nocompatible
set backspace=2
set mouse=
syntax on
if (&term == "xterm") || (&term == "putty")
    set background=dark
endif
" End /etc/vimrc
EOF
cd ..
rm -Rf vim-8.2.1361
```

* Install Eudev
```console
tar -xvf eudev-3.2.9.tar.gz
cd eudev-3.2.9
./configure --prefix=/usr --bindir=/sbin --sbindir=/sbin --libdir=/usr/lib --sysconfdir=/etc --libexecdir=/lib --with-rootprefix= --with-rootlibdir=/lib --enable-manpages --disable-static
make
mkdir -pv /lib/udev/rules.d
mkdir -pv /etc/udev/rules.d
make check
make install
tar -xvf ../udev-lfs-20171102.tar.xz
make -f udev-lfs-20171102/Makefile.lfs install
udevadm hwdb --update
cd ..
rm -Rf eudev-3.2.9
```

* Install Procps-ng
```console
tar -xvf procps-ng-3.3.16.tar.xz
cd procps-ng-3.3.16
./configure --prefix=/usr --exec-prefix= --libdir=/usr/lib --docdir=/usr/share/doc/procps-ng-3.3.16 --disable-static --disable-kill
make
make check
make install
mv -v /usr/lib/libprocps.so.* /lib
ln -sfv ../../lib/$(readlink /usr/lib/libprocps.so) /usr/lib/libprocps.so
cd ..
rm -Rf procps-ng-3.3.16
```

* Install Util-linux
```console
tar -xvf util-linux-2.36.tar.xz
cd util-linux-2.36
mkdir -pv /var/lib/hwclock
./configure ADJTIME_PATH=/var/lib/hwclock/adjtime --docdir=/usr/share/doc/util-linux-2.36 --disable-chfn-chsh --disable-login --disable-nologin --disable-su --disable-setpriv --disable-runuser --disable-pylibmount --disable-static --without-python --without-systemd --without-systemdsystemunitdir
make
chown -Rv tester .
su tester -c "make -k check"
make install
cd ..
rm -Rf util-linux-2.36
```

* Install E2fsprogs
```console
tar -xvf e2fsprogs-1.45.6.tar.gz
cd e2fsprogs-1.45.6
mkdir -v build
cd build
../configure --prefix=/usr --bindir=/bin --with-root-prefix="" --enable-elf-shlibs --disable-libblkid --disable-libuuid --disable-uuidd --disable-fsck
cd ../..
make
make check
make install
chmod -v u+w /usr/lib/{libcom_err,libe2p,libext2fs,libss}.a
gunzip -v /usr/share/info/libext2fs.info.gz
install-info --dir-file=/usr/share/info/dir /usr/share/info/libext2fs.info
makeinfo -o doc/com_err.info ../lib/et/com_err.texinfo
install -v -m644 doc/com_err.info /usr/share/info
install-info --dir-file=/usr/share/info/dir /usr/share/info/com_err.info
rm -Rf e2fsprogs-1.45.6
```

* Install Sysklogd
```console
tar -xvf sysklogd-1.5.1.tar.gz
cd sysklogd-1.5.1
sed -i '/Error loading kernel symbols/{n;n;d}' ksym_mod.c
sed -i 's/union wait/int/' syslogd.c
make
make BINDIR=/sbin install
cat > /etc/syslog.conf << "EOF"
# Begin /etc/syslog.conf
auth,authpriv.* -/var/log/auth.log
*.*;auth,authpriv.none -/var/log/sys.log
daemon.* -/var/log/daemon.log
kern.* -/var/log/kern.log
mail.* -/var/log/mail.log
user.* -/var/log/user.log
*.emerg *
# End /etc/syslog.conf
EOF
cd ..
rm -Rf sysklogd-1.5.1
```

* Install Sysvinit
```console
tar -xvf sysvinit-2.97.tar.xz
cd sysvinit-2.97
patch -Np1 -i ../sysvinit-2.97-consolidated-1.patch
make
make install
cd ..
rm -Rf sysvinit-2.97
```

* Stripping Again
```console
save_lib="ld-2.32.so libc-2.32.so libpthread-2.32.so libthread_db-1.0.so"
cd /lib
for LIB in $save_lib; do
    objcopy --only-keep-debug $LIB $LIB.dbg
    strip --strip-unneeded $LIB
    objcopy --add-gnu-debuglink=$LIB.dbg $LIB
done
save_usrlib="libquadmath.so.0.0.0 libstdc++.so.6.0.28
libitm.so.1.0.0 libatomic.so.1.2.0"
cd /usr/lib
for LIB in $save_usrlib; do
    objcopy --only-keep-debug $LIB $LIB.dbg
    strip --strip-unneeded $LIB
    objcopy --add-gnu-debuglink=$LIB.dbg $LIB
done
unset LIB save_lib save_usrlib

find /usr/lib -type f -name \*.a \
-exec strip --strip-debug {} ';'
find /lib /usr/lib -type f -name \*.so* ! -name \*dbg \
-exec strip --strip-unneeded {} ';'
find /{bin,sbin} /usr/{bin,sbin,libexec} -type f \
-exec strip --strip-all {} ';'
```

* Cleaning Up
```console
rm -rf /tmp/*
logout
chroot "$LFS" /usr/bin/env -i HOME=/root TERM="$TERM" PS1='(lfs chroot) \u:\w\$ ' PATH=/bin:/usr/bin:/sbin:/usr/sbin MAKEFLAGS="-j4" /bin/bash --login
rm -f /usr/lib/lib{bfd,opcodes}.a
rm -f /usr/lib/libctf{,-nobfd}.a
rm -f /usr/lib/libbz2.a
rm -f /usr/lib/lib{com_err,e2p,ext2fs,ss}.a
rm -f /usr/lib/libltdl.a
rm -f /usr/lib/libfl.a
rm -f /usr/lib/libz.a
find /usr/lib /usr/libexec -name \*.la -delete
find /usr -depth -name $(uname -m)-lfs-linux-gnu\* | xargs rm -rf
rm -rf /tools
userdel -r tester
```