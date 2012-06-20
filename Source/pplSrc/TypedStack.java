/* $Id: TypedStack.java,v 1.5 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.machine;

import ppl.mv.*;

/**
 * Die Klasse TypedStack implementiert einen Stack, auf dem nur Daten vom Typ
 * MachineValue gespeichert werden können. Er dient in diesem Programm als
 * Evaluation-Stack. Die Klasse erbt von java.util.Stack.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class TypedStack extends java.util.Stack
{
	/**
	 * Konstruktor fuer den Stack 
	 */
	public TypedStack()
	{
		super();
	}
	
	/**
	 * Routine zum pushen eines MachineValues MV auf den Stack
	 * @param MV Der auf dem Stack abzulegende Wert
	 */
	public 
	void pushMV(MachineValue MV)
	{
		super.push(MV);
	}
	
	/**
	 * Funktion zum popen eines Wertes vom Stack
	 * @return Oberster Wert auf dem Stack als MachineValue
	 * @throws RuntimeException Es kann kein Element von einem leeren Stack
	 * gepopt werden.
	 */
	public
	MachineValue popMV()
	{
		if (! isEmpty())
			return (MachineValue) pop();
		else
		{						
			throw new RuntimeException("Der Stack fuer Machine-Values ist leer !");			
		}
	}
	
	/**
	 * Auslesen des obersten Elements vom Stack
	 * @return Oberstes Stack-Element als MachineValue
	 */
	public
	MachineValue peekMV()
	{
		return (MachineValue) peek();
	}	
}
