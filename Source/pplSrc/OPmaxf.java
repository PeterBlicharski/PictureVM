/* $Id: OPmaxf.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den OP-Code zum Bestimmen des Maximums zweier 
 * Float-Zahlen. Als Parameter werden zwei MVFloat-Werte verlangt. Der erste 
 * und der zweite Wert werden miteinander verglichen. Die groessere Zahl wird
 * zurueckgegeben.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPmaxf implements OP
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
		if (params[0].toFloat() > params[1].toFloat())
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
		return "maxf";
	}
}
