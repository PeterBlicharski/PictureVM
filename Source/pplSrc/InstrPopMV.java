/* $Id: InstrPopMV.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;

/**
 * In dieser Klasse wird die Instruktion zum Herunterladen des obersten Stack-
 * Elements implementiert. Die Klasse ist als Singelton implementiert.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public class InstrPopMV extends Instr
{
	/**
	 * Referenz auf ein bereits erzeugtes Objekt dieser Klasse.
	 */
	static
	private
	InstrPopMV ref;

	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 */	
	private
	InstrPopMV(MachineState ms)
	{
		super(ms);
	}
	
	/**
	 * Funktion zum Erzeugen der Instruktion fuer das popen eines Stackelements.
	 * @param ms Status der Virtuellen Maschine
	 * @return Referenz auf das Objekt dieser Instruktion
	 */
	static
	public
	Instr makeOne(MachineState ms)
	{
		if (ref==null)
			ref = new InstrPopMV(ms);
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
		ms.popStack();
	}
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{
		return new String("POP Machine Value");
	}
}
