/* $Id: OPabort.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Diese Klasse implementiert den OP-Code zum Abbrechen des Programmablaufes mit
 * einer Fehlermeldung. Die Fehlermeldung wird als Parameter vom Typ MVString
 * erwartet.
 * Es ist jedoch besser, den entsprechenden System-Call zu benutzen.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPabort implements OP
{
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Ein Ergebnis wird nicht geliefert
     * @throws RuntimeException Abbrechen des Programms mit einer Fehlermeldung
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		throw new RuntimeException(params[0].toString());
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "abort";
	}
}
