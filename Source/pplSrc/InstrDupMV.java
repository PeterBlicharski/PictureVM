/* $Id: InstrDupMV.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;

/**
 * In dieser Klasse wird die Instruktion zum Verdoppeln des obersten Stack-
 * Elements implementiert. Die Klasse ist als Singelton implementiert.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public class InstrDupMV extends Instr
{
	/**
	 * Referenz auf ein bereits erzeugtes Objekt dieser Klasse.
	 */
	static
	private
	InstrDupMV ref;
	
	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 */
	private
	InstrDupMV(MachineState ms)
	{
		super(ms);	
	}
	
	/**
	 * Erzeugen einer Instruktion zum Verdoppeln von Stack-Elementen
	 * @param ms Status der Virtuellen Maschine
	 * @return Referenz auf das Objekt dieser Instruktion. (Singelton)
	 */
	static
	public 
	Instr makeOne(MachineState ms)
	{
		if (ref==null)
			ref = new InstrDupMV(ms);
		return ref;
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung der Instruktion.
	 * Bei der Verarbeitung wird auf den Stack der Virtuellen Maschine 
	 * zugegriffen.
	 */
	public
	void exec()
	{		
		ms.dupStackTop();
	}
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{
		return new String("DUP Machine Value");
	}
}
