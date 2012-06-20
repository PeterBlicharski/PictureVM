/* $Id: OPindexl.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den OP-Code zum Ermitteln eines Listenelementes
 * an einem bestimmten Index. Als Parameter werden ein MVList-Wert und ein
 * MVInt-Wert verlangt. Das Ergebnis ist das Listenelement an der gesuchten
 * Stelle.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPindexl implements OP
{
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Element an der gegebenen Listenposition als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return params[0].toList().getIndex(params[1].toInt());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "indexl";
	}
}
