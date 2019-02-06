## Simple and dirty java make file by Bilel
## Sould used com.***** as a package name for the main

JFLAGS = -g -d .
JC = javac
JR = java
DECK = deck.txt
.SUFFIXES: .java .class
.java.class:
	$(info compiling your software)
	$(JC) $(JFLAGS) $*.java

CLASSES = \
        ./src/Memory.java \
        ./src/Io.java \
        ./src/Cpu.java \
        ./src/Cardiac.java \
        ./src/Main.java


default: classes

classes: $(CLASSES:.java=.class)
	$(info ====================================================)
	$(info To run the emulator use the following command:)
	$(info 		make run DECK=<deck_file_name.txt>)
	$(info ====================================================)


PACKAGE_NAME = com.xobx
MAIN_CLASS= Main

run: 
	$(info running your app)
	$(JR) $(PACKAGE_NAME).$(MAIN_CLASS) $(DECK)
	

clean:
	$(info Deleting the sources)
	$(RM) -r com
