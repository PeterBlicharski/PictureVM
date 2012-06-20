/* $Id: OPpartH.java,v 1.5 2003/01/10 09:01:01 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPpartH</code>
 * Zerteilt ein Bild der Hoehe nach und fuegt die Teilstuecke zu Bildern in einer Liste zusammen.
 * Die jeweils oberste Zeile wird vom UrBild abgeschnitten und aus das naechste Bild in der Liste angehaengt. 
 * Es werden entsprechend des uebergebenen Parameters Bilder in der Liste erzeugt.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild
 *   <li>Partitionswert
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPpartH implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet die Partitionierung des Bildes weiter an SingelMatrix.part(...)
     *
     * @param alle benoetigten Parameter params als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return die Liste mit Bildern als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return ((MVPicture)params[0]).pixel.part(params[1].toInt());
    }
    
    /**
     * Erzeugt den String "partitionHorizontal", der die Klasse repräsentiert
     *
     * @return partitionHorizontal als <code>String</code>
     */
    public String toString() {
	return "partitionHorizontal";
    }
}
