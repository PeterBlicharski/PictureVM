/* $Id: OPbw.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;

/**
 * <code>OPbw</code>
 * Diese Klasse implementiert die Schwar-Weis-Umformung
 * Alle Pixel des eingegebenen Bildes werden auf die Farben 
 * Schwarz und Weis reduziert.
 * Erwartet wird:
 * <ol>
 *   <li>Bild
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 */
public class OPbw extends OPP {

    /**
     * Fuehrt die Reduzierung der Pixel auf Schwarz und Weis durch.
     *
     * @param pixel : Farbwert
     * @return Schwarz oder Weis (0 || 255)
     */
    public double eval (double pixel) {
 	return (pixel > 0.5)?1.0:0.0;
    }
    
    /**
     * Erzeugt den String "blackAndWhite", der die Klasse repräsentiert
     *
     * @return blackAndWhite als <code>String</code>
     */
    public String toString() {
	return "blackAndWhite";
    }
    

} 
