/* $Id: PnmPicture.java,v 1.1 2002/12/02 23:22:55 ii3839 Exp $ */ 
// /*DEBUG */4System.out.println("\t\t\t\t"); 
// /*DEBUG */3System.out.println("\t\t\t"); 
// /*DEBUG */2System.out.println("\t\t"); 
// /*DEBUG 1*/System.out.println("\t"); 
// /*DEBUG 0*/System.out.println(""); 

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.*;
import java.lang.RuntimeException;

class PnmPicture implements PnmStates{

    private String magicNumber;
    private int width;
    private int height;
    private int maxval;
    
    protected byte[] buf;

    private static char[] whitespace = {' ','\t','\n'};

    private BufferedInputStream io;
    
    
    public PnmPicture (BufferedInputStream io) {
	this.io = io;
	this.width = 0;
	this.height = 0;
	this.maxval = 0;
	this.buf = new byte[1];
    }

    private boolean isNewline(char ch) {
 	return (ch == '\n')?true:false;
    }

    private boolean isComment(char ch) {
 	return (ch == '#')?true:false;
    }

    private boolean isWhitespace(char ch) {
 	/*DEBUG */3System.out.println("\t\t\tTeste >>"+ch+"<< auf Leerzeichen"); 
 	boolean status = false;
 	for (int i = 0; i < whitespace.length; ++i) {
	    status |= (ch == whitespace[i]);
	    /*DEBUG */4System.out.println("\t\t\t\tisWhitespace: "+status); 
	}
	/*DEBUG */3System.out.println("\t\t\tErgebnis: "+status); 
 	return status;
    }

    private void readMaxVal() {
	throw new RuntimeException("Not implemented yet!");
    }

    private void readHeight() {
	throw new RuntimeException("Not implemented yet!");
    }


    private void readWidth() {
	throw new RuntimeException("Not implemented yet!");
    }

    private boolean readComment () {
	char temp;
	boolean status = true;
	io.mark(1);
	temp = readChar();
	if (! isComment(temp)) {
	    try {
		io.reset();
	    } catch (IOException e) {
		System.out.println("Fehler: "+e);
	    }
	    temp = '\n';
	    status = false;
     	} 	
 	/*DEBUG */2System.out.println("\t\tLese Kommentar"); 
	/*DEBUG */3System.out.print("\t\t\tKommentartext: "); 
	while (! isNewline(temp)) {
	    temp = readChar();
	    /*DEBUG */3System.out.print(temp); 
	}
	/*DEBUG */2System.out.println("\t\t\t"); 
	return status;
    }
    
    private String parseString () {
	char temp;
	char[] cha = new char[23];
	byte i = 0;
	do {
	    temp = readChar();
	    cha[i] = temp;
	    ++i;
	} while(! isWhitespace(temp));
	return String.valueOf(cha,0,i-1);
    }
    
    
    private int parseInteger () {
	String temp = parseString();
	try {
	    return Integer.parseInt(temp);
	} catch (NumberFormatException e) {
	    System.out.println("Fehler: Falsches Pnm-Format");
	}
	return 0;
    }

    private char readChar() {
	/*DEBUG */4System.out.println("\t\t\t\tLese char aus Stream");
	try {
	    io.read(buf,0,1);
	} catch (IOException e) {
		System.out.println("Could not read from file");
	}
	/*DEBUG */4System.out.println("\t\t\t\tGelesen: "+new String(buf));
	return (char)buf[0];
    }

    
    
    public BufferedInputStream parse() {
	
	int state = PnmStates.magic;
	while (state != PnmStates.end) {
	    switch (state) {
		case PnmStates.magic : while (readComment());
		    /*DEBUG */2System.out.println("\t\tLese Magicnumber"); 
		    this.magicNumber = new String(parseString());
		    /*DEBUG */2System.out.println("\t\tMagicNumber: "+this.magicNumber); 
		    state = PnmStates.wid;
		    break;
		case PnmStates.wid : while (readComment());
		    /*DEBUG */2System.out.println("\t\tLese Breite des Bildes"); 
		    this.width = parseInteger();
		    /*DEBUG */2System.out.println("\t\tBreite: "+width); 
		    state = PnmStates.hei;
		    break;
		case PnmStates.hei : while (readComment());
		    /*DEBUG */2System.out.println("\t\tLese L�nge des Bildes"); 
		    this.height = parseInteger();
		    /*DEBUG */2System.out.println("\t\tL�nge: "+height); 
		    state = PnmStates.maxv;
		    break;
		case PnmStates.maxv : while (readComment());
		    /*DEBUG */2System.out.println("\t\tLese maximalen Farbwert!"); 
		    this.maxval = parseInteger();
		    /*DEBUG */2System.out.println("\t\tMax Value: "+maxval); 
		    state = PnmStates.end;
		    break;
	    }
	}
	/*DEBUG */2System.out.println("\tHeader gelesen "); 
 	return this.io;
    }


}
