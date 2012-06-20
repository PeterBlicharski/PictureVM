/* $Id: InstrJump.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;

/**
 * In dieser Klasse wird die Instruktion fuer relative Spruenge im Code-Segment
 * der Virtuellen Maschine implementiert.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class InstrJump extends Instr
{
	/**
	 * Displacement fuer den Sprung
	 */
	private
	int disp;
	
	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 * @param disp Displacement fur den Sprung
	 */
	private
	InstrJump(MachineState ms, int disp)
	{
		super(ms);		
		this.disp = disp;
	}
	
	/**
	 * Funktion zum Erzeugen der Instruktion fuer einen relativen Sprung.
	 * @param ms Status der Virtuellen Maschine
	 * @param disp Displacement fur den Sprung
	 * @return Referenz auf das Objekt dieser Instruktion
	 */
	static
	public
	Instr makeOne(MachineState ms, int disp)
	{
		return new InstrJump(ms, disp);
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung der Instruktion.
	 * Bei der Verarbeitung wird auf den PC der Virtuellen Maschine 
	 * zugegriffen.
	 */
	public
	void exec()
	{		
		ms.jumpPCRelative(disp);
	}
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{
		return "JUMP relative "+disp;
	}
}
