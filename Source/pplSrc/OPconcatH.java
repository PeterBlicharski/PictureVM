/* $Id: OPconcatH.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVList;
import ppl.picture.SingleMatrix;

/**
 * <code>OPconcatH</code>
 * Die Bilder in der uebergebenen Liste werden zu einem Bild zusammengefuegt.
 * Das jeweils naechste Bild in der Liste wird rechts an das zusammengefuegte Bild angehaengt.
 * Die kleinste Hoehe aller Bilder in der Liste bestimmte die Groesse des Gesamtbildes.
 * Erwartet wird:
 * <ol>
 *   <li>Liste mit Bildern
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 */
public class OPconcatH implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet die Konkatenation an <code>SingelMatrix.concat</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * @return das konkantenierte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return new MVPicture(SingleMatrix.concat((MVList)params[0]));
    }
    
    /**
     * Erzeugt den String "concatHorizontal", der die Klasse repräsentiert
     *
     * @return concatHorizontal als <code>String</code>
     */
    public String toString() {
	return "concatHorizontal";
    }
}





