DESCRIPTION = "Library to handle bedic dictionary"
HOMEPAGE = "http://bedic.sourceforge.net/"
AUTHOR = "Rafal Mantiuk <rafm@users.sourceforge.net>"
SECTION = "opie/libs"
LICENSE = "GPLv2+"
DEPENDS = "sqlite3"
APPTYPE = "binary"
APPDESKTOP = "${WORKDIR}/zbedic/misc"
FILESEXTRAPATHS_prepend := "${THISDIR}/zbedic:"
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/bedic/libbedic_${PV}-0.tgz;subdir=${BPN}-${PV} \
           file://include-cstdio.patch \
          "

LIC_FILES_CHKSUM = "file://src/dictionary_impl.cpp;beginline=10;endline=22;md5=e977bcc6493c4dff8f273ffe2e458582"

inherit palmtop
# need to override this, because bedic contains exception handling
# pass VERSION as a string \\"${PV}.0\\"
export OE_QMAKE_CXXFLAGS="-fexceptions -fno-rtti ${CXXFLAGS} -DVERSION=\\"${PV}.0\\""

do_configure() {
        qmake -project && qmake -makefile -t lib -spec ${QMAKESPEC} CONFIG=console CONFIG+=staticlib CONFIG+=sharedlib -after \
        TARGET=bedic \
        SOURCES-=src/xerox.cpp OBJECTS-=xerox.o \
        SOURCES-=src/mkbedic.cpp OBJECTS-=mkbedic.o \
        SOURCES-=src/test_dynamic_dictionary.cpp \
}

do_install() {
    install -d ${D}${includedir}
    install -m 0644 ${S}/include/*.h ${D}${includedir}
    install -d ${D}${libdir}
    oe_libinstall -a libbedic ${D}${libdir}
}

FILES_${PN}-dev = "${includedir} ${libdir}"

SRC_URI[md5sum] = "211ea5a881b5691ec7a1aedbe7fc406c"
SRC_URI[sha256sum] = "0cb299278f17d4580d9b1b56df8b7c356afb016f2a68ce7d13a8169f74e2a16b"
