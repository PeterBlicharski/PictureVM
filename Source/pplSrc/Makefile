# $Id: Makefile,v 1.2 2002/12/22 01:47:03 ii3839 Exp $ # 

FILE				= testPic
AUX				= $(wildcard *.java)
DEBUG_LEVEL			= 3 

## PATERNS FOR DEBUG INFORMATION
PAT_LEVEL			= [0-$(DEBUG_LEVEL)][\t ]*
PAT_ALL				= [0-9][\t ]*
PAT_DEBUG			= [\t ]*DEBUG[\t ]*
PAT_START_COMMENT		= [\t ]*/\*
PAT_STOP_COMMENT		= \*/[\t ]*
PAT_ACTIVE			= ^\($(PAT_START_COMMENT)$(PAT_DEBUG)$(PAT_ALL)\)$(PAT_STOP_COMMENT)\([a-zA-Z].*\)$$
PAT_DEACTIVE			= ^\($(PAT_START_COMMENT)$(PAT_DEBUG)$(PAT_LEVEL)\)\([a-zA-Z].*\)$(PAT_STOP_COMMENT)$$




all: compile exec

compile:
	clear;
	javac $(FILE).java

exec: 
	clear;
	java $(FILE)

clean: 
	@rm -f *.class *~ *#

debug: nodebug $(AUX)
	@echo "Schalte Debuglevel $(DEBUGLEVEL) ein ...";
	@for X in $(AUX) ; do \
	cat $$X | \
	sed 's|$(PAT_DEACTIVE)|\1*/\2|g' \
	>$$X ; \
	done	

test:	
	@echo $(PAT_ACTIVE) 

nodebug: $(AUX)
	@echo "Schalte alle Debuginformationen aus ...";
	@for X in $(AUX) ; do \
	cat $$X | \
	sed 's|$(PAT_ACTIVE)|\1\2*/|g' \
	>$$X ; \
	done	

co: clean
	cvs commit
