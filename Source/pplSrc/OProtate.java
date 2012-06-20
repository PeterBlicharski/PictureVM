/* $Id: OProtate.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OProtate</code>
 * Dreht das uebergebene Bild um 180 Grad.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OProtate implements OP {
 
    //XXX: Casting richtig stellen!

    /**
     * Leitet die Drehung an <code>SingelMatrix.reverse</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return das gedrehte Bild als <code>MachineValue</code>
     */
  public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.reverse()));
    }
    
    /**
     * Erzeugt den String "rotate", der die Klasse repräsentiert
     *
     * @return rotate als <code>String</code>
     */
    public String toString() {
	return "rotate";
    }
}
