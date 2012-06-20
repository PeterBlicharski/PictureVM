/* $Id: OPblack.java,v 1.5 2003/01/10 09:01:01 ii3839 Exp $ */

package ppl.op;
import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPblack</code>
 * Diese Klasse leitet die Erstellung eines Schwarzbildes weiter.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Breite des Bildes
 *   <li>Hoehe des Bildes
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPblack implements OP {
 
    /**
     * Leitet die Erzeugung des Schwarzbildes weiter an MVPicture.makeBlackPic(...)
     *
     * @param alle benoetigten Parameter params als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return Das Schwarzbild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return MVPicture.makeBlackPic(params[0].toInt(),params[1].toInt());
    }
    
    /**
     * Erzeugt den String "black", der die Klasse repräsentiert
     *
     * @return black als <code>String</code>
     */
    public String toString() {
	return "black";
    }

}
