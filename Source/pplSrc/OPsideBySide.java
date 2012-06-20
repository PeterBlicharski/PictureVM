/* $Id: OPsideBySide.java,v 1.3 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPsideBySide</code>
 * Nimmt zwei Bilder und legt sie seitlich nebeneinander.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild1
 *   <li>Bild2
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPsideBySide implements OP {
 
    //XXX: Casting richtig stellen!

    /**
     * Leitet das Anlegen an <code>SingelMatrix.sideBySide</code> weiter.
     *
     * @param params eine Array an Uebergabeparamteren als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return das gespiegelte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	System.out.println(this.toString());
	
	return (new MVPicture(((MVPicture)params[0]).magicNumber
			      ,((MVPicture)params[0]).maxVal
			      ,((MVPicture)params[0]).pixel.sideBySide(((MVPicture)params[1]).pixel)));
    }
    
    /**
     * Erzeugt den String "sideBySide", der die Klasse repräsentiert
     *
     * @return sideBySide als <code>String</code>
     */
    public String toString() {
	return "sideBySide";
    }
}
