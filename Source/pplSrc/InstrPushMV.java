/* $Id: InstrPushMV.java,v 1.6 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;
import ppl.mv.*;

/**
 * In dieser Klasse wird die Instruktion Laden eines Machine-Values auf den
 * Stack implementiert.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public class InstrPushMV extends Instr
{
	/**
	 * Der auf dem Stack zu speichernde Wert
	 */
	private
	MachineValue mv;	

	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 * @param mv Der auf dem Stack zu speichernde Wert
	 */	
	private
	InstrPushMV(MachineState ms, MachineValue mv)
	{		
		super(ms);
		this.mv = mv;
	}
	
	/**
	 * Funktion zum Erzeugen der Instruktion fuer das pushen eines Wertes auf
	 * den Stack.
	 * @param ms Status der Virtuellen Maschine
	 * @param mv Der auf dem Stack zu speichernde Wert
	 * @return Referenz auf das Objekt dieser Instruktion
	 */	
	static
	public
	Instr makeOne(MachineState ms, MachineValue mv)
	{
		return new InstrPushMV(ms, mv);
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung der Instruktion.
	 * Bei der Verarbeitung wird auf den Stack der Virtuellen Maschine 
	 * zugegriffen.
	 */
	public
	void exec()
	{
		ms.pushStack(mv);
	}
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{
		return new String("PUSH Machine Value");
	}
}
