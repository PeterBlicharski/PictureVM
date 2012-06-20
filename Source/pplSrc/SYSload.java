/* $Id: SYSload.java,v 1.5 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.syscalls;

import ppl.mv.MachineValue;
import ppl.machine.MachineState;
import ppl.picture.PictureIO;

/**
 * Diese Klasse implementiert den System-Call zum Einlesen eines Bildes aus
 * einer Datei. Als Parameter wird ein MVString-Wert benoetigt. Das Ergebnis
 * ist ein Bild vom Typ MVPicture.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class SYSload implements SYS
{
	/**
     * Methode die von aussen die Verabeitung startet.     
     *
     * @param ms Status der Maschine
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Das eingelesene Bils als MachineValue
     */	
	public	
	MachineValue eval(MachineState ms, MachineValue [] params)
	{ 
	    return PictureIO.loadFromFile(params[0].toString());		
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "load";
	}
}
