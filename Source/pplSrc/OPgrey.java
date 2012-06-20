/* $Id: OPgrey.java,v 1.5 2003/01/10 08:58:07 ii3839 Exp $ */
package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPgrey</code>
 * Diese Klasse leitet die Erstellung eines Graubildes weiter.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Farbwert
 *   <li>Breite des Bildes
 *   <li>Hoehe des Bildes
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPgrey implements OP {
 
    /**
     * Leitet die Erzeugung des Graubildes weiter an MVPicture.makeGreyPic(...)
     *
     * @param alle benoetigten Parameter params als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return Das Graubild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return MVPicture.makeGreyPic(params[0].toFloat(),params[1].toInt(),params[2].toInt());
    }
    
    /**
     * Erzeugt den String "grey", der die Klasse repräsentiert
     *
     * @return grey als <code>String</code>
     */
    public String toString() {
	return "grey";
    }
}
