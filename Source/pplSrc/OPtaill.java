/* $Id: OPtaill.java,v 1.5 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den OP-Code zum Bestimmen der Restliste nach dem 
 * ersten Listenelement. Als Parameter wird ein MVList-Wert verlangt. Die 
 * Restliste wird als MVList zurueckgegeben.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPtaill implements OP
{
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Die Liste ohne das erste Element als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return params[0].toList().getTail();
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "taill";
	}
}
