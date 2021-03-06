/* $Id: InstrStore.java,v 1.5 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.machine.MachineState;
import ppl.Opcodes;
import ppl.Instr;

/**
 * In dieser Klasse wird die Instruktion zum zum Speichern eines Wertes vom 
 * Stack in dem Speicher (lokal oder global) implementiert.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

public
class InstrStore extends Instr
{
	/**
	 * Art der Adressierung: lokal oder absolut
	 */
	private
	int addrType;
	
	/**
	 * offset zu adressierende Speicherzelle
	 */
	private
	int offset;
	
	/**
	 * Konstruktor fuer das Erzeugen dieser Instruktion
	 * @param ms Status der Virtuellen Maschine
	 * @param addrType Art der Adressierung: lokal oder absolut
	 * @param offset zu adressierende Speicherzelle
	 */
	private
	InstrStore(MachineState ms, int addrType, int offset)
	{
		super(ms);
		this.addrType = addrType;
		this.offset = offset;
	}
	
	/**
	 * Funktion zum Erzeugen der Instruktion fuer das Speichern von Werten.
	 * @param ms Status der Virtuellen Maschine
	 * @param addrType Art der Adressierung: lokal oder absolut
	 * @param offset zu adressierende Speicherzelle
	 * @return Referenz auf das Objekt dieser Instruktion
	 */
	public
	static
	Instr makeOne(MachineState ms, int addrType, int offset)
	{
		return new InstrStore(ms, addrType, offset);
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung der Instruktion.
	 * Bei der Verarbeitung wird auf den Stack und den Speicher der Virtuellen 
	 * Maschine zugegriffen.
	 */
	public
	void exec()
	{	
		if (addrType == Opcodes.absAddr)
			ms.setGlobalVar(offset,ms.popStack());
		else
			ms.setLocalVar(offset, ms.popStack());			
	}
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{
		return new String("STORE");
	}
}
