/* $Id: OPreduceColor.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPreduceColor</code>
 * Reduziert die Anzahl der Farben auf den uebergebenen Integerwert.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild
 *   <li>Anzahl an Farben
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPreduceColor extends OPP {

    /**
     * Fuehrt die Reduzierung durch.
     * 
     * @param pixel steht fuer den Farbwert
     * @return der reduzierte Farbwert
     */
    public double eval (double pixel) {
 	return redColor(Math.max((double)params[1].toInt(),2.0),pixel);
    }

    private double redColor(double color, double pixel) {
	return MVPicture.toColor(Math.floor(pixel * (double)color)/((double)color - 1.0));
    }
    
    /**
     * Erzeugt den String "reduceColor", der die Klasse repräsentiert
     *
     * @return reduceColor als <code>String</code>
     */
    public String toString() {
	return "reduceColor";
    }
    


} 
