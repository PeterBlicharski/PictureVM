/* $Id: OPdecri.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den OP-Code zum Dekrementieren einer
 * Integer-Zahl. Als Parameter wird ein MVInt-Wert verlangt. Dieser wird um
 * den Wert Eins verringert.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPdecri implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis der Integer-Dekrementation als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return new MVInt(params[0].toInt()-1);
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "decri";
	}
}
