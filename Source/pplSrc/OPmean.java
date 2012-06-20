/* $Id: OPmean.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;

/**
 * <code>OPmean</code>
 * Aus Zwei Bilder wird der Durchschnitt gebildet.
 * Uebereinstimmende Pixel werden dabei normal angezeigt.
 * Aus den unterschiedlichen Pixeln wird das arithmetische Mittel gebildet.
 * Erwartet wird:
 * <ol>
 *   <li>Bild1
 *   <li>Bild2
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPmean extends OP2P implements OP {
    
    /**
     * Bildet das arithmetische Mittel aus zwei Pixeln.
     *
     * @param pixel1 Farbwert
     * @param pixel2 Farbwert 
     * @return berechneter Mittelwert als <code>double</code>
     */
    public double eval (double pixel1, double pixel2){
	return (pixel1 + pixel2) / 2.0;
    }
    
    /**
     * Erzeugt den String "mean", der die Klasse repräsentiert
     *
     * @return mean <code>String</code>
     */
    public String toString() {
	return "mean";
    }
    
} 
