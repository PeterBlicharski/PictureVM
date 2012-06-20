/* $Id: OP2P.java,v 1.7 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.picture.Matrix;
import ppl.picture.SingleMatrix;

/**
 * Describe class <code>OP2P</code> here.
 * Diese Klasse dient als Schittstelle fuer alle Befehle der VM fuer PPL-Befehle, 
 * die auf zwei Bildern arbeiten und diese Pixelweise durch einen Algorithmus zusammenfuegen.
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public abstract class OP2P implements OP 
{
    /**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params alle benoetigten Parameter params als <code>MachineValue[]</code>
     * @return Das neue Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue[] params) {
	
	int width = 0;
	int height = 0;
	width = (int)Math.min((double)((MVPicture)params[0]).getWidth(),
			      (double)((MVPicture)params[1]).getWidth());
	height = (int)Math.min((double)((MVPicture)params[0]).getHeight(),
			       (double)((MVPicture)params[1]).getHeight());
	Matrix temp = new SingleMatrix(width,height);
	for (int j = 0; j < height; ++j) {
	    for (int i = 0; i < width; ++i) {
		temp.setPixel(j * width + i, eval(((MVPicture)params[0]).pixel.getPixel(j*((MVPicture)params[0]).getWidth() + i),
						  ((MVPicture)params[1]).pixel.getPixel(j*((MVPicture)params[1]).getWidth() + i)));
	    }
	}
	return new MVPicture("P5",255,temp);
    }
    
    /**
     * Methode, die einen Algorithmus auf Pixelebene ausfuehrt und somit fuer jedes Pixel aufgerufen wird.
     * Hier sollte die eigenliche Berechnung statt finden. 
     * Die beiden uebergebenen Pixel werden durch den hier stehenden Algorithmus zusammengefuegt
     *
     * @param pixel1 beliebiger Farbwert des ersten Bildes
     * @param pixel2 beliebiger Farbwert des zweiten Bildes
     * @return neu berechneter Farbwert
     */
    public abstract double eval (double pixel1, double pixel2); 
    
    /**
     * Konvertiert den OP-Code in einen String
     * @return den OP-Code als <code>String</code>
     */
    public abstract String toString();
    
}
