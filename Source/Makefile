# $Id: Makefile,v 1.16 2003/01/10 09:15:11 ii3839 Exp $

ppl_dir 	= ./ppl/
ppl_file	= wavelet
ppl_file2	= pictest
ppl_file3	= example

doc_dir		= ../Documentation/JavaDoc/

package= ppl ppl.picture ppl.op ppl.mv ppl.syscalls ppl.machine 

all: clean uninstall install compile test exec

doc:
	mkdir -p $(doc_dir)
	javadoc -d $(doc_dir) PPL.java $(package)

compile: clean
	clear; 
	javac PPL.java;	

install: uninstall
	@printf "\nInstall.......\n"
	mkdir ppl
	mkdir ppl/picture
	mkdir ppl/op
	mkdir ppl/mv
	mkdir ppl/machine
	mkdir ppl/syscalls
	mkdir ppl/instr
#OP
	cp pplSrc/OP*.java 		ppl/op/
#SYSCALLS
	cp pplSrc/SYS*.java 		ppl/syscalls/
#MACHINE
	cp pplSrc/Mem.java 		ppl/machine/
	cp pplSrc/Frames.java 		ppl/machine/
	cp pplSrc/MachineState.java 	ppl/machine/
	cp pplSrc/PC.java 		ppl/machine/
	cp pplSrc/Status.java 		ppl/machine/
	cp pplSrc/TypedStack.java 	ppl/machine/
#MV
	cp pplSrc/MV*.java 		ppl/mv/	
	cp pplSrc/MachineValue.java	ppl/mv/
#INSTR
	cp pplSrc/Instr*.java 		ppl/instr/
#PICTURE
	cp pplSrc/Pnm*.java 		ppl/picture/
	cp pplSrc/Picture*.java		ppl/picture/	
	cp pplSrc/Matrix.java		ppl/picture/	
	cp pplSrc/SingleMatrix.java	ppl/picture/	
	cp pplSrc/Pixels.java		ppl/picture/	
#MAIN
	cp pplSrc/Executable.java	ppl/
	cp pplSrc/Instr.java		ppl/
	cp pplSrc/Opcodes.java		ppl/
	rm -f ppl/instr/Instr.java

#MAIN
	cp pplSrc/$(ppl_file).java pplSrc/$(ppl_file2).java pplSrc/$(ppl_file3).java   ppl/

uninstall:
	@printf "\nUninstall.......\n"
	rm -f ./ppl/ -R

test:
	javac ppl/wavelet.java
	javac ppl/pictest.java
	javac ppl/example.java

exec:
	java -ms18m -mx64m PPL $(ppl_file3) 	
	java -ms18m -mx64m PPL $(ppl_file2)  	
	java -ms18m -mx64m PPL $(ppl_file) lena	

clean:
	rm -f *class *~ *#;
	rm -f ./ppl/exec/*class ./ppl/exec/*~ ./ppl/exec/*#
	rm -f ./ppl/op/*class ./ppl/op/*~ ./ppl/op/*#
	rm -f ./ppl/mv/*class ./ppl/mv/*~ ./ppl/mv/*#
	rm -f ./ppl/machine/*class ./ppl/machine/*~ ./ppl/machine/*#
	rm -f ./ppl/instr/*class ./ppl/instr/*~ ./ppl/instr/*#
	rm -f ./ppl/picture/*class ./ppl/picture/*~ ./ppl/picture/*#
	rm -f ./ppl/syscalls/*class ./ppl/syscalls/*~ ./ppl/syscalls/*#

co: clean
	cvs commit
















