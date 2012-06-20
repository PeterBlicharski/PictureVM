/* $Id: InstrPopJ.java,v 1.7 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;

/**
 * In dieser Klasse wird die Instruktion fuer einen absoluten Sprung
 * implementiert. Hierbei muss sich das Sprungziel auf dem Stack befinden.
 * Mit dieser Instruktion koennen Rueckspruenge aus Unterprogrammen vollzogen
 * werden. Die Klasse ist als Singelton implementiert.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class InstrPopJ extends Instr
{
	/**
	 * Referenz auf ein bereits erzeugtes Objekt dieser Klasse.
	 */
	static
	private
	InstrPopJ ref;
	
	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 */
	private
	InstrPopJ(MachineState ms)
	{
		super(ms);
	}
	
	/**
	 * Funktion zum Erzeugen der Instruktion fuer den Ruecksprung aus einem
	 * Unterprogramm.
	 * @param ms Status der Virtuellen Maschine
	 * @return Referenz auf das Objekt dieser Instruktion
	 */
	static
	public
	Instr makeOne(MachineState ms)
	{
		if (ref==null)
			ref = new InstrPopJ(ms);
		return ref;
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung der Instruktion.
	 * Bei der Verarbeitung wird auf den Stack und den PC der Virtuellen 
	 * Maschine zugegriffen.
	 */
	public
	void exec()
	{				
		ms.jumpPCAbsolute(ms.popStack().toAddress());
	}	
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{		
		return "POPJ";
	}
}
