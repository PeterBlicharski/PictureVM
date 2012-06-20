/* $Id: OPinvert.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;

/**
 * <code>OPinvert</code>
 * Diese Klasse invertiert ein gegebenes Bild. Es entsteht das sogenannte negativ.
 * <ol>
 *   <li>Bild
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPinvert extends OPP {
    
    /**
     * Fuehrt die Invertierung durch. 
     * Funktioniert nur bei normalisierten Pixeln.
     *
     * @param pixel steht fuer den Farbwert als <code>double</code>
     * @return den invertierten Farbwert als <code>double</code>
     */
    public double eval (double pixel) {
 	return (1.0 - pixel);
    }
    
    /**
     * Erzeugt den String "invert", der die Klasse repräsentiert
     *
     * @return invert als <code>String</code>
     */
    public String toString() {
	return "invert";
    }
    
} 
