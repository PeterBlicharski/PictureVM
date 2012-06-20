/* $Id: OPscale.java,v 1.3 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVInt;

/**
 * <code>OPscale</code>
 * Skaliert das Bild um den uebergebenen Faktor x in der Breite und um y in der Hoehe
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild
 *   <li>x-Faktor
 *   <li>y-Faktor
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPscale implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet die Skalierung an <code>SingelMatrix.scale</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return das skalierte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.scale(((MVInt)params[1]).toInt(),
								 ((MVInt)params[2]).toInt())));
    }
    /**
     * Erzeugt den String "scale", der die Klasse repräsentiert
     *
     * @return scale als <code>String</code>
     */
    public String toString() {
	return "scale";
    }
}
