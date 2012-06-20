/* $Id: MVCodeAddr.java,v 1.6 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.mv;

/**
 * Diese Klasse implemeniert eine Adresse der Virtuellen Maschine.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class MVCodeAddr extends MachineValue
{
	/**
	 * Die im Objekt MVCodeAddr gespeicherte Adresse
	 */
	private
	int value;
	
	/**
	 * Konstruktor fuer das Erzeugen eines MVCodeAddrs mit der angegebenen 
	 * Adresse.
	 * @param addr Zu speichernde Adresse
	 */
	public
	MVCodeAddr(int addr)
	{
		super();
		this.value = addr;
	}	
	
	/**
	 * Konvertiert den Wert eines MVCodeAddrs in ein int. Dieser entspricht
	 * einer Adresse im Code-Segment der Virtuellen Maschine.
	 * @return Adresse im Code-Segment
	 */
	public
	int toAddress()
	{		
		return value;
	}
	
	/**
	 * Konvertiert den Wert eines MVCodeAddrs in einen String
	 * @return Die in ein String konvertierte Adresse
	 */
	public
	String toString()
	{
		return Integer.toString(value);
	}
	
	/**
	 * Kopiert einen MVCodeAddr vollstaendig.
	 * @return Kopie des MVCodeAddrs
	 */
	public 
	MachineValue copy()
	{
		return new MVCodeAddr(value);
	}
}
