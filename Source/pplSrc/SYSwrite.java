/* $Id: SYSwrite.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.syscalls;

import ppl.mv.MachineValue;
import ppl.mv.MVInt;
import ppl.machine.MachineState;



/**
 * Diese Klasse implementiert den System-Call zum Ausgeben eines Strings in der
 * Shell. Als Parameter wird ein MVString-Wert benoetigt.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class SYSwrite implements SYS
{	
    /**
     * Methode die von aussen die Verabeitung startet.     
     *
     * @param ms Status der Maschine
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Dummy-Wert als MachineValue
     */	
	public	
	MachineValue eval(MachineState ms, MachineValue [] params)
	{
		System.out.print(params[0].toString());		
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
		return "write";
	}
}
