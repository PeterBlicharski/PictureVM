/* $Id: OPP.java,v 1.9 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;

/**
 * <code>OPP</code>
 * Diese Klasse dient als Schittstelle fuer alle Befehle der VM fuer PPL-Befehle, 
 * die auf einem und nur einem Bild arbeiten.
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public abstract class OPP implements OP 
{
    MachineValue[] params = null;
    //XXX: Erwartet als ersten Parameter das Bild und als zweiten den Gamma-Wert
    //XXX: Stimmt die Reihenfolge in params? Malte fragen!
    
    /**
     * Methode die von aussen die Verabeitung startet. 
     *
     * @param params alle benoetigten Parameter params als <code>MachineValue[]</code>
     * @return Das bearbeitete Bild als <code>MachineValue</code>
     */
    public MachineValue eval(MachineValue[] params) {
	int anzahl = ((MVPicture)params[0]).getWidth() * ((MVPicture)params[0]).getHeight();
	this.params = params;
	return ((MVPicture)params[0]).forAllPixel(this); 
    }
    
    /**
     * Methode, die einen Algorithmus auf Pixelebene ausfuehrt und somit fuer jedes Pixel aufgerufen wird.
     * Hier sollte die eigenliche Berechnung statt finden.
     *
     * @param pixel a <code>double</code> value
     * @return a <code>double</code> value
     */
    public abstract double eval (double pixel); 
    
	
    /**
     * Konvertiert den OP-Code in einen String
     * @return den OP-Code als <code>String</code>
     */
    public abstract String toString();
    
}
