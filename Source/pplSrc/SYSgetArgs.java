/* $Id: SYSgetArgs.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.syscalls;

import ppl.machine.MachineState;
import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den System-Call zum Einlesen der Kommandozeilen-
 * Parameter. Das Ergebnis ist eine Liste aus Strings. Die Liste ist vom Typ
 * MVList.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class SYSgetArgs implements SYS
{
	/**
     * Methode die von aussen die Verabeitung startet.
     * Wichtig: Diese Routine greift auf den Status der Maschine zu! 
     *
     * @param ms Status der Maschine
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Liste der Kommandozeilenparameter als MachineValue
     */		
	public	
	MachineValue eval(MachineState ms, MachineValue [] params)
	{		
		return ms.getArgs();
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "getArgs";
	}
}
