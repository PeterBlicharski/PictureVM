/* $Id: MVUndef.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.mv;

/**
 * Diese Klasse implemeniert den Datentyp MVUndef. Er ist ein Platzahlter
 * fuer einen nicht weiter definierten Wert der Virtuellen Maschine.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class MVUndef extends MachineValue
{
	/**
	 * Konvertiert ein MVUndef in einen String
	 * @return MVUndef als String
	 */
	public
	String toString()
	{
		return "MVUndef";
	}
	
	/**
	 * Kopiert ein MVUndef vollstaendig.
	 * @return Kopie des MVUndef
	 */
	public 
	MachineValue copy()
	{
		return new MVUndef();
	}
}
