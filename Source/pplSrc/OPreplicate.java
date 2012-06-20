/* $Id: OPreplicate.java,v 1.4 2003/01/10 08:58:07 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVInt;

/**
 * <code>OPreplicate</code>
 * Vervielfaeltigt ein Bild und erzeugt daraus ein neues.
 * Ueber die Parameter wird angegeben, wie oft das Bild in der Breite und in der Hoehe 
 * repliziert werden soll.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild
 *   <li>Anzahl in Breite
 *   <li>Anzahl in Hoehe
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPreplicate implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet das replizieren der Bilder weiter an SingelMatrix.replicate(...) 
     *
     * @param alle benoetigten Parameter params als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return das kombinierte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.replicate(((MVInt)params[1]).toInt(),
								     ((MVInt)params[2]).toInt())));
    }
    
    /**
     * Erzeugt den String "replicate", der die Klasse repräsentiert
     *
     * @return replicate als <code>String</code>
     */
    public String toString() {
	return "replicate";
    }
}
