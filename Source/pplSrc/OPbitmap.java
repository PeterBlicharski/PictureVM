/* $Id: OPbitmap.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Describe class <code>OPbitmap</code> here.
 * Diese Klasse fuehrt die Bitmap-Berechnung durch.
 * Das Bild wird auf zwei Werte begrenzt(0 und 1). Es entsteht ein schwarz-weis Bild.
 * Was aber nach einem speziellen Algorithmus berechnet wird, bei dem der vorhergehende Farbwert mit entscheidend ist. 
 * Erwartet werden: 
 * <ol>
 *   <li>Bild
 * </ol>
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPbitmap extends OPP {

    private double s = 0.5;

    /**
     * Fuehrt die Bitmap-Berechnung durch.
     * Gibt immer 0.0 zurück ausser der die letzten addierten Farbwerte ergeben einen Wert, 
     * der hoeher als eins ist. Dann wird 1.0 zurueckgegeben.
     * @param pixel steht fuer den Farbwert
     * @return den Farbwert nach der bitmap-Berechnung als <code>double</code>
     */
    public double eval (double pixel) {
	
	s += pixel;
	
	if (s >= 1.0) {
	    s -= 1.0;
	    return 1.0;
	} 
	return 0.0;	
    }
    

    /**
     * Erzeugt den String "bitmap", der die Klasse repräsentiert
     *
     * @return bitmap als <code>String</code>
     */
    public String toString() {
	return "bitmap";
    }
    

} 
