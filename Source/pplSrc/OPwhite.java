/* $Id: OPwhite.java,v 1.4 2003/01/10 08:58:07 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPwhite</code>
 * Diese Klasse leitet die Erstellung eines Weissbildes weiter.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Breite des Bildes
 *   <li>Hoehe des Bildes
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de.de">Malte Hopmann</a> (ii4271)
 */
public class OPwhite implements OP {
 
    /**
     * Leitet die Erzeugung des Weissbildes weiter an MVPicture.makeWhitePic(...) 
     *
     * @param alle benoetigten Parameter params als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return Das Weissbild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return MVPicture.makeWhitePic(params[0].toInt(),params[1].toInt());
    }
    
    /**
     * Erzeugt den String "white", der die Klasse repräsentiert
     *
     * @return white als <code>String</code>
     */
    public String toString() {
	return "white";
    }
}
