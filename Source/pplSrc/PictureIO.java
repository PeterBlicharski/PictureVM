/* $Id: PictureIO.java,v 1.9 2003/01/10 07:47:32 ii3839 Exp $ */ 

package ppl.picture;

import ppl.mv.MVPicture;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * <code>PictureIO.java</code>
 * Klasse um Bilder zu lesen und zu schreiben.
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */


public class PictureIO {
    
    
    /**
     * Instanz zum einlesen des Headers.
     * Alle notwendigen Methoden und Eigenschaften, 
     * um einen Header einzulesen stehen hier. 
     */
    public static PictureType header;

    /**
     * Realisiert das Einlesen der Pixel.  
     * Je nach Header wird das richtige Objekt zu gewiesen. 
     */
    public static Pixels rest;


    /**
     * Erstellt eine Instanz von <code>PictureIO</code>.
     *
     */
    public PictureIO() {
    }
    

    /**
     * Laedt ein Bild aus einer Datei.
     *
     * @param fileName ist der Name der Datei mit Pfadangabe.
     * @return gelesene Bild als <code>MVPicture</code>.
     */
    public static MVPicture loadFromFile(String fileName) {
	
	BufferedInputStream input = null;
	MVPicture temp = null;
	
	try {
	    input = new BufferedInputStream(new FileInputStream(fileName));
	} catch (FileNotFoundException e) {
	    throw new RuntimeException("Picture not found!");
	}
	header = new PnmPicture(input);
	input = header.parse();
	rest = new PnmRawGreyPixels(header.width,header.height,header.maxval);
	rest = rest.readPixels(input);
	try {
	    input.close();
	} catch (IOException e) {
	    throw new RuntimeException("Could not close Picture");
	}
	temp =  new MVPicture(header.magicNumber,header.maxval,rest.tail);
	temp.normalize();
	return temp;
    }
    

    /**
     * Speichern eines Bildes in eine PGM-Datei (raw)
     *
     * @param fileName ist der Name der Datei mit Pfadangabe
     * @param pic das zu speichernde Bild 
     * @return das zu speichernde Bild wird zurück gegeben als <code>MVPicture</code>
     */
    public static MVPicture storeToFile(String fileName, MVPicture pic) {
	
	BufferedOutputStream output = null;	
	MVPicture tempPic = pic;

	pic.unnormalize();
	try {
	    output = new BufferedOutputStream(new FileOutputStream(fileName));
	} catch (IOException e) {
	    throw new RuntimeException("Can not open file");
	}
	output = PnmSave.writeHeader(output,pic);
	output = PnmSave.writePixels(output,pic.pixel.getPixelAsSingleArray());
 	try {
 	    output.close();
 	} catch (IOException e) {
 	    throw new RuntimeException("Could not close Picture");
 	}
	return pic;
    }

} 
    
