/* $Id: OPmodi.java,v 1.5 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den OP-Code zur Modulo-Division zweier 
 * Integer-Zahlen. Als Parameter werden zwei MVInt-Werte verlangt. Das Ergebnis
 * berechnet sich aus dem ersten Wert modulo den zweiten.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPmodi implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis der Integer-Modulo-Division als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return new MVInt(params[0].toInt()%params[1].toInt());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "modi";
	}
}
