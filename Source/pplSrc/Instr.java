/* $Id: Instr.java,v 1.6 2003/01/10 08:46:21 ii3839 Exp $ */

package ppl;

import ppl.machine.MachineState;
import ppl.mv.*;

/**
 * Dies ist eine Abstrakte Klasse fuer die Instruktionen der Virtuellen
 * Maschine. Von ihr werden alle konkreten Instruktionen abgeleitet.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

abstract public
class Instr {
    
    /**
     * Status der Virtuellen Maschine
     */	
    protected
    MachineState ms;
    
    /**
     * Konstruktor fuer das Erzeugen einer Instruktion.
     * @param ms Status der Virtuellen Maschine
     */
    public
    Instr(MachineState ms)
    {
    	this.ms = ms;
    }

	/**
	 * Funktion zum Ausfuehren einer Instruktion.
	 */
	abstract public
	    void exec();

	/**
	 * Konvertiert eine Instruktion ein String. Diese Funktion kann fuer
	 * das Debugen verwendet werden.
	 * @return Instruktion als String
	 */
	abstract public
	    String toString();
    }

