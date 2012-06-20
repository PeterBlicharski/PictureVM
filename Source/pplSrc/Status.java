/* $Id: Status.java,v 1.3 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.machine;

/**
 * Mit Hilfe dieser Klasse kann der Status der Virtuellen Maschine verwaltet
 * werden. Die Klasse ist als Singelton implementiert.
 * Es gibt dabei drei Zustaende:
 * STATUS_ABORT: Die Programmausfuehrung wird abgebrochen
 * STATUS_TERMINATE: Das Programm wird beendet
 * STATUS_ERROR: Das Programm wird mit einer Fehlerausgabe beendet
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class Status
{
	/**
	 * Referenz auf eine Instanz dieser Klasse
	 */
	private
	static
	Status refer;
	
	/**
	 * Statusmeldung
	 */
	private
	String message = "OK";
	
	/**
	 * aktueller Status der Virtuellen Maschine
	 */
	private
	int status;
	
	/**
	 * moegliche Zustaende des System-Status
	 */
	public
	static final int 
	  STATUS_OK			= 0
	, STATUS_ABORT 		= STATUS_OK +1
	, STATUS_TERMINATE 	= STATUS_ABORT + 1
	, STATUS_ERROR		= STATUS_TERMINATE + 1;
	
	/**
	 * Verstecken des Default-Konstruktors
	 */
	private
	Status()
	{
	}
	
	/**
	 * Methode zum Erzeugen eines Status-Objektes als Singelton
	 * @return Status-Objekt
	 */
	public
	static
	Status makeStatus()
	{		
		if (refer == null)
			refer = new Status();
		return refer;
	}
	
	/**
	 * Funktion zum Testen des Systemzustandes. Nur wenn keine Fehler
	 * aufgetreten sein, ist alles ok.
	 * @return Status der Virtuellen Maschine
	 */
	public
	boolean isOK()
	{
		return (status == STATUS_OK);
	}
	
	/**
	 * Methode zum Setzen eines System-Fehlers. Das Programm wird danach beendet.
	 * @param error Auszugebende Fehlermeldung
	 */
	public
	void setError(String error)
	{
		message = error;
		status = STATUS_ERROR;
	}
	
	/**
	 * Methode zum Beenden des Programms.
	 */
	public
	void setTerminate()
	{
		message = "Programm wurde beendet";
		status = STATUS_TERMINATE;
	}
	
	/**
	 * Methode zum Abbrechen eines Programms mit einer auszugebenden Meldung.
	 * @param message Nachricht, die beim Programmabbruch ausgegeben wird
	 */
	public
	void setAbort(String message)
	{
		this.message = message;
		status = STATUS_ABORT;
	}
	
	/**
	 * Ausgeben der Statusmeldung
	 * @return Statusmeldung
	 */
	public
	String toString()
	{
		return message;
	}
}
