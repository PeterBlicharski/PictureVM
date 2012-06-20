 /* $Id: PnmPicture.java,v 1.6 2003/01/10 07:47:32 ii3839 Exp $ */ 

package ppl.picture;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * <code>PnmPicture</code>.
 * Implementiert eine Klasse zum Lesen von Pnm-Dateien
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a>
 * @author Malte Hopmann
 * @version 1.0
 */
public class PnmPicture extends PictureType implements PnmStates{

        
    /**
     * Creates a new <code>PnmPicture</code> instance.
     *
     * @param io a <code>BufferedInputStream</code> value
     */
    public PnmPicture (BufferedInputStream io) {
	super(io);
    }
    

    private boolean readComment () {
	char temp;
	boolean status = true;
	io.mark(1);
	
	temp = readChar();
	if (! isComment(temp)) {
	    try {
		io.reset();
	    } catch (IOException e) {
		throw new RuntimeException("Fehler: "+e);
	    }
	    temp = '\n';
	    status = false;
     	} 	
	while (! isNewline(temp)) {
	    temp = readChar();
	}
	return status;
    }


    /**
     * Describe <code>parse</code> method here.
     *
     * @return a <code>BufferedReader</code> value
     */
    public BufferedInputStream parse() {
	
	int state = PnmStates.magic;
	while (state != PnmStates.ende) {
	    switch (state) {
		case PnmStates.magic : while (readComment());
		this.magicNumber = new String(parseString());
		state = PnmStates.wid;
		break;
		case PnmStates.wid : while (readComment());
		this.width = parseInteger();
		state = PnmStates.hei;
		break;
		case PnmStates.hei : while (readComment());
		this.height = parseInteger();
		state = PnmStates.maxv;
		break;
		case PnmStates.maxv : while (readComment());
		this.maxval = parseInteger();
		state = PnmStates.ende;
		break;
            }
        }
        return this.io;
    }

}
