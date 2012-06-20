/* $Id: MachineValue.java,v 1.6 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.mv;

/**
 * Abstrakte Klasse für die Datentypen der Virtuellen Maschine.
 * Alle konkreten Datentypen muessen von dieser Klasse erben.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
abstract public
class MachineValue {
	
	/**
	 * Duplizeiern eines Datums
	 * @return Kopie vom Typ MachineValue
	 */
	abstract
	public
	MachineValue copy();		
	
	/**
	 * Konvertiert ein MachineValue in einen int
	 * @return MachineValue als int
	 * @throws RuntimeException Fehler bei dem Cast
	 */
	public
	int toInt()
	{		
		throw new RuntimeException("toInt ist auf diesem Typ nicht definiert");
	}
	
	/**
	 * Konvertiert ein MachineValue in ein float
	 * @return MachineValue als float
	 */
	public
	float toFloat()
	{		
		throw new RuntimeException("toFloat ist auf diesem Typ nicht definiert");
	}
	
	/**
	 * Konvertiert ein MachineValue in eine Adresse
	 * @return MachineValue als int
	 * @throws RuntimeException Fehler bei dem Cast
	 */
	public
	int toAddress()
	{		
		throw new RuntimeException("toAddress ist auf diesem Typ nicht definiert");
	}
	
	/**
	 * Funktion zur String-Konvertierung.
	 * @return MachineValue als String
	 * @throws RuntimeException Fehler bei dem Cast
	 */	
	public
	String toString()
	{
		throw new RuntimeException("toString ist auf diesem Typ nicht definiert");
	}
    
    /**
	 * Konvertiert ein MachineValue in ein MVList
	 * @return MachineValue als MVList
	 * @throws RuntimeException Fehler bei dem Cast
	 */	
    public
	MVList toList()
    {
    	try
		{			
			return (MVList) this;
		}
		catch (ClassCastException E)
		{			
			throw new RuntimeException("toMVList ist auf diesem Typ nicht definiert");
		}
    }
    
    /**
	 * Konvertiert ein MachineValue in ein MVPicture
	 * @return MachineValue als MVPicture
	 * @throws RuntimeException Fehler bei dem Cast
	 */	
    public
	MVPicture toPicture()
    {
    	try
		{			
			return (MVPicture) this;
		}
		catch (ClassCastException E)
		{			
			throw new RuntimeException("toPicture ist auf diesem Typ nicht definiert");
		}
    }
}
