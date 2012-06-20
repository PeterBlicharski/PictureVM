/* $Id: MVInt.java,v 1.8 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.mv;

/**
 * Diese Klasse implemeniert den Datentyp MVInt. Dieser wird fuer die Verwaltung
 * von Integer-Zahlen benoetigt.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class MVInt extends MachineValue
{
	/**
	 * Integer-Wert des Objektes MVInt
	 */
	private	
	int value;
	
	/**
	 * Konstruktor fuer das Erzeugen eines MVInts mit dem angegebenen Wert.
	 * @param value Wert des MVInts nach der Initialisierung
	 */
	public
	MVInt(int value)
	{
		super();
		this.value = value;
	}
	
	/**
	 * Default-Konstruktor fuer das Erzeugen eines MVInts. Der Wert wird
	 * automatisch auf Null gesetzt.
	 */
	public
	MVInt()
	{
		this(0);
	}
	
	/**
	 * Konvertiert den Wert eines MVInts in ein int
	 * @return Wert des MVInts
	 */
	public
	int toInt()
	{		
		return value;
	}
	
	/* Mit Hilfe dieser Funktion ist es moeglich, einen MVInt in ein float
	 * zu konvertieren. Da dies jedoch nicht der vorgegebenen Spezifikation
	 * entspricht, wurde sie hier auskommentiert.
	/*public
	float toFloat()
	{		
		return (float) value;
	}*/
	
	/**
	 * Konvertiert den Wert eines MVInts in einen String
	 * @return Wert des MVInts als String
	 */
	public
	String toString()
	{
		return Integer.toString(value);
	}
	
	/**
	 * Kopiert einen MVInt vollstaendig.
	 * @return Kopie des MVInts
	 */
	public 
	MachineValue copy()
	{
		return new MVInt(value);
	}
}
