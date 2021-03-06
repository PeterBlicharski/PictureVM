/* $Id: InstrEntry.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;

/**
 * In dieser Klasse wird die Instruktion fuer das Anlegen eines neuen lokalen
 * Speicherbereiches implementiert.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class InstrEntry extends Instr
{	
	/**
	 * Groesse des lokalen Speichers
	 */
	private
	int size;
	
	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 * @param size Groesse des anzulegenden lokalen Speichers
	 */
	private
	InstrEntry(MachineState ms, int size)
	{
		super(ms);
		this.size = size;
	}
	
	/**
	 * Funktion zum Erzeugen der Instruktion fuer die Speicher-Allokation.
	 * @param ms Status der Virtuellen Maschine
	 * @param size Groesse des anzulegenden lokalen Speichers
	 * @return Referenz auf das Objekt dieser Instruktion
	 */
	public
	static
	Instr makeOne(MachineState ms, int size)
	{
		return new InstrEntry(ms, size);
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung der Instruktion.
	 * Bei der Verarbeitung wird auf den Speicher der Virtuellen Maschine 
	 * zugegriffen.
	 */
	public
	void exec()
	{		
		ms.newLocalMem(size);
	}
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{
		return new String("ENTRY");
	}
}
