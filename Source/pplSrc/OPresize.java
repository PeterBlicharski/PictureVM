/* $Id: OPresize.java,v 1.11 2003/01/10 07:47:32 ii3839 Exp $ */ 

package ppl.op;

import ppl.mv.MachineValue;
import ppl.mv.MVPicture;
import ppl.picture.Matrix;
import ppl.picture.SingleMatrix;

/**
 * <code>OPresize</code>
 * Skaliert das Bild auf eine neue Groesse.
 * <a name="folge">Erwartet werden:</a> 
 * <ol>
 *   <li>Bild
 *   <li>neue Breite
 *   <li>neue Hoehe
 * </ol>
 * @author unbekannt
 */

public class OPresize implements OP {

    private double s = 0.5;
    public MachineValue eval(MachineValue[] params) {


	  int newwidth = params[1].toInt();
	  int newheight = params[2].toInt();

	  if ((newwidth<1) || (newheight<1)) 
	      return MVPicture.makeEmpty();
	  else
	  {
	      int w = ((MVPicture)params[0]).getWidth();
	      int h = ((MVPicture)params[0]).getHeight();
	      
	      Matrix newdata = new SingleMatrix(newwidth,newheight);
	      double scalex = (w-1)/(double)(newwidth);
	      double scaley = (h-1)/(double)(newheight);
	      
	      for(int y=0, z=0; y<newheight; y++)
	      {
		  double k = y * scaley;
		  for(int x=0; x<newwidth; x++, z++)
		  {
		      double l = x * scalex;
		      newdata.setPixel(z, ((MVPicture)params[0]).pixel.getPixel((int)Math.round(k)*w + (int)Math.round(l)));
		  }
	      }
	    return new MVPicture("P5",255, newdata); 
	}
    }
    
    /**
     * Erzeugt den String "resize", der die Klasse repräsentiert
     *
     * @return resize als <code>String</code>
     */
    public String toString() {
	return "resize";
    }

} 
