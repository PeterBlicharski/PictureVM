/* $Id: OPmaxi.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den OP-Code zum Bestimmen des Maximums zweier 
 * Integer-Zahlen. Als Parameter werden zwei MVInt-Werte verlangt. Der erste 
 * und der zweite Wert werden miteinander verglichen. Die groessere Zahl wird
 * zurueckgegeben.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPmaxi implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Die groessere Zahl der beiden als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		if (params[0].toInt() > params[1].toInt())
			return params[0];
		else;
			return params[1];
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "maxi";
	}
}
