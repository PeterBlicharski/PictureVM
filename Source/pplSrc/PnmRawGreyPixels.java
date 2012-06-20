/* $Id: PnmRawGreyPixels.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.picture;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * Describe class <code>PnmRawPixels</code> here.
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a>
 * @author Malte Hopman
 * @version 1.0
 */
public class PnmRawGreyPixels extends PnmPixels {


    /**
     * Creates a new <code>PnmRawGreyPixels</code> instance.
     *
     * @param width an <code>int</code> value
     * @param height an <code>int</code> value
     * @param max an <code>int</code> value
     */
    public PnmRawGreyPixels (int width, int height,int max) {
	super(width,height,max);
	tail = new SingleMatrix(width,height);
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
	
	int max = byteStop;
	int temp = 0;
	boolean throwException = false;

	// Verhindert ArrayOutOfBounce Exception bei output
	if ( byteStop - byteStart > matrixStop - matrixStart) {
	    max = byteStart+(matrixStop-matrixStart);
	    throwException = true;
	}
	int matrixOff = matrixStart;
	for (int byteOff = byteStart; byteOff < max;) {
	    output.setPixel(matrixOff++, (double) MAP[input[byteOff++]+128]);
	    temp = matrixOff;
	}
	if (throwException) {
	    throw new RuntimeException("Fehler beim konvertieren der Pixel");
	}
	
	return matrixOff - matrixStart;
    }
}
