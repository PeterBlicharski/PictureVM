/* $Id: OPgamma.java,v 1.9 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPgamma</code>.
 * Diese Klasse fuehrt die Gamma - Berechnung durch.
 * Erwartet werden: 
 * <ol>
 *   <li>Bild
 *   <li>Gamma - Wert
 * </ol>
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPgamma extends OPP {

    /**
     * Fuehrt die gamma-Berechnung durch.
     * 
     * @param pixel steht fuer den Farbwert
     * @return den Farbwert nach der gamma-Berechnung als <code>double</code>
     */
    public double eval (double pixel) {
 	if (pixel != 0.0) {
 	    pixel = Math.pow(pixel,1/params[1].toFloat());
 	}
	return pixel;
    }
    
    /**
     * Erzeugt den String "gamma", der die Klasse repräsentiert
     *
     * @return gamma als <code>String</code>
     */
    public String toString() {
	return "gamma";
    }

} 
