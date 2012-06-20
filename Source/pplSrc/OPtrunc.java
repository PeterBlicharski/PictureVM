/* $Id: OPtrunc.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVFloat;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den OP-Code zum Konvertieren einer Float-Zahl
 * in einen Integer. Als Parameter wird ein MVFloat-Wert verlangt. Dieser wird 
 * in einen MVInt konvertiert, indem die Nachkommastellen abgeschnitten werden.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPtrunc implements OP
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
		Float temp = new Float(params[0].toFloat());
		return new MVInt(temp.intValue());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "trunc";
	}
}
