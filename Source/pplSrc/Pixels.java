/* $Id: Pixels.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.picture;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.lang.RuntimeException;
import java.io.IOException;

/**
 * Describe class <code>Pixels</code> here.
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a>
 * @author Malte Hopmann
 * @version 1.0
 */
public class Pixels {
    

    /**
     * Describe variable <code>tail</code> here.
     *
     */
    public Matrix tail;
    /**
     * Describe variable <code>bitSize</code> here.
     *
     */
    public byte bitSize;
    /**
     * Describe variable <code>amount</code> here.
     *
     */
    public int amount;
    /**
     * Describe variable <code>bufferSize</code> here.
     *
     */
    public static int bufferSize = 8129;

    /**
     * Creates a new <code>Pixels</code> instance.
     *
     * @param bitSize a <code>byte</code> value
     * @param amount an <code>int</code> value
     */
    public Pixels (byte bitSize, int amount) {
	this.bitSize = bitSize;
	this.amount = amount;
    }
    
    /**
     * Describe <code>readPixels</code> method here.
     *
     * @param io a <code>BufferedInputStream</code> value
     * @return a <code>Pixels</code> value
     */
    public Pixels readPixels(BufferedInputStream io) {
	int byteRead = 0;
	byte[] buffer = new byte[bufferSize];
	
	for (int totalRead= 0; totalRead < amount*bitSize;) {
	    try {
		byteRead = io.read(buffer,0,bufferSize);
	    } catch (IOException e) {
		System.out.println("Could not read from file");		
	    }
	    if (byteRead + totalRead > amount) {
		byteRead = byteRead - (totalRead + byteRead - amount*bitSize); 	    		
	    }
	    convert(buffer,0,byteRead,tail,totalRead,byteRead+totalRead); 
	    totalRead += byteRead;	    
	}
	return this;
	
    }

    
    /**
     * Describe <code>convert</code> method here.
     *
     * @param input[] a <code>byte</code> value
     * @param byteStart an <code>int</code> value
     * @param byteStop an <code>int</code> value
     * @param output a <code>Matrix</code> value
     * @param matrixStart an <code>int</code> value
     * @param matrixStop an <code>int</code> value
     * @return an <code>int</code> value
     */
    public int convert(byte input[],    int byteStart,   int byteStop,
		       Matrix output, int matrixStart, int matrixStop) {
	throw new RuntimeException("convert not implemented");
    }
    
}
