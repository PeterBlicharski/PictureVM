/* $Id: OPinverseDiff.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPinverseDiff</code>
 * Zwei Bilder werden auf Gleichheit/Ungleichheit geprueft.
 * Uebereinstimmende Pixel werden versucht beizubehalten.
 * Die unterschiedlichen Pixel werden ueberlagert.
 * Erwartet wird:
 * <ol>
 *   <li>Bild1
 *   <li>Bild2
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPinverseDiff extends OP2P implements OP {
    
    /**
     * Fuehrt den Gleichheitstest durch.
     *
     * @param pixel1 Farbwert
     * @param pixel2 Farbwert mit dem verglichen werden soll
     * @return berechneter Unterschied als <code>double</code>
     */
    public double eval (double pixel1, double pixel2){
	return MVPicture.toColor(pixel1 + pixel2 - 0.5);
    }
    
    /**
     * Erzeugt den String "inverseDiff", der die Klasse repräsentiert
     *
     * @return inverseDiff als <code>String</code>
     */
    public String toString() {
	return "inverseDiff";
    }
} 
