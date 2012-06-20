/* $Id: SYSexit.java,v 1.5 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.syscalls;

import ppl.machine.MachineState;
import ppl.mv.MachineValue;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den System-Call zum Beenden des Programmablaufes. 
 * Es werden keine Parameter benoetigt.
 * Da diese Routine den Status der VM direkt veraendern und das Programm
 * ohne eine RuntimeException beenden kann, ist sie dem gleichwertigen OP-Code
 * Befehl vorzuziehen.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class SYSexit implements SYS
{
	/**
     * Methode die von aussen die Verabeitung startet.
     * Wichtig: Diese Routine veraendert den Status der Maschine! 
     *
     * @param ms Status der Maschine
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Dummy-Wert als MachineValue
     */	
	public	
	MachineValue eval(MachineState ms, MachineValue [] params)
	{
		ms.setStatusTerminate();
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
		return "exit";
	}
}
