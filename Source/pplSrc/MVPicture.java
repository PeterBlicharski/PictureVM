/* $Id: MVPicture.java,v 1.16 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.mv;

import ppl.op.OPP;
import ppl.picture.Matrix;
import ppl.picture.SingleMatrix;

/**
 * <code>MVPicture</code>
 * Implementierung des Datentyps MVPicture. Dieser wird für die Verwaltung von
 * Bildern benoetigt.
 *
 * @author Malte Hopmann
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a>
 * @version 1.0
 */
public
class MVPicture extends MachineValue
{

    /*  */
    public
    String magicNumber;

    /* Hoehe des Bildes */
    public
    int maxVal;

    public
    Matrix pixel;

    /* wird noch private gemacht...*/
    /**
     * Creates a new <code>MVPicture</code> instance.
     *
     * @param height an <code>int</code> value
     * @param width an <code>int</code> value
     * @param picture a <code>char[]</code> value
     */
    public
    MVPicture(Matrix picture) {		
	this.magicNumber = "P5";
	this.maxVal = 255;
	this.pixel = picture;
    }


    public
    MVPicture(String magicNumber, int maxVal, Matrix picture) {		
	this.magicNumber = magicNumber;
	this.maxVal = maxVal;
	this.pixel = picture;
    }

    
    
    public 
    static
    MVPicture makeEmpty()
   	{
   	    return new MVPicture("",0,null);
   	}
    
    
    
		
//     public
//     Object getValue()
// 	{
// 	    /* unnvollstaendig */
// 	    return null;
// 	}
	
    /* Dupliziern eines Bildes */	
    public MachineValue copy()	{	
	return new MVPicture(this.magicNumber, 
			     this.maxVal, 
			     this.pixel.cloneMatrix());
    }

    public int getWidth() {
	return pixel.getWidth();
    }
    

    public int getHeight() {
	return pixel.getHeight();
    }

   
    public MVPicture normalize () {
	int anzahl = this.pixel.getWidth() * this.pixel.getHeight();
	
	for (int i = 0; i < anzahl; ++i) {
	    pixel.setPixel(i,pixel.getPixel(i)/maxVal);
	}
	return this;
	
    }
    
    public MVPicture unnormalize () {
	int anzahl = this.pixel.getWidth() * this.pixel.getHeight();
	
	for (int i = 0; i < anzahl; ++i) {
	    pixel.setPixel(i,pixel.getPixel(i)*maxVal);
	}
	return this;
    }
    

    public MVPicture forAllPixel (OPP compute) {
	
	int anzahl = this.pixel.getWidth() * this.pixel.getHeight();
	
	for (int i = 0; i < anzahl; ++i) {
	    pixel.setPixel(i,compute.eval(pixel.getPixel(i)));
	}
	return this;
    }

    
    /* Funktion zur String-Konvertierung. Kann zum Tracen verwendet werden. 
     */	
    /**
     * Describe <code>toString</code> method here.
     *
     * @return a <code>String</code> value
     */
    public String toString() {
	return "MVPicture: ";
    }



    public static double toColor(double pixel) {
	return Math.max(Math.min(pixel,1.0),0.0);
    }

    
    public static MVPicture makeBlackPic(int width, int height) {
	SingleMatrix pic = new SingleMatrix(width,height);
	for ( int i = 0; i < height * width; ++i) {
	    pic.setPixel(i, 0.0);
	}
	return new MVPicture("P5", 255, pic);
    }
    

    public static MVPicture makeWhitePic(int width, int height) {
	SingleMatrix pic = new SingleMatrix(width,height);
	for ( int i = 0; i < height * width; ++i) {
	    pic.setPixel(i, 1.0);
	}
	return new MVPicture("P5", 255, pic);
    }	


    public static MVPicture makeGreyPic(double color, int width, int height) {
	double newColor = toColor(color);
	int newWidth = (width >= 0)?width:0; 
	int newHeight = (height >= 0)?height:0; 
	SingleMatrix pic = new SingleMatrix(newWidth,newHeight);
	
	for ( int i = 0; i < newHeight * newWidth; ++i) {
	    pic.setPixel(i, newColor);
	}
	return new MVPicture("P5", 255, pic);
    }	
    
    
    public static byte[] intToByteArray(int intValue) {
	return ((new String(Integer.toString(intValue))).getBytes());
    }

    
    public static byte[] strToByteArray(String strValue) {
	return (strValue.getBytes());
	
    }
    
    
}    
