/* $Id: OPsubf.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVFloat;

/**
 * Diese Klasse implementiert den OP-Code zur Subtraktion zweier Float-Zahlen.
 * Als Parameter werden zwei MVFloat-Werte verlangt. Von dem ersten Wert
 * wird der zweite subtrahiert.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPsubf implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis der Float-Subtraktion als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return new MVFloat(params[0].toFloat()-params[1].toFloat());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "subf";
	}
}
