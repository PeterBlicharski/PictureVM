/* $Id: OPgtf.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVInt;

/**
 * Diese Klasse implementiert den OP-Code Testen, ob eine Float-Zahl groesser
 * als eine andere ist. Als Parameter werden zwei MVFloat-Werte 
 * verlangt. Ist der erste Wert groesser als der zweite, dann liefert 
 * die Funktion eval den MVInt-Wert Eins (entspricht true) zurueck.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class OPgtf implements OP
{	
	/**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das Ergebnis des Vergleiches als MachineValue 
     * (1=groesser; 0=nicht groesser)
     */
	public
	MachineValue eval(MachineValue [] params)
	{
		if (params[0].toFloat() > params[1].toFloat())
			return new MVInt(1);
		else;
			return new MVInt(0);
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "gtf";
	}
}
