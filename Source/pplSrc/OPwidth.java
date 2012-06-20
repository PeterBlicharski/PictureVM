/* $Id: OPwidth.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVInt;

/**
 * <code>OPwidth</code>.
 * Liefert die Breite eines Bildes.
 * Erwartet werden: 
 * <ol>
 *   <li>Bild
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPwidth implements OP {
 
    //XXX: Casting richtig stellen!

    /**
     * Gibt die Breite des uebergebenen Bildes zurueck.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * @return die Breite des Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVInt(((MVPicture)params[0]).getWidth()));
    }
    
    /**
     * Erzeugt den String "width", der die Klasse repräsentiert
     *
     * @return width als <code>String</code>
     */
    public String toString() {
	return "width";
    }
}
