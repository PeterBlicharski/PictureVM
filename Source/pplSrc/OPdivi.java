/* $Id: OPdivi.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den OP-Code zur Division zweier Integer-Zahlen.
 * Als Parameter werden zwei MVInt-Werte verlangt. Der erste Wert wird durch
 * den zweiten dividiert.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPdivi implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis der Integer-Division als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return new MVInt(params[0].toInt()/params[1].toInt());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "divi";
	}
}
