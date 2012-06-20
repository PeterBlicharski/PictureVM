/* $Id: OPprependl.java,v 1.5 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den OP-Code zum Einfuegen eines Listenelementes
 * vor den Anfang einer Liste. Als Parameter werden ein MVList-Wert und ein
 * MachineValue-Wert verlangt. Das Ergebnis ist wieder eine Liste vom Typ MVList.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPprependl implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Die Liste mit dem eingefuegten Wert als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return params[0].toList().prependMV(params[1]);
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "prependl";
	}
}
