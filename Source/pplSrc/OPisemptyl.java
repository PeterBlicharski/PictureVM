/* $Id: OPisemptyl.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den OP-Code zum Testen, ob eine Liste leer ist.
 * Als Parameter wird ein MVList-Wert verlangt. Ist die Liste leer, so wird
 * ein MVInt mit dem Wert Eins zurueckgeliefert.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPisemptyl implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis des Tests als MachineValue
     * (1=Liste ist leer ; 0=Liste ist nicht leer)
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		if (params[0].toList().isEmpty())
			return new MVInt(1);
		else;
			return new MVInt(0);
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "isemptyl";
	}
}
