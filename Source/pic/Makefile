
FILE				= testPic
AUX				= $(wildcard *.java)
DEBUG_LEVEL			= 1 

## PATERNS FOR DEBUG INFORMATION
PAT_LEVEL			= [0-$(DEBUG_LEVEL)]
PAT_ALL				= [0-9]
PAT_DEBUG			= [ ]*DEBUG[ ]*
PAT_START_COMMENT		= [ ]*/\*
PAT_STOP_COMMENT		= \*/[ ]*
PAT_ACTIVE			= \($(PAT_START_COMMENT)$(PAT_DEBUG)$(PAT_ALL)\)i$(PAT_STOP_COMMENT)\([a-zA-Z(].*\)$$
PAT_DEACTIVE			= \($(PAT_START_COMMENT)$(PAT_DEBUG)$(PAT_LEVEL)\)\([a-zA-Z(].*\)$(PAT_STOP_COMMENT)$$



all: clean compile exec

compile:
	clear;
	javac $(FILE).java

exec: 
	clear;
	java $(FILE)

clean: 
	@rm -f *.class *~ *#

debug: $(AUX)
	@for X in $(AUX) ; do \
	cat $$X | \
	sed 's|$(PAT_DEACTIVE)|\1*/\2|g' \
	>$$X ; \
	done	

nodebug: $(AUX)
	@for X in $(AUX) ; do \
	cat $$X | \
	sed 's|$(PAT_ACTIVE)|\1\2*/|g' \
	>$$X ; \
	done	
