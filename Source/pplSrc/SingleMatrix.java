/* $Id: SingleMatrix.java,v 1.15 2003/01/10 07:47:32 ii3839 Exp $ */ 

package ppl.picture;

import ppl.mv.MVList;
import ppl.mv.MVPicture;


/**
 * In dieser Klasse wird die Schnittstelle fuer Matrizen als Array of double
 * implementiert.
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public class SingleMatrix extends Matrix{
	/**
	 * Pixeldaten der Matrix
	 */
    private double[] pixel;

	/**
	 * Breite der Matrix
	 */
    private int width;

	/**
	 * Hoehe der Matrix
	 */
    private int height;

	/**
	 * Konstruktor fuer das Erzeugen einer Matrix
	 * @param width Breite der Matrix
	 * @param height Hoehe der Matrix
	 */
    public SingleMatrix (int width, int height) {
	this.width = width;
	this.height = height;
	this.pixel = new double[width * height];
    }

	/**
	 * Konstruktor fuer das Erzeugen einer Matrix
	 * @param width Breite der Matrix
	 * @param height Hoehe der Matrix
	 * @param pixel Pixeldaten der Matrix
	 */
    public SingleMatrix (int width, int height, double[] pixel) {
	this.width = width;
	this.height = height;
	this.pixel = pixel;
    }

    /**
	 * Auslesen der Breite einer Matrix
	 * @return Breite der Matrix
	 */
    public int getWidth() {
	return this.width;
    }

	/**
	 * Auslesen der Hoehe einer Matrix
	 * @return Hoehe der Matrix
	 */
    public int getHeight() {
	return this.height;
    }

	/**
	 * Vertikales Zusammensetzen einer Matrix als Gegenstueck zum 
	 * vertikalen Partitionieren einer Matrix
	 * @param list Liste mit den Bildern, die zusammengesetzt werden sollen
	 * @return Matrix aus den zusammengesetzten Teilbildern
	 */
    public static Matrix mergeV (MVList list) { 
	if (list.isEmpty()) {
	    return new SingleMatrix(0,0);
	} else {
	    int minWidth = ((MVPicture)list.getIndex(0)).getWidth();
	    int minHeight = ((MVPicture)list.getIndex(0)).getHeight();
	    for (int i = 0; i < list.getLength(); i++) {
		if (minWidth > ((MVPicture)list.getIndex(i)).getWidth()) {
		    minWidth = ((MVPicture)list.getIndex(i)).getWidth();
		}
		if (minHeight > ((MVPicture)list.getIndex(i)).getHeight()) {
		    minHeight = ((MVPicture)list.getIndex(i)).getHeight();
		}
	    }
	    Matrix temp = new SingleMatrix(minWidth*list.getLength(),minHeight);
	    int z = 0;
	    for (int j = 0; j < minWidth; j++) {
		for (int i = 0; i < list.getLength(); i++, z++) {
		    MVPicture oldPic = (MVPicture)list.getIndex(i);
		    temp.setCol(oldPic.pixel.getCol(j),z);
		}
	    }
	    return temp;
	}
    }
	
	/**
	 * Horizontales Zusammensetzen einer Matrix als Gegenstueck zum 
	 * horizontalen Partitionieren einer Matrix
	 * @param list Liste mit den Bildern, die zusammengesetzt werden sollen
	 * @return Matrix aus den zusammengesetzten Teilbildern
	 */
    public static Matrix merge (MVList list) { 
	if (list.isEmpty()) {
	    return new SingleMatrix(0,0);
	} else {
	    int minWidth = ((MVPicture)list.getIndex(0)).getWidth();
	    int minHeight = ((MVPicture)list.getIndex(0)).getHeight();
	    for (int i = 0; i < list.getLength(); i++) {
		if (minWidth > ((MVPicture)list.getIndex(i)).getWidth()) {
		    minWidth = ((MVPicture)list.getIndex(i)).getWidth();
		}
		if (minHeight > ((MVPicture)list.getIndex(i)).getHeight()) {
		    minHeight = ((MVPicture)list.getIndex(i)).getHeight();
		}
	    }
	    Matrix temp = new SingleMatrix(minWidth,minHeight*list.getLength());
	    int z = 0;
	    for (int j = 0; j < minHeight; j++) {
		for (int i = 0; i < list.getLength(); i++, z++) {		
		    MVPicture oldPic = (MVPicture)list.getIndex(i);
		    temp.setRow(oldPic.pixel.getRow(j),z);
		}
	    }
	    return temp;
	}
    }

	/**
	 * Vertikales Zusammensetzen einer Matrix als Gegenstueck zum 
	 * vertikalen Spliten einer Matrix
	 * @param list Liste mit den Bildern, die zusammengesetzt werden sollen
	 * @return Matrix aus den zusammengesetzten Teilbildern
	 */
    public static Matrix concatV (MVList list) 
    { 
		if (list.isEmpty()) 
		{
	    	return new SingleMatrix(0,0);
		} 
		else 
		{	    
	    	int minHeight = ((MVPicture)list.getIndex(0)).getHeight();
	    	int sumWidth = 0;
	    
	    	for (int i = 0; i < list.getLength(); i++) 
	    	{
				if (minHeight > ((MVPicture)list.getIndex(i)).getHeight())
				{
			    	minHeight = ((MVPicture)list.getIndex(i)).getHeight();
				}
				sumWidth += ((MVPicture)list.getIndex(i)).getWidth();
			}
			
			Matrix temp = new SingleMatrix(sumWidth,minHeight);
			
			int col = 0;
	    	for (int i = 0; i < list.getLength(); i++)
	    	{		
				MVPicture oldPic = (MVPicture)list.getIndex(i);
				for (int j = 0; j < oldPic.getWidth(); j++) 
				{
			    	temp.setCol(oldPic.pixel.getCol(j),col++);
				}
	    	}
	    	return temp;
		}
    }

	/**
	 * Vertikales Zusammensetzen einer Matrix als Gegenstueck zum 
	 * vertikalen Spliten einer Matrix
	 * @param list Liste mit den Bildern, die zusammengesetzt werden sollen
	 * @return Matrix aus den zusammengesetzten Teilbildern
	 */
    public static Matrix concat (MVList list)
    { 
		if (list.isEmpty()) 
		{
	    	return new SingleMatrix(0,0);
		} 
		else 
		{	    
		    int minWidth = ((MVPicture)list.getIndex(0)).getWidth();	    	
	    	int sumHeight = 0;
	    
	    	for (int i = 0; i < list.getLength(); i++) 
	    	{
				if (minWidth > ((MVPicture)list.getIndex(i)).getWidth())
				{
			    	minWidth = ((MVPicture)list.getIndex(i)).getWidth();
				}
				sumHeight += ((MVPicture)list.getIndex(i)).getHeight();
			}
			
			Matrix temp = new SingleMatrix(minWidth,sumHeight);
			
			int row = 0;
	    	for (int i = 0; i < list.getLength(); i++)
	    	{		
				MVPicture oldPic = (MVPicture)list.getIndex(i);
				for (int j = 0; j < oldPic.getHeight(); j++) 
				{
			    	temp.setRow(oldPic.pixel.getRow(j),row++);
				}
	    	}
	    	return temp;
		}
    }

	/**
	 * Vertikales, spaltenweises zerlegen eines Bildes in eine bestimmte Anzahl
	 * von Teilbildern.
	 * @param chop Anzahl der Teilbilder
	 * @return Liste mit den Teilbildern
	 */
    public MVList partV (int chop) { 
	MVList l = MVList.makeEmpty();

	if (width < chop) {
	    l = l.appendMV(MVPicture.makeEmpty());	    
	} else {
	    int count = width / chop;
	    int rest = width % chop;
	    
	    int over = rest;
	    for (int i=0; i < chop; i++, over--) {
		if (over > 0) {
		    l = l.appendMV(new MVPicture(new SingleMatrix(count+1,height)));
		} else {
		    l = l.appendMV(new MVPicture(new SingleMatrix(count,height)));     
		}
	    }
	    int z = 0;
	    for (int node = 0; node < count; node++) {	
		for (int j = 0; j < chop; j++, z++) {
		    MVPicture oldPic = (MVPicture)l.getIndex(j); 
		    oldPic.pixel.setCol(getCol(z),node);
		}
	    }	
	    for (int i = 0; i < rest; i++, z++) {
		MVPicture oldPic = (MVPicture)l.getIndex(i); 
		oldPic.pixel.setCol(getCol(z),count);
	    }
	}	
	return l;
    }

	/**
	 * Horizontales, spaltenweises zerlegen eines Bildes in eine bestimmte Anzahl
	 * von Teilbildern
	 * @param chop Anzahl der Teilbilder
	 * @return Liste mit den Teilbildern
	 */
    public MVList part (int chop) {
	MVList l = MVList.makeEmpty();
	
	if (height < chop) {
	    l = l.appendMV(MVPicture.makeEmpty());	    
	} else {
	    int count = height / chop;
	    int rest = height % chop;
	    
	    int over = rest;
	    for (int i=0; i < chop; i++, over--) {
		if (over > 0) {
		    l = l.appendMV(new MVPicture(new SingleMatrix(width,count+1)));
		} else {
		    l = l.appendMV(new MVPicture(new SingleMatrix(width,count)));     
		}
	    }
	    int z = 0;
	    for (int node = 0; node < count; node++) {	
		for (int j = 0; j < chop; j++, z++) {
		    MVPicture oldPic = (MVPicture)l.getIndex(j); 
		    oldPic.pixel.setRow(getRow(z),node);
		}
	    }	
	    for (int i = 0; i < rest; i++, z++) {
		MVPicture oldPic = (MVPicture)l.getIndex(i); 
		oldPic.pixel.setRow(getRow(z),count);
	    }
	}
	return l;
    }
    
    /**
	 * Vertikales zerlegen eines Bildes in eine bestimmte Anzahl von Teilbildern.
	 * @param chop Anzahl der Teilbilder
	 * @return Liste mit den Teilbildern
	 */
    public MVList splitV (int chop) {
	MVList l = MVList.makeEmpty();
	
	int count = width / chop;
	int rest = width % chop;
	    
	if (rest > 0) {
	    chop -= 1; 
	}

	int z = 0;
	for (int node = 0; node < chop; node++) {	
	    SingleMatrix old = new SingleMatrix(count,this.height);
	    for (int j = 0; j < count; j++, z++) {
		old.setCol(getCol(z),j);
	    }
	    l = l.appendMV(new MVPicture(old));
	}
	if (rest > 0) {
	    SingleMatrix old = new SingleMatrix(rest+count,this.height);
	    for (int j = 0; j < rest+count; j++, z++) {
		old.setCol(getCol(z),j);
		
	    }
	    l = l.appendMV(new MVPicture(old));
	}
	return l;
    }

	/**
	 * Horizontales zerlegen eines Bildes in eine bestimmte Anzahl von Teilbildern.
	 * @param chop Anzahl der Teilbilder
	 * @return Liste mit den Teilbildern
	 */
    public MVList split (int chop) {
	MVList list = MVList.makeEmpty();
	
	int count = height / chop;
	int rest = height % chop;
	    
	if (rest > 0) {
	    chop -= 1; 
	}

	int z = 0;
	for (int node = 0; node < chop; node++) {	
	    SingleMatrix old = new SingleMatrix(this.width,count);
	    for (int j = 0; j < count; j++, z++) {
		old.setRow(getRow(z),j);
	    }
	    list = list.appendMV(new MVPicture(old));
	}
	if (rest > 0) {
	    SingleMatrix old = new SingleMatrix(this.width,rest+count);
	    for (int j = 0; j < rest+count; j++, z++) {
		old.setRow(getRow(z),j);
	    }
	    list = list.appendMV(new MVPicture(old));
	}
	return list;
    }
    
	/**
	 * Zusammenfuegen von zwei Matrizen, so dass sich die eine ueber der anderen
	 * befindet.
	 * @param pic Matrix, die unter dieser eingefuegt werden soll
	 * @return Matrix mit der unten angehaengten
	 */
    public Matrix above (Matrix pic) {
	SingleMatrix temp = new SingleMatrix(this.width,this.height+pic.getHeight());
	int z=0;
		
	int endPic = pic.getHeight();

	for (int j=0; j < this.width; j++) {
	    /*Fuelle EndMatrix mit der Zeile der ersten Matrix */
	    int orgIndex=0; z = 0;
 	    for (int i=0; i < this.height; i++, z++, orgIndex++) 
 		temp.setPixel( j+this.width*z,
			       pixel[j+this.width*orgIndex]);
	    /* Fuelle EndMatrix mit der Zeile der zweiten Matrix */
	    int picIndex=0;
 	    if (j >= pic.getWidth()) 
 		for (int k=0; k < endPic; k++, z++) {
 		    // Ist die zweite Matrix kleiner als die erste muss mit Schwarz aufgefuellt werden
 		    temp.setPixel(j+this.width*z ,
 				  0.0);
		}
	    else {
		for (int k=0; k < endPic; k++, z++, picIndex++)
 		    temp.setPixel(j+this.width*z,
 				  pic.getPixel(j+pic.getWidth()*picIndex));
	    }
	}
	return temp;
    }

   	/**
	 * Zusammenfuegen von zwei Matrizen, so dass sich die eine neben der anderen
	 * befindet.
	 * @param sbsMatrix Matrix, die neben dieser eingefuegt werden soll
	 * @return Matrix mit der seitlich angehaengten
	 */ 
    public Matrix sideBySide (Matrix sbsMatrix) {
	SingleMatrix temp = new SingleMatrix(sbsMatrix.getWidth()+this.width,this.height);
	int z=0;
	int orgIndex = 0;
	int sbsIndex = 0;

	int endSbs = sbsMatrix.getWidth();

	for (int j=0; j < this.height; j++) {
	    /*Fuelle EndMatrix mit der Zeile der ersten Matrix */
	    for (int i=0; i < this.width; i++, z++, orgIndex++) 
		temp.setPixel(z ,
			      pixel[orgIndex]);
	    /* Fuelle EndMatrix mit der Zeile der zweiten Matrix */
	    if (j >= sbsMatrix.getHeight()) 
		for (int k=0; k < endSbs; k++, z++)
		    /*Ist die zweite Matrix kleiner als die erste muss mit Schwarz aufgefuellt werden */
		    temp.setPixel(z ,
				  0.0);
	    else 
		for (int k=0; k < endSbs; k++, z++, sbsIndex++)
		    temp.setPixel(z,
				  sbsMatrix.getPixel(sbsIndex));
	    
	}
	return temp;
    }
    
	/**
	 * Vervielfaeltigen einer Matrix in horizontaler und vertikaler Rechtung.
	 * @param newWidth Breite der vervielfaeltigten Matrix
	 * @param newHeight Hoehe der vervielfaeltigten Matrix
	 * @return vervielfaeltigte Matrix
	 */
    public Matrix replicate (int newWidth, int newHeight) {
	
	if ((newWidth > 0) && (newHeight > 0)) {
	    
	    SingleMatrix temp = new SingleMatrix(newWidth*this.width,newHeight*this.height);
	    int z = 0;
	    
	    for(int k= 0; k < newHeight; k++) 
		for(int j=0; j < this.height; j++)
		    for(int l=0; l < newWidth; l++)
			for(int i=0; i < this.width; i++,z++)
			    temp.setPixel(z,
					  pixel[j * this.width + i]);
	    
	    return temp;
	    
	}
	return new SingleMatrix(0,0);
    }

	/**
	 * Vergroessern der Matrix auf ein Vielfaches ihrer Hoehe oder Breite.
	 * @param newWidth Breite der skalierten Matrix
	 * @param newHeight Hoehe der skalierten Matrix
	 * @return skalierte Matrix
	 */
    public Matrix scale (int newWidth, int newHeight) {
	
	if ((newWidth > 0) && (newHeight > 0)) {

	    SingleMatrix temp = new SingleMatrix(newWidth*this.width,newHeight*this.height);
    
	    for(int j=0, z=0; j < this.height; j++)
		for(int k= 0; k < newHeight; k++)
		    for(int i=0; i < this.width; i++)
			for(int l=0; l < newWidth; l++, z++)
			    temp.setPixel(z, 
					  pixel[j * this.width + i]);
	    
	    return temp;
	}
	return new SingleMatrix(0,0);
    }

	/**
	 * Einfuegen einer Matrix in eine andere an einer bestimmten Position.
	 * @param x vertikale Position des Ausschnitts
	 * @param y horizontale Position des Ausschnitts
	 * @param pasteMatrix einzufuegender Ausschnitt
	 * @return Matrix mit dem eingefuegten Ausschnitt
	 */
    public Matrix paste(int x, int y, Matrix pasteMatrix) {
	
	Matrix temp = this.cloneMatrix();
	
	int pasteWidth = pasteMatrix.getWidth();
	int pasteHeight = pasteMatrix.getHeight();
	
	int hoffset, woffset, hoffset2, woffset2;
	
	if (x + pasteMatrix.getWidth() > this.width) pasteWidth = this.width - x;
	if (y + pasteMatrix.getHeight() > this.height) pasteHeight = this.height - y;

	if (y < 0) {
	    pasteHeight = pasteHeight + y;
	    hoffset = 0;
	} else {
	    hoffset = y;
	}

	
	if (x < 0) {
	    pasteWidth = pasteWidth + x;
	    woffset2 = -x;
	    woffset = 0;
	} else {
	    woffset = x;
	    woffset2 = 0;
	}

	
	for(int j=0; j < pasteHeight; j++)
	    for(int i=0; i < pasteWidth; i++)
		temp.setPixel((j+hoffset)*this.width+(i+woffset),  pasteMatrix.getPixel(j*pasteWidth+i));

	return temp;
    }
    
    /**
	 * Ausschneiden eines Teils der Matrix an einer bestimmten Position.
	 * @param newWidth Breite des Ausschnitts
	 * @param newHeight Hoehe des Ausschnitts
	 * @param x vertikale Position des Ausschnitts
	 * @param y horizontale Position des Ausschnitts
	 * @return Ausschnitt aus der Matrix
	 */
    public Matrix cut(int newWidth, int newHeight, int x, int y) {
	
	if (x<0) x=0;
	if (y<0) y=0;
	if (newWidth  > this.width + x) newWidth = this.width + x;
	if (newHeight > this.height + y) newHeight = this.height + y;
	
	SingleMatrix temp = new SingleMatrix(newWidth,newHeight);
	int z = 0;

	for(int j=y; j < y + newHeight; j++)
	    for(int i=x; i < x + newWidth; i++, z++)
		temp.setPixel(z, 
			      pixel[j * this.width + i]);

	return temp;
    }

	/**
	 * Horizontales und vertikales Verschieben des Inhaltes einer Matrix um
	 * einen bestimmten Offset.
	 * @param shiftV vertikaler Offset der Verschiebung
	 * @param shiftH horizontaler Offset der Verschiebung
	 * @return Matrix mit geshiftetem Inhalt
	 */
    public Matrix shift(int shiftH,int shiftV) {
	
	SingleMatrix temp = new SingleMatrix(this.width, this.height);

	shiftV %= this.height;
	shiftH %= this.width;
	
	for(int j=0; j < this.width; j++, shiftH++, shiftH %= this.width)
	    for(int i=0; i < this.height; i++, shiftV++, shiftV %= this.height)
		temp.setPixel((i * this.width + j), 
			      pixel[shiftV * this.width + shiftH]);
	return temp;
    }	
    
    /**
	 * Transponieren einer Matrix.
	 * @return transponierte Matrix
	 */
    public Matrix transpose() {

	SingleMatrix temp = new SingleMatrix(this.height,this.width);
	int z = 0;
	
	for (int j=0; j < this.width; j++) 
	    for (int i=0; i < this.height; i++, z++) 
		temp.setPixel(z, 
			      pixel[j+i*width]);
    	return temp;	
    }
    
    /**
	 * Umdrehen einer Matrix.
	 * @return umgedrehte Matrix
	 */
    public Matrix reverse() {
	
	SingleMatrix temp = new SingleMatrix(this.width,this.height);
	int z = 0;
	
	for (int j=0; j < this.height; j++)
	    for (int i=0; i < this.width; i++, z++)
		temp.setPixel(z, 
			      pixel[this.width*this.height - 1 - z]);
	return temp;	
    }

    
    /**
	 * Spiegeln einer Matrix
	 * @return gespiegelte Matrix
	 */
    public Matrix partReverse() {
	SingleMatrix temp = new SingleMatrix(this.width,this.height);
	int z = 0;
	
	for (int j=1; j <= this.height; ++j) { 
	    for (int i=0; i < this.width; i++, z++) {
		temp.setPixel(z, 
			      pixel[this.width * j - i - 1]);
	    }
	}
	return temp;
    }
    
    /**
	 * Setzen eines Pixels an einer bestimmten Position der Matrix.
	 * @param pixel Index des Pixels in der Matrix
	 * @param value Wert des Pixels
	 */
    public void setPixel(int pixel, double value) {
	this.pixel[pixel] = value;
    }
    
    /**
	 * Auslesen eines Pixels an einer bestimmten Position der Matrix.
	 * @param pixel Index des Pixels in der Matrix
	 * @return Wert des Pixels
	 */
    public double getPixel(int pixel) {
	return this.pixel[pixel];
    }

	/**
	 * Ausgeben der Matrix-Daten als Single-Array
	 * @return Matrix-Daten
	 */
    public double[] getPixelAsSingleArray() {
	return this.pixel;
    }   

	/**
	 * Verdoppeln einer Matrix
	 * @return Duplikat der Matrix
	 */
    public Matrix cloneMatrix() {
	return new SingleMatrix(this.width, this.height, (double[])this.pixel.clone()); 
    }

	/**
	 * Auslesen der Zeile an einer bestimmten Position der Matrix
	 * @param i Index der auszulesenden Zeile
	 * @return Daten der Zeiler als Array of double
	 */
    public double[] getRow(int i) {

	if (i > height) {
	    return null;
	}

	int offset = i * width;
	double[] temp = new double[width];
	int j = 0;

	for (int z = offset; z < offset+width; z++, j++) {
	    temp[j] = pixel[z];
	}
	return temp;
    }

	/**
	 * Auslesen der Spalte an einer bestimmten Position der Matrix
	 * @param i Index der auszulesenden Spalte
	 * @return Daten der Spalte als Array of double
	 */
    public double[] getCol(int i) {
	if (i > width) {
	    return null;
	}
	int j = 0;
	double[] temp = new double[height]; 
	for (int z=i; z < width*height; z+=width, j++) {
	    temp[j] = pixel[z]; 
	}
	return temp;
    }

	/**
	 * Setzen der Spalte an einer bestimmten Position der Matrix
	 * @param line Daten der zu schreibenden Spalte
	 * @param i Index der zu schreibenden Spalte	 
	 */
    public void setCol (double[] line, int i) {
	if ((i <= width) && (line.length >= height)) {
	    int j = 0;
	    for (int z=i; z < width*height; z+=width, j++) {
		pixel[z] = line[j];
	    }
	}

    }

	/**
	 * Setzen der Zeile an einer bestimmten Position der Matrix
	 * @param line Daten der zu schreibenden Zeile
	 * @param i Index der zu schreibenden Zeile	 
	 */	
    public void setRow(double[] line, int i) {
	if ((i <= height) && (line.length >= width)) {
	    int offset = i * width;
	    int j = 0;
	    for (int z = offset; z < offset+width; z++, j++) {
		pixel[z] = line[j];
	    }
	}
    }

    
}

