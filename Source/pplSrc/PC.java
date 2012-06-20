/* $Id: PC.java,v 1.7 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.machine;

/**
 * Diese Klasse implementiert den Program-Counter der virtuellen Maschine. Er
 * ist als Singelton implementiert und kann somit nur einmal erzeugt werden.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class PC
{
	/**
	 * Position des Program-Counters
	 */
	private 
	int addr;
	
	/**
	 * Ende des Adressraumes vom Code-Segment
	 */
	private
	int maxPC;
	
	/**
	 * Referenz des PCs. Wird für die Implemenierung als Singelton benoetigt
	 */
	private
	static
	PC refer;
	
	/**
	 * Default-Constructor verstecken
	 */
	private
	PC()
	{
	}
	
	/**
	 * Interner Constructor fuer einen neuen PC. Der Parameter maxPC gibt die
	 * Adresse des letzten Befehls im Code-Segment an.
	 * @param maxPC Adresse des letzten Befehls
	 */
	private
	PC(int maxPC)
	{
		this.maxPC = maxPC;
		addr = 0;
	}
	
	/**
	 * Globale Funktion zum Erzeugen eins PCs. Wurde bereits ein PC erzeugt,
	 * so wird lediglich die Referenz auf den bereits bestehenden zurückgegeben.
	 * @param maxPC Adresse des letzten Befehls
	 * @return Referenz auf den PC
	 */
	public
	static
	PC makePC(int maxPC)
	{
		if (refer == null)
			refer = new PC(maxPC);	
		return refer;
	}
	
	/**
	 * Diese Funktion setzt die Adresse des PCs auf den in addr angegebenen Wert.
	 * @param addr neue Adresse des PCs
	 */
	public
	void setAddress(int addr)
	{
		this.addr = addr;		
	}
	
	/**
	 * Auslesen der PC-Adresse
	 * @return momentane Adresse des PCs
	 */
	public
	int getAddress()
	{
		return this.addr;
	}
	
	/**
	 * Test, ob sich der PC noch innerhalb des definierten Bereiches befindet
	 * @return true=der PC ist OK
	 */
	public
	boolean isValidPC()
	{
		return ((addr >= 0) && (addr <= maxPC));
	}	
	
	/**
	 * Funktion zum erhoehen des PCs um das angegebene displacement. Dieses
	 * wird für relative Sprünge benötigt.
	 * @param displacement Displacement fuer den relativen Sprung
	 * @return true=Der Sprung wurde ausgefuehrt.
	 */
	public
	boolean addPC(int displacement)
	{
		addr += displacement;		
		return true;
	}	
	
	/**
	 * Funktion zur String-Konvertierung. Kann zum Tracen verwendet werden.
	 * @return Der PC als String
	 */
	public
	String toString()
	{
		return "PC = "+addr;		
	}	
}
