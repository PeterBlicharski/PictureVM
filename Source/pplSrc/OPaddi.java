/* $Id: OPaddi.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den OP-Code zur Addition zweier Integer-Zahlen.
 * Als Parameter werden zwei MVInt-Werte verlangt. Auf den ersten Wert
 * wird der zweite addiert.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPaddi implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis der Integer-Addition als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return new MVInt(params[0].toInt() + params[1].toInt());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "addi";
	}
}
