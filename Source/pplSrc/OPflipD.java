/* $Id: OPflipD.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPflipD</code>
 * Spiegelt das uebergebene Bild an der Diagonalen, 
 * die von links oben nach rechts unten geht.
 * Erwartet wird:
 * <ol>
 *   <li>Bild
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPflipD implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet die Spiegelung an <code>SingelMatrix.transpose</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * @return das gespiegelte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.transpose()));
    }
    
    /**
     * Erzeugt den String "flipDiagonal", der die Klasse repräsentiert
     *
     * @return flipDiagonal als <code>String</code>
     */
    public String toString() {
	return "flipDiagonal";
    }
}
