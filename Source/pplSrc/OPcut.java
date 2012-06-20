/* $Id: OPcut.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVInt;
/**
 * <code>OPcut</code>
 * An der Positon x,y des uebergebenen Bildes wird ein Teilbild der gegebenen Breite und Hoehe
 * ausgeschnitten. Sollte der Ausschnitt ueber dieGrenzen des Orginalbildes gehen, 
 * dann wird nur bis zur Grenze geschitten.
 * Erwartet wird:
 * <ol>
 *   <li>Bild
 *   <li>Breite
 *   <li>Hoehe
 *   <li>x - Position
 *   <li>y - Position 
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 */
public class OPcut implements OP {
 
    //XXX: Casting richtig stellen!

    /**
     * Leitet das Ausschneiden an <code>SingelMatrix.cut</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * @return das ausgeschnitte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.cut(((MVInt)params[3]).toInt(),
							       ((MVInt)params[4]).toInt(),
							       ((MVInt)params[1]).toInt(),
							       ((MVInt)params[2]).toInt())));
    }
    
    /**
     * Erzeugt den String "cut", der die Klasse repräsentiert
     *
     * @return cut als <code>String</code>
     */
    public String toString() {
	return "cut";
    }
}
