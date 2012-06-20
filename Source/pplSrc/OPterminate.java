/* $Id: OPterminate.java,v 1.6 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den OP-Code zum Beenden des Programms. Es werden
 * keine Parameter benoetigt.
 * Es ist jedoch besser, den entsprechenden System-Call zu benutzen.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPterminate implements OP
{
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Ein Ergebnis wird nicht geliefert
     * @throws RuntimeException Beenden des Programms
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		throw new RuntimeException("Programm beendet");
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "terminate";
	}
}
