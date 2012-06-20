/* $Id: OPflipV.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPflipH</code>
 * Spiegelt das uebergebene Bild an der Vertikalen, 
 * die das Bild von oben nach unten in der Breite halbiert.
 * Erwartet wird:
 * <ol>
 *   <li>Bild
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPflipV implements OP {
 
    //XXX: Casting richtig stellen!

    /**
     * Leitet die Spiegelung an <code>SingelMatrix.partReverse</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * @return das gespiegelte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.partReverse()));
    }
    
    /**
     * Erzeugt den String "flipVertical", der die Klasse repräsentiert
     *
     * @return flipVertical als <code>String</code>
     */
    public String toString() {
	return "flipVertical";
    }
}
