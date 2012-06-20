/* $Id: OPflipH.java,v 1.6 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPflipH</code>
 * Spiegelt das uebergebene Bild an der Horizontalen, 
 * die das Bild von links nach rechts in der Hoehe halbiert.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPflipH implements OP {
 
    //XXX: Casting richtig stellen!

    /**
     * Leitet die Spiegelung an <code>SingelMatrix.reverse</code> und dann an 
     * <code>SingelMatrix.partReverse</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return das gespiegelte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	MVPicture temp = new MVPicture(((MVPicture)params[0]).magicNumber,
				       ((MVPicture)params[0]).maxVal,
				       ((MVPicture)params[0]).pixel.reverse());
	temp.pixel = temp.pixel.partReverse();
	return temp;
    }
    
    /**
     * Erzeugt den String "flipHorizontal", der die Klasse repräsentiert
     *
     * @return flipHorizontal als <code>String</code>
     */
    public String toString() {
	return "flipHorizontal";
    }
}
