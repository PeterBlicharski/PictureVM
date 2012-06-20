/* $Id: OPmergeH.java,v 1.4 2003/01/10 08:58:07 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVList;
import ppl.picture.SingleMatrix;

/**
 * <code>OPmergeH</code>
 * Geht eine List mit Bildern durch und nimmt jeweils die oberste Zeile (der minimalen Breite aus allen Bildern)
 * und haengt sie hinten an das neue, zu erstellende Bild an. 
 * Ende ist bei der kleinsten Hoehe aus allen Bildern in der Liste. 
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Liste mit Bildern
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPmergeH implements OP {
 
    //XXX: Casting richtig stellen!

    /**
     * Leitet die Verschmelzung der Bilder weiter an SingelMatrix.merge(...)
     *
     * @param alle benoetigten Parameter params als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return Das verschmelzte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return new MVPicture(SingleMatrix.merge((MVList)params[0]));
    }

    /**
     * Erzeugt den String "mergeHorizontal", der die Klasse repräsentiert
     *
     * @return mergeHorizontal als <code>String</code>
     */
    public String toString() {
	return "mergeHorizontal";
    }
}





