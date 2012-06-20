# $Id: Makefile,v 1.17 2003/01/10 09:08:08 ii3839 Exp $

############################################################
#                         CVS
#

doc_dir			= ./Documentation
source_dir		= ./Source
main_dir		= ../

## Global
USER			=  cat CVS/Root | sed 's|:[^:]*:\([^@]*\)@.*|\1|'
CVS_GROUP		= swp02
CVS_ROOT		= ./CVS/Root

## CVS Pserver - String
SERVER			= :pserver:
LOGID			= @stud.fh-wedel.de:/home/cvs
PSERVER			= $(SERVER)`$(USER)`$(LOGID)

## Source Directory
CVS_DIR			= uebungen/swp/$(CVS_GROUP)


all: uninstall install doc compile 

install:
	cd $(source_dir) && $(MAKE) install

uninstall:
	rm -f $(doc_dir)/JavaDoc/ -R
	cd $(source_dir) && $(MAKE) uninstall
	
doc:
	cd $(source_dir) && $(MAKE) doc 


compile: 
	cd $(source_dir) && $(MAKE) compile


clean:
	cd $(doc_dir) && $(MAKE) clean
	cd $(source_dir) && $(MAKE) clean
	rm -f ./*~ ./*#


login:
	@echo "Starte cvs login..."
	@if [ -e $(CVS_ROOT) ] ; then \
		(cvs -d $(PSERVER) login);\
	else echo "Bitte CVS-User eingeben:\n"; read user; \
	cvs -d $(SERVER)$$user$(LOGID) login; fi;

update:
	@cvs update

commit: 
	@cvs commit

co: 
	@echo "Starte checkout (ziel: ../swp022) .."
	(cd  $(main_dir) && cvs -d $(SERVER)ii3839$(LOGID) co -d swp022 $(CVS_DIR))

	cd $(doc_dir) && $(MAKE) 


