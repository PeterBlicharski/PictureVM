/* $Id: OP.java,v 1.4 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.op;

import ppl.mv.MachineValue;

/**
 * Schnittstellendefinition für alle Befehle, die die VM - fuer PPL verabeiten kann.
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public interface OP
{
    /**
     * Diese Methode leitet die Verarbeitung ein.
     *
     * @param params enthaellt alle Uebergabeparameter in einer definierten Reihenfolge
     * @return einen beliebigen MachineValue
     */
    public
	MachineValue eval(MachineValue [] params);
	
    /**
     * Konvertiert den OP-Code in einen String
     * @return den OP-Code als <code>String</code>
     */
    public
	String toString();
}
