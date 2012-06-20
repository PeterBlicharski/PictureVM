/* $Id: OPabove.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPabove</code>
 * Das zweite Bild wird vor das erste geschoben, 
 * sodass ein neues mit beiden aneinander gehaengten Bildern entsteht.
 * Erwartet werden: 
 * <ol>
 *   <li>Gamma - Wert
 *   <li>Bild 1 (unten)
 *   <li>Bild 2 (oben)
 * </ol>
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPabove implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params alle benoetigten Parameter params als <code>MachineValue[]</code>
     * @return Das neue Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.above(((MVPicture)params[1]).pixel)));
    }
    
    /**
     * Erzeugt den String "above", der die Klasse repräsentiert
     *
     * @return above als <code>String</code>
     */
    public String toString() {
	return "above";
    }
}
