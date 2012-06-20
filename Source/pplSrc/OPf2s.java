/* $Id: OPf2s.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVString;

/**
 * Diese Klasse implementiert den OP-Code zum Konvertieren einer Float-Zahl
 * in einen String. Als Parameter wird ein MVFloat-Wert verlangt. Dieser wird in
 * einen MVString konvertiert.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPf2s implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis der Konversion als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return new MVString(Float.toString(params[0].toFloat()));
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "f2s";
	}
}
