/* $Id: InstrCompute.java,v 1.10 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.instr;

import ppl.Instr;
import ppl.machine.MachineState;
import ppl.mv.MachineValue;
import ppl.op.OP;
/**
 * Diese Klasse implementiert das Ausfuehren von OP-Codes.
 * Vor dem Ausfuehren eines OP-Codes wird die jeweils benoetigte Anzahl von
 * Parametern vom Evaluation-Stack in ein Array geladen. Dieses wird dann
 * der Funktion zum Auswerten eines OP-Codes als Parameter uebergeben.
 * Das Resultat eines jeden OP-Codes wird auf dem Evaluation-Stack vermerkt.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class InstrCompute extends Instr
{
	/**
	 * OP-Code
	 */
	private
	OP operation;
	
	/**
	 * Variable fuer die Parameter eines OP-Codes
	 */
	private
	MachineValue [] params;
	
	/**
	 * Versteckter Konstruktor fuer das Objekt.
	 * @param ms Zustand der Virtuellen Maschine
	 * @param operation auszuwertender OP-Code
	 * @param paramCount Anzahl der Parameter des OP-Codes
	 */
	private
	InstrCompute(MachineState ms, OP operation, int paramCount)
	{
		super(ms);
		this.operation = operation;
		this.params = new MachineValue [paramCount];
	}
	
	/**
	 * Methode zum erzeugen eines Objektes.
	 * @param ms Zustand der Virtuellen Maschine
	 * @param operation auszuwertender OP-Code
	 * @param paramCount Anzahl der Parameter des OP-Codes
	 * @return Referenz auf diese Instruktion
	 */
	static
	public
	Instr makeOne(MachineState ms, OP operation, int paramCount)
	{
		return new InstrCompute(ms, operation, paramCount);
	}
	
	/**
	 * Diese Funktion dient zur Ausfuehrung eines OP-Codes und dessen Versorgung
	 * mit der richtigen Anzahl an Parametern.
	 * @throws RuntimeException Fehler bei der Ausfuehrung des OP-Codes
	 */	
	public	
	void exec()
	{
	    for (int i = params.length-1; i>=0; i--) {
			params[i] = ms.popStack();
		/*DEBUG 2*/ //System.out.println("\t\t"+i+". Hole vom Stack: "+params[i].toString());
	    }
		try
		{
			ms.pushStack(operation.eval(params));
		}
		catch (Exception e)
		{
			/* Generierung einer Fehlermeldung */
			String tempStr;
			tempStr = "\nFEHLER bei dem Ausfuehren eines OP-Codes!\n";
			tempStr += "\tbei der Adresse "+ms.getPCAddress()+"\n";
			tempStr += "\tin Operation "+operation.toString()+"\n";
			tempStr += "\twegen: "+e.getMessage()+"\n";
			ms.setStatusError(tempStr);
		}
	}
	
	/**
	 * Konvertiert die Instruktion in ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	public
	String toString()
	{
		return new String("COMPUTE "+operation.toString());
	}
}
