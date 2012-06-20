/* $Id: OPheight.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVInt;

/**
 * <code>OPheight</code>.
 * Liefert die Hoehe eines Bildes.
 * Erwartet werden: 
 * <ol>
 *   <li>Bild
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPheight implements OP {
  
    //XXX: Casting richtig stellen!

    /**
     * Gibt die Hoehe des uebergebenen Bildes zurueck.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * @return die Hoehe des Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVInt(((MVPicture)params[0]).getHeight()));
    }
    
    /**
     * Erzeugt den String "height", der die Klasse repräsentiert
     *
     * @return height als <code>String</code>
     */
    public String toString() {
	return "height";
    }
}
