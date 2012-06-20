/* $Id: SYS.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.syscalls;

import ppl.mv.MachineValue;
import ppl.machine.MachineState;

/**
 * Schnittstellendefinition für alle System-Calls, die die VM - fuer PPL 
 * verabeiten kann.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public interface SYS
{
	/**
     * Diese Methode leitet die Verarbeitung ein.
     *
     * @param ms Status der Maschine
     * @param params enthaellt alle Uebergabeparameter in einer definierten Reihenfolge
     * @return einen beliebigen MachineValue
     */
	public
	MachineValue eval(MachineState ms, MachineValue [] params);
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString();
}
