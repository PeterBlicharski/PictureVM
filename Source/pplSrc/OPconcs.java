/* $Id: OPconcs.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVString;

/**
 * Diese Klasse implementiert den OP-Code zum Verknuepfen zweier Strings.
 * Als Parameter werden zwei MVString-Werte verlangt. An der ersten String
 * wird der zweite angehaengt.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPconcs implements OP
{
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis der String-Verknuepfung als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return new MVString(params[0].toString() + params[1].toString());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "concs";
	}
}
