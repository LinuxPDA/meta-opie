require ${PN}.inc

inherit opie_git

SRC_URI = "${OPIE_GIT};protocol=git;subpath=noncore/multimedia/tonleiter;name=first \
           ${OPIE_GIT};protocol=git;subpath=pics \
           ${OPIE_GIT};protocol=git;subpath=apps"
