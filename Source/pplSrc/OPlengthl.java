/* $Id: OPlengthl.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den OP-Code zum Bestimmen der Laenge einer Liste.
 * Als Parameter wird ein MVList-Wert verlangt. Die Laenge der Liste wird als
 * MVInt zurueckgegeben.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPlengthl implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Die Laenge der Liste als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return new MVInt(params[0].toList().getLength());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "lengthl";
	}
}
