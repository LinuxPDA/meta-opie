DESCRIPTION = "IQNotes is notes kept in a hierarchical(tree like) manner. \
It handles todo, events, sketching. It can acts as a contact, password, \
credit card manager and even more, because is highly configurable. \
Data can be crypted by strong AES algorithm."
SECTION = "opie/applications"
LICENSE = "GPLv2"
HOMEPAGE = "http://iqnotes.berlios.de"
AUTHOR = "Peter Vrabel <kybu@kybu.org>"

S = "${WORKDIR}/iqnotes/iqnotes"

inherit palmtop

QMAKE_PROFILES = "iqnotes.pro"
export OE_QMAKE_LINK="${CXX}"

do_install() {
        install -d ${D}${palmtopdir}/help/html \
		   ${D}${palmtopdir}/bin \
		   ${D}${palmtopdir}/apps/Applications \
		   ${D}${palmtopdir}/pics/iqnotes/items \
		   ${D}${palmtopdir}/iqnotes/icons
        install -m 0755 ${S}/../bin/iqnotes ${D}${palmtopdir}/bin/
        install -m 0644 ${S}/../apps/Applications/*.desktop ${D}${palmtopdir}/apps/Applications/
        install -m 0644 ${S}/../pics/iqnotes/*.png ${D}${palmtopdir}/pics/iqnotes/
        install -m 0644 ${S}/../help/html/iqnotes.html ${D}${palmtopdir}/help/html/
        install -m 0644 ${S}/../pics/*.xpm ${D}${palmtopdir}/pics/
}
