/* $Id: OPconcatV.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVList;
import ppl.picture.SingleMatrix;

/**
 * <code>OPconcatV</code>
 * Konkateniert mehrer Bilder aus einer Liste zu einem Bild.
 * Die Bilder werden untereinander in der Reihenfolge der Listenposition aneinandergehaengt.
 * Erwartet wird:
 * <ol>
 *   <li>Liste mit Bildern
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPconcatV implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet die Konkatenation an <code>SingelMatrix.concatH</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * @return das konkantenierte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return new MVPicture(SingleMatrix.concatV((MVList)params[0]));
    }
    
    /**
     * Erzeugt den String "concatVertical", der die Klasse repräsentiert
     *
     * @return concatVertical als <code>String</code>
     */
    public String toString() {
	return "concatVertical";
    }
}





