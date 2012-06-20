/* $Id: InstrPushJ.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.Opcodes;
import ppl.mv.MVCodeAddr;
import ppl.machine.MachineState;

/**
 * In dieser Klasse wird die Instruktion fuer ein Sprung in ein Unterprogramm
 * implementiert. Dafuer wird zunaechst die momentane Adresse des PCs auf dem
 * Stack gesichert. Anschliessend wird ein relativer Sprung in das Unterprogramm
 * vollzogen.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class InstrPushJ extends Instr
{
	/**
	 * Displacement fuer den Sprung
	 */
	private
	int disp;

	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 * @param disp Displacement fuer den Sprung
	 */	
	private
	InstrPushJ(MachineState ms, int disp)
	{
		super(ms);
		this.disp = disp;
	}
	
	/**
	 * Funktion zum Erzeugen der Instruktion fuer den Sprung zu einem
	 * Unterprogramm.
	 * @param ms Status der Virtuellen Maschine
	 * @param disp Displacement fuer den Sprung
	 * @return Referenz auf das Objekt dieser Instruktion
	 */
	static
	public	
	Instr makeOne(MachineState ms, int disp)
	{			
		return new InstrPushJ(ms, disp);
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung der Instruktion.
	 * Bei der Verarbeitung wird auf den Stack, Speicher und PC der Virtuellen 
	 * Maschine zugegriffen.
	 */
	public
	void exec()
	{
		ms.pushStack(new MVCodeAddr(ms.getPCAddress()));
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
		return "PUSHJ displacement "+disp;
	}
}
