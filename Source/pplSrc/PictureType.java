/* $Id: PictureType.java,v 1.2 2003/01/10 07:47:32 ii3839 Exp $ */ 

package ppl.picture;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.RuntimeException;
import java.io.IOException;

/**
 * <code>PictureType</code>
 * Schnittstelle für alle Bildtypen. 
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class PictureType {

    /**
     * Enthält die gelesenen MagicNumber eines Bildes.
     *
     */
    public String magicNumber;
    /**
     * Enthält die gelesenen Breite eines Bildes.
     *
     */
    public int width;
    /**
     * Enthält die gelesenen Hoehe eines Bildes.
     *
     */
    public int height;
    /**
     * Enthält den gelesenen maximalen Farbwert eines Bildes.
     *
     */
    public int maxval;

    /**
     * Describe variable <code>buf</code> here.
     *
     */
    protected byte[] buf;
    /**
     * Describe variable <code>whitespace</code> here.
     *
     */
    public static char[] whitespace = {' ','\t','\n'};
    /**
     * Describe variable <code>bufSize</code> here.
     *
     */
    public static int bufSize = 8129;
    /**
     * Describe variable <code>io</code> here.
     *
     */
    public BufferedInputStream io;

    

    /**
     * Creates a new <code>PictureType</code> instance.
     *
     * @param io a <code>BufferedInputStream</code> value
     */
    public PictureType (BufferedInputStream io) {
	this.io = io;
	this.magicNumber = "";
	this.width = 0;
	this.height = 0;
	this.buf = new byte[1];
    }
    /**
     * Describe <code>isNewline</code> method here.
     *
     * @param ch a <code>char</code> value
     * @return a <code>boolean</code> value
     */
    public boolean isNewline(char ch) {
 	return (ch == '\n')?true:false;
    }
    /**
     * Describe <code>isComment</code> method here.
     *
     * @param ch a <code>char</code> value
     * @return a <code>boolean</code> value
     */
    public boolean isComment(char ch) {
 	return (ch == '#')?true:false;
    }
    /**
     * Describe <code>isWhitespace</code> method here.
     *
     * @param ch a <code>char</code> value
     * @return a <code>boolean</code> value
     */
    public boolean isWhitespace(char ch) {
 	boolean status = false;
 	for (int i = 0; i < whitespace.length; ++i) {
	    status |= (ch == whitespace[i]);
	}
 	return status;
    }

    /**
     * Describe <code>parseString</code> method here.
     *
     * @return a <code>String</code> value
     */
    public String parseString () {
	char temp;
//XXX: andern der Grenzen auf konstanten Wert
	char[] cha = new char[bufSize];
	byte i = 0;
	do {
	    temp = readChar();
	    cha[i] = temp;
	    ++i;
	} while(! isWhitespace(temp) && i < bufSize);
	return String.valueOf(cha,0,i-1);
    }
    
    
    /**
     * Describe <code>parseInteger</code> method here.
     *
     * @return an <code>int</code> value
     */
    public int parseInteger () {
	String temp = parseString();
	try {
	    return Integer.parseInt(temp);
	} catch (NumberFormatException e) {
	    throw new RuntimeException("Fehler: Falsches Pnm-Format");
	}
    }

    /**
     * Describe <code>readChar</code> method here.
     *
     * @return a <code>char</code> value
     */
    public char readChar() {
	try {
	    io.read(buf,0,1);
	} catch (IOException e) {
	    throw new RuntimeException("Could not read from file");
	}
	return (char)buf[0];
    }

    
    
    /**
     * Describe <code>parse</code> method here.
     *
     * @return a <code>BufferedReader</code> value
     */
    public BufferedInputStream parse() {
	throw new RuntimeException("parse not implemented!");
    }

}
