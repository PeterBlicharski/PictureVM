/* $Id: InstrIllegal.java,v 1.3 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;

/**
 * In dieser Klasse wird die Instruktion fuer eine illegale Instruktion
 * implementiert.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class InstrIllegal extends Instr
{
	/**
	 * Fehlermeldung der illegalen Instruktion
	 */
	private
	String error;
	
	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 * @param error Fehlermeldung der illegalen Instruktion
	 */
	private
	InstrIllegal(MachineState ms, String error)
	{
		super(ms);		
		this.error = error;
	}
	
	/**
	 * Funktion zum Erzeugen der Instruktion fuer einen illegale Instruktion.
	 * @param ms Status der Virtuellen Maschine
	 * @param error Fehlermeldung der illegalen Instruktion
	 * @return Referenz auf das Objekt dieser Instruktion
	 */
	static
	public
	Instr makeOne(MachineState ms, String error)
	{
		return new InstrIllegal(ms, error);
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung der Instruktion.
	 * Bei der Verarbeitung wird auf den Status der Virtuellen Maschine 
	 * zugegriffen.
	 */
	public
	void exec()
	{
		ms.setStatusError(error);
	}
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{
		return "Illegal Instruction: "+error;
	}
}
