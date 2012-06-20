/* $Id: OPconcl.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den OP-Code zum Aneinanderhaengen zweier Listen.
 * Als Parameter werden zwei MVList-Werte verlangt. Die zweite Liste wird an die
 * erste angehaengt. Das Ergebnis ist wieder eine Liste vom Typ MVList.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPconcl implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Die Verkuepfung der zwei Listen als MachineValue
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		return params[0].toList().appendList(params[1].toList());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "concl";
	}
}
