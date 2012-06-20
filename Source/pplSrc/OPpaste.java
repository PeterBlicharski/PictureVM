/* $Id: OPpaste.java,v 1.5 2003/01/10 08:58:07 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.mv.MVInt;

/**
 * <code>OPpaste</code>
 * Legt zwei Bilder uebereinander.
 * Der Ansatzpunkt der linken oberen Ecke des Bildes, das oben liegt, wird durch die beiden Integer Parameter festgelegt.
 * Reicht das obere Bild ueber die Grenzen der Unterlage (das untere Bild) hinaus, wird es ab dort abgeschnitten.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild (unten)
 *   <li>Bild (oben)
 *   <li>x-Offset
 *   <li>y-Offset
 * </ol>
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class OPpaste implements OP {
 
    //XXX: Casting richtig stellen!
    /**
     * Leitet das Uebereinanderlegen der Bilder weiter an SingelMatrix.paste(...) 
     *
     * @param alle benoetigten Parameter params als <code>MachineValue[]</code>
     * <a href="#folge">(Reihenfolge der Parameter)</a> 
     * @return das kombinierte Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue [] params){
	return (new MVPicture(((MVPicture)params[0]).magicNumber,
		              ((MVPicture)params[0]).maxVal,
			      ((MVPicture)params[0]).pixel.paste(((MVInt)params[2]).toInt(),
								 ((MVInt)params[3]).toInt(),
								 ((MVPicture)params[1]).pixel)));
    }
    
    /**
     * Erzeugt den String "paste", der die Klasse repräsentiert
     *
     * @return paste als <code>String</code>
     */
    public String toString() {
	return "paste";
    }
}
