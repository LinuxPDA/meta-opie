DESCRIPTION = "Scientific calculator with user definable constants and functions."
HOMEPAGE = "http://homepage3.nifty.com/cam/slcalc.htm"
SECTION = "opie/applications"
LICENSE = "GPLv2"
PR = "r2"

APPTYPE = "binary"
APPDESKTOP = "${S}"

SRC_URI = "http://zaufan.net/file_arc/slcalc_1.2.1_arm.tar.gz \
           file://slcalc2.png"

inherit opie

S = "${WORKDIR}/slcalc_source"

LIC_FILES_CHKSUM = "file://LICENSE;md5=53c430d0c3bf57b50b80cbc4d5197540"

do_install() {
	install -d ${D}${palmtopdir}/pics
	install -m 0644 ${WORKDIR}/slcalc2.png ${D}${palmtopdir}/pics/slcalc.png
}

SRC_URI[md5sum] = "3052050235b4bc8fc14d28b8b5e13e49"
SRC_URI[sha256sum] = "c7d7f2fb4a3903dd26a90df358f5757f2637c333cd6f6bf511f506a958349fa1"
