/* $Id: SYSstore.java,v 1.4 2003/01/10 07:47:32 ii3839 Exp $ */

package ppl.syscalls;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.machine.MachineState;
import ppl.picture.PictureIO;


/**
 * Diese Klasse implementiert den System-Call zum Speichern eines Bildes in
 * eine Datei. Als Parameter werden ein MVPicture-Wert und ein MVString-Wert 
 * benoetigt. Das Ergebnis ist der Status der Operation.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class SYSstore implements SYS
{
	/**
     * Methode die von aussen die Verabeitung startet.     
     *
     * @param ms Status der Maschine
     * @param params Alle fuer die Operation benoetigten Parameter als MachineValue
     * @return Der Status als MachineValue
     */	
	public	
	MachineValue eval(MachineState ms, MachineValue [] params) 
	{					
		return PictureIO.storeToFile(params[1].toString(),(MVPicture)params[0]);		
	}
	
	/**
	 * Konvertiert den OP-Code in einen String
	 *
	 * @return dieser OP-Code als String
	 */
	public
	String toString()
	{
		return "store";
	}
}
