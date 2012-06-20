/* $Id: OPmergeV.java,v 1.4 2003/01/10 08:58:07 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVList;
import ppl.picture.SingleMatrix;

/**
 * <code>OPmergeV</code>
 * Geht eine List mit Bildern durch und nimmt jeweils die linkeste Spalte (der minimalen hoehe aus allen Bildern) 
 * und haengt sie hinten an das neue, zu erstellende Bild an.
 * Ende ist bei der kleinsten Breite aus allen Bildern in der Liste. 
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Liste mit Bildern
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPmergeV implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet die Verschmelzung der Bilder weiter an SingelMatrix.mergeV(...)
     *
     * @param alle benoetigten Parameter params als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return Das verschmelzte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return new MVPicture(SingleMatrix.mergeV((MVList)params[0]));
    }
    
    /**
     * Erzeugt den String "mergeVertical", der die Klasse repräsentiert
     *
     * @return mergeVertical als <code>String</code>
     */
    public String toString() {
	return "mergeVertical";
    }
}





