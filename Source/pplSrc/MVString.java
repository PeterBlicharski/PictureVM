/* $Id: MVString.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.mv;

/**
 * Diese Klasse implemeniert den Datentyp MVString. Dieser wird fuer die 
 * Verwaltung von Strings benoetigt.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class MVString extends MachineValue
{
	/**
	 * Wert des Objektes MVString
	 */
	private
	String value;
	
	/**
	 * Konstruktor fuer das Erzeugen eines MVString mit dem angegebenen Wert.
	 * @param value String für die Initialisierung des Objektes
	 */
	public
	MVString(String value)
	{
		super();
		this.value = new String(value);
	}
	
	/**
	 * Default-Konstruktor fuer das Erzeugen eines MVString. Der Wert wird
	 * auf eine leere Zeichenkette gesetzt.
	 */
	public
	MVString()
	{
		this("");
	}
	
	/**
	 * Konvertiert den Wert eines MVString in einen String
	 * @return Wert des MVString als String
	 */
	public
	String toString()
	{
		return new String(value);
	}
	
	/**
	 * Kopiert einen MVString vollstaendig.
	 * @return Kopie des MVString
	 */
	public 
	MachineValue copy()
	{
		return new MVString(value);
	}
}
