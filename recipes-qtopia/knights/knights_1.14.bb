DESCRIPTION = "Chess Game for Qt/Embedded based palmtop environments. \
Uses the Phalanx chess engine."
SECTION = "opie/games"
LICENSE = "GPLv2"
DEPENDS = "phalanx"
RDEPENDS_${PN} = "phalanx"
PR = "r3"

SRC_URI = "http://www.openzaurus.org/mirror/knights.tar.gz \
           file://libqpe-opie.patch \
           file://gcc3.patch"
S = "${WORKDIR}/knights"

LIC_FILES_CHKSUM = "file://knights/knights.cpp;beginline=9;endline=16;md5=8e0469de3d41b77e1dbbd8a6c242bd8d"

inherit palmtop

QMAKE_PROFILES = "knights.pro"

do_configure_prepend() {
        printf "TEMPLATE=subdirs\nSUBDIRS=qtcompat microkde knights\n" >knights.pro
}

do_install() {
        install -d ${D}${palmtopdir}/bin \
	           ${D}${palmtopdir}/apps/Games \
       	 	   ${D}${palmtopdir}/pics
        install -D -m 755 knights/knights ${D}${palmtopdir}/bin/knights
        install -D -m 644 knights.desktop ${D}${palmtopdir}/apps/Games/knights.desktop
        install -d ${D}${palmtopdir}/pics
        cp -pPR pics/knights ${D}${palmtopdir}/pics/
}

SRC_URI[md5sum] = "fea3047d5501a1abea868bb661cbc0c8"
SRC_URI[sha256sum] = "1f6d50b3602f01b852810ab1e62f3328edee5130fe3ba21fd868f376c89e66fd"
