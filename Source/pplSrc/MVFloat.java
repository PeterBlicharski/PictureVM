/* $Id: MVFloat.java,v 1.6 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.mv;

/**
 * Diese Klasse implemeniert den Datentyp MVFloat. Er wird fuer die Verwaltung
 * von Fliesskommazahlen benoetigt.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class MVFloat extends MachineValue
{
	/**
	 * Wert des Objektes MVFloat
	 */
	private
	float value;
		
	/**
	 * Konstruktor fuer das Erzeugen eines MVFloats mit dem angegebenen Wert.
	 * @param value Wert des MVFloats nach der Initialisierung
	 */
	public
	MVFloat(float value)
	{
		super();
		this.value = value;
	}
		
	/**
	 * Default-Konstruktor fuer das Erzeugen eines MVFloats. Der Wert wird
	 * automatisch auf 0.0 gesetzt.
	 */
	public
	MVFloat()
	{
		this((float)0.0);
	}
			
	/**
	 * Konvertiert den Wert eines MVFloats in ein float
	 * @return Wert des MVFloats
	 */
	public
	float toFloat()
	{		
		return value;
	}
	
	/**
	 * Konvertiert den Wert eines MVFloats in einen String
	 * @return Wert des MVFloats als String
	 */
	public
	String toString()
	{
		return Float.toString(value);
	}
		
	/**
	 * Kopiert einen MVFloat vollstaendig.
	 * @return Kopie des MVFloats
	 */
	public 
	MachineValue copy()
	{
		return new MVFloat(value);
	}
}
