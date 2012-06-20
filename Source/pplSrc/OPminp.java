/* $Id: OPminp.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;

/**
 * <code>OPminp</code>
 * Aus zwei Bildern werden die uebereinander liegenden Pixel auf minimal Wert geprueft unf uebergeben.
 * Herauskommt ein Bild das aus beiden Urbildern die minimalen Pixel enthaelt (dunkelsten).
 * Erwartet wird:
 * <ol>
 *   <li>Bild1
 *   <li>Bild2
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPminp extends OP2P implements OP {
    
        
    /**
     * Fuehrt den Mintest durch.
     *
     * @param pixel1 Farbwert
     * @param pixel2 Farbwert mit dem verglichen werden soll
     * @return berechneter minimaler Farbwert als <code>double</code>
     */
    public double eval (double pixel1, double pixel2){
	return (pixel1 <= pixel2)?pixel1:pixel2;
    }
    
    /**
     * Erzeugt den String "minp", der die Klasse repräsentiert
     *
     * @return minp <code>String</code>
     */
    public String toString() {
	return "minp";
    }


} 
