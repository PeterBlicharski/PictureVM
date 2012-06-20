/* $Id: InstrBranch.java,v 1.7 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;

/**
 * Diese Klasse implementiert bedingte relative Struenge. Ist die Bedingung
 * erfuellt, so wird der Sprung vollzogen.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class InstrBranch extends Instr
{
	/**
	 * Bedingung fuer den Sprung
	 */
	private
	boolean cond;
	
	/**
	 * Displacement fuer den relativen Sprung
	 */
	private
	int disp;
	
	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 * @param cond Sprungbedingung
	 * @param disp Displacement fuer den relativen Sprung
	 */
	private
	InstrBranch(MachineState ms, boolean cond, int disp)
	{
		super(ms);
		this.cond = cond;
		this.disp = disp;
	}
	
	/**
	 * Funktion zum Erzeugen eines bedingten relativen Sprunges.
	 * @param ms Status der Virtuellen Maschine
	 * @param cond Sprungbedingung
	 * @param disp Displacement fuer den relativen Sprung
	 * @return Referenz auf das Objekt dieser Instruktion
	 */
	public
	static
	Instr makeOne(MachineState ms, boolean cond, int disp)
	{
		return new InstrBranch(ms, cond, disp);
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung des bedingten relativen Sprunges.
	 * Bei der Verarbeitung wird auf den Stack und den PC der Virtuellen 
	 * Maschine zugegriffen.
	 */
	public
	void exec()
	{			
		if ((ms.popStack().toInt()!=0) == (cond))
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
		return new String("BRANCH");
	}
}
