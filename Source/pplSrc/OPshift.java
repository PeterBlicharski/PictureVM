/* $Id: OPshift.java,v 1.3 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVInt;

/**
 * <code>OPshift</code>
 * Schiebt den Bild Ausschnitt um den Faktor-x nach links(-x)/rechts(+x) 
 * und um den Faktor y nach oben(-y)/unten(+y).
 * Frei gewordener Platz wird mit schwarz gefuellt.
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
public class OPshift implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet die Verschiebung an <code>SingelMatrix.shift</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return das verschobene Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.shift(((MVInt)params[1]).toInt(),
								 ((MVInt)params[2]).toInt())));
    }
    
    /**
     * Erzeugt den String "shift", der die Klasse repräsentiert
     *
     * @return shift als <code>String</code>
     */
    public String toString() {
	return "shift";
    }
}
