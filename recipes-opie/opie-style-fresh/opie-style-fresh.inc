DESCRIPTION = "Opie widget style"
SECTION = "opie/styles"
LICENSE = "GPLv2"
# FIXME stopgap until split archives have license files included
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
APPNAME = "freshstyle"


S = "${WORKDIR}/fresh"

inherit opie

# FILES plugins/styles/libfreshstyle.so*
do_install() {
}

