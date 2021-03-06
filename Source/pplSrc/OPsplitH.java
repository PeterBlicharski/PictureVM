/* $Id: OPsplitH.java,v 1.3 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPsplitH</code>
 * 
 * Unterteilt das Bild der Hoehe nach in gleichgrosse Teile und speichert diese als Teilbilder in einer Liste ab.
 * Die Anzahl wird durch den Teilungsfaktor angegeben.
 * Ist die Hoehe nicht durch Teilungsfaktor teilbar, kommt der Uberschuss in das letzte Teilbild.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild
 *   <li>Teilungsfaktor
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPsplitH implements OP {
 
    //XXX: Casting richtig stellen!

    /**
     * Leitet die Unterteilung an <code>SingelMatrix.part</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return das Liste mit Teilbildern als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return ((MVPicture)params[0]).pixel.split(params[1].toInt());
    }
    
    /**
     * Erzeugt den String "splitHorizontal", der die Klasse repräsentiert
     *
     * @return splitHorizontal als <code>String</code>
     */
    public String toString() {
	return "splitHorizontal";
    }
}
