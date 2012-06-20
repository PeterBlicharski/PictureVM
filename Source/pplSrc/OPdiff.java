/* $Id: OPdiff.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;

/**
 * <code>OPdiff</code>
 * Zwei Bilder werden auf Gleichheit/UNgleichheit geprueft.
 * Uebereinstimmende Pixel werden durch Grau repraesentiert.
 * Aus den unterschiedlichen Pixeln wird die Differenz berechnet, 
 * der maximale Farbwert hinzuaddiert und halbiert
 * Erwartet wird:
 * <ol>
 *   <li>Bild1
 *   <li>Bild2
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPdiff extends OP2P implements OP {
    
    /**
     * Fuehrt den Gleichheitstest durch.
     *
     * @param pixel1 Farbwert
     * @param pixel2 Farbwert mit dem verglichen werden soll
     * @return berechneter Unterschied als <code>double</code>
     */
    public double eval (double pixel1, double pixel2){
	return (pixel1 - pixel2 + 1.0) / 2.0;
    }
    
    /**
     * Erzeugt den String "diff", der die Klasse repräsentiert
     *
     * @return diff als <code>String</code>
     */
    public String toString() {
	return "diff";
    }

} 
