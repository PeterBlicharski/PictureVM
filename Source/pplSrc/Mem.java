/* $Id: Mem.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.machine;

import ppl.mv.*;

/**
 * Mit dieser Klasse wird ein Speicherbereich fuer Variablen verwaltet. Mit dem
 * Konstruktor wird ein Speicherbereich mit der angegebenen Groesse erzeugt.
 * Bei der Initialisierung werden alle Speicherzellen auf den undefinierten 
 * Wert MVUndef gesetzt. Bevor solch eine Speicherzelle gelesen werden kann,
 * muss sie vorher mit einem definierten Wert vom Typ MachineValue gefuellt
 * werden. 
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class Mem
{
	/**
	 * Speicherbereich fuer die Variablen
	 */
	private
	MachineValue [] mem;
	
	/**
	 * Konstruktor fuer das Erzeugen eines neuen Speicherbereiches. Alle
	 * Speicherzellen werden mit dem Wert MVUndef gefuellt.
	 * @param size Anzahl der Variablen im neuen Speicherbereich
	 */
	public
	Mem(int size)
	{		
		mem = new MachineValue [size];
		for(int i=0; i<size; ++i)
			mem[i] = new MVUndef();		
	}
	
	/**
	 * Mit dieser Funktion kann eine Variable an einem angegebenen Index des
	 * Speicherbereiches ausgelesen werden. Ist der Vert der Variable
	 * undefiniert, so wird eine Fehlermeldung ausgegeben. Auch ein falscher
	 * index wird gemeldet.
	 * @param index Adresse der Variable im Speicherbereich
	 * @return Wert der Variable als MachineValue
	 * @throws RuntimeException Entweder es wurde ein ungueltiger Index gewaehlt
	 * oder der Inhalt der Speicherzelle ist leer.
	 */
	public
	MachineValue getValue(int index)
	{
		if ((index<0) || (index>=mem.length))
		{
			throw new RuntimeException("Index "+index+" ausserhalb des Speicherbereiches");
		}
		else
		if (mem[index] instanceof MVUndef)
		{
			throw new RuntimeException("Leere Speicherzelle bei Index "+index);
		}
		else
			return ((MachineValue)mem[index]).copy();
	}
	
	/**
	 * Diese Funktion ermoeglicht des Schreiben von Variablen.
	 * @param index Adresse der zu schreibenden Variable
	 * @param mv Der zu schreibende Wert
	 * @throws RuntimeException Es wurde ein ungueltiger Index gewaehlt
	 */
	public
	void setValue(int index, MachineValue mv)
	{
		if ((index<0) || (index>=mem.length))
		{
			throw new RuntimeException("Index "+index+" ausserhalb des Speicherbereiches");
		}
		else
			mem[index]=mv;
	}
}
