/* $Id: Frames.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.machine;

/**
 * Mit dieser Klasse wird der Speicher fuer die lokalen Variablen verwaltet.
 * Der Funktionsaufruf newFrame erzeugt einen neuen Speicherbereich fuer
 * lokale Variablen. Da die einzelnen Frames auf einem Stack liegen, ist immer
 * nur der "oberste" Frame ansprechbar. Um an aeltere Frames zu gelangen,
 * muessen die "darueber" liegenden mit der Funktion removeFrame entfernt werden.
 * Die einzelnen Frames sind vom Typ Mem.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class Frames
{
	/**
	 * Stack fuer die lokalen Speicherbereiche
	 */
	private
	java.util.Stack frames;
	
	/**
	 * Konstruktor fuer das Erzeugen eines Frame-Objekts. Hier wird der
	 * Stack fuer die einzelnen Speicherbereiche initialisiert.
	 */
	public Frames()
	{
		frames = new java.util.Stack();
	}
	
	/**
	 * Diese Methode erzeugt einen neuen Speicherbereich fuer lokale Variablen
	 * und vermerkt ihn auf dem Stack.
	 * @param size Anzahl der Speicherzellen im neuen Frame
	 */
	public
	void newFrame(int size)
	{		
		frames.push(new Mem(size));
	}
	
	/**
	 * Die Methode entfernt einen lokalen Speicherbereich, indem das oberste
	 * Element des Frame-Stacks verworfen wird.
	 * @throws RuntimeException Der Stack fuer die lokalen Variablen ist leer.
	 */
	public
	void removeFrame()
	{
		if (! frames.isEmpty())
			frames.pop();
		else
		{
			throw new RuntimeException("Kein Frame fuer lokale Variablen vorhanden");
		}
	}
	
	/**
	 * Mit der Methode kann die Referenz auf den zuletzt angelegten Speicherbereich
	 * fuer lokale Variablen ermittelt werden. Dazu wird das oberste Stackelement
	 * ausgelesen.
	 * @return aktueller Speicherbereich fuer lokale Variablen
	 * @throws RuntimeException Der Stack fuer die lokalen Variablen ist leer.
	 */
	public
	Mem getFrame()
	{
		if (! frames.isEmpty())
			return (Mem) frames.peek();
		else
		{
			throw new RuntimeException("Kein Frame fuer lokale Variablen vorhanden");
		}
	}
}
