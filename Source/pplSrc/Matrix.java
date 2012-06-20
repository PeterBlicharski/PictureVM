/* $Id: Matrix.java,v 1.11 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.picture;

import ppl.mv.MVList;
import java.lang.RuntimeException;

/**
 * Schnittstellendefinition fuer die Befehle, die auf einer Matrix arbeiten
 *
 * @author <a href="mailto:peter@ghandi.de">Peter Blicharski</a> (ii3839)
 * @author <a href="mailto:ii4271@fh-wedel.de">Malte Hopmann</a> (ii4271)
 * @version 1.0
 */
public abstract class Matrix {

	/**
	 * Auslesen der Breite einer Matrix
	 * @return Breite der Matrix
	 */
    public abstract int getWidth();

	/**
	 * Auslesen der Hoehe einer Matrix
	 * @return Hoehe der Matrix
	 */
    public abstract int getHeight();

	/**
	 * Vertikales Zusammensetzen einer Matrix als Gegenstueck zum 
	 * vertikalen Partitionieren einer Matrix
	 * @param list Liste mit den Bildern, die zusammengesetzt werden sollen
	 * @return Matrix aus den zusammengesetzten Teilbildern
	 */
    public static Matrix mergeV (MVList list) {
	throw new RuntimeException("mergeV fuer Matrix nicht implementiert");
    }

	/**
	 * Horizontales Zusammensetzen einer Matrix als Gegenstueck zum 
	 * horizontalen Partitionieren einer Matrix
	 * @param list Liste mit den Bildern, die zusammengesetzt werden sollen
	 * @return Matrix aus den zusammengesetzten Teilbildern
	 */
    public static Matrix merge (MVList list) {
	throw new RuntimeException("mergeH fuer Matrix nicht implementiert");
    }

	/**
	 * Vertikales Zusammensetzen einer Matrix als Gegenstueck zum 
	 * vertikalen Spliten einer Matrix
	 * @param list Liste mit den Bildern, die zusammengesetzt werden sollen
	 * @return Matrix aus den zusammengesetzten Teilbildern
	 */
    public static Matrix concatV (MVList list) {
	throw new RuntimeException("concatV fuer Matrix nicht implementiert");
    }

	/**
	 * Vertikales Zusammensetzen einer Matrix als Gegenstueck zum 
	 * vertikalen Spliten einer Matrix
	 * @param list Liste mit den Bildern, die zusammengesetzt werden sollen
	 * @return Matrix aus den zusammengesetzten Teilbildern
	 */
    public static Matrix concat (MVList list) {
	throw new RuntimeException("concatH fuer Matrix nicht implementiert");
    }

	/**
	 * Vertikales zerlegen eines Bildes in eine bestimmte Anzahl von Teilbildern.
	 * @param chop Anzahl der Teilbilder
	 * @return Liste mit den Teilbildern
	 */
    public abstract MVList splitV (int chop);
    
    /**
	 * Horizontales zerlegen eines Bildes in eine bestimmte Anzahl von Teilbildern.
	 * @param chop Anzahl der Teilbilder
	 * @return Liste mit den Teilbildern
	 */
    public abstract MVList split (int chop);
    
    /**
	 * Vertikales, spaltenweises zerlegen eines Bildes in eine bestimmte Anzahl
	 * von Teilbildern.
	 * @param chop Anzahl der Teilbilder
	 * @return Liste mit den Teilbildern
	 */
    public abstract MVList partV (int chop);

	/**
	 * Horizontales, spaltenweises zerlegen eines Bildes in eine bestimmte Anzahl
	 * von Teilbildern
	 * @param chop Anzahl der Teilbilder
	 * @return Liste mit den Teilbildern
	 */
    public abstract MVList part (int chop);

	/**
	 * Zusammenfuegen von zwei Matrizen, so dass sich die eine ueber der anderen
	 * befindet.
	 * @param pic Matrix, die unter dieser eingefuegt werden soll
	 * @return Matrix mit der unten angehaengten
	 */
    public abstract Matrix above (Matrix pic);

	/**
	 * Zusammenfuegen von zwei Matrizen, so dass sich die eine neben der anderen
	 * befindet.
	 * @param sbsMatrix Matrix, die neben dieser eingefuegt werden soll
	 * @return Matrix mit der seitlich angehaengten
	 */
    public abstract Matrix sideBySide (Matrix sbsMatrix); 

	/**
	 * Vervielfaeltigen einer Matrix in horizontaler und vertikaler Rechtung.
	 * @param newWidth Breite der vervielfaeltigten Matrix
	 * @param newHeight Hoehe der vervielfaeltigten Matrix
	 * @return vervielfaeltigte Matrix
	 */
    public abstract Matrix replicate (int newWidth, int newHeight);

	/**
	 * Vergroessern der Matrix auf ein Vielfaches ihrer Hoehe oder Breite.
	 * @param newWidth Breite der skalierten Matrix
	 * @param newHeight Hoehe der skalierten Matrix
	 * @return skalierte Matrix
	 */
    public abstract Matrix scale (int newWidth, int newHeight);

	/**
	 * Einfuegen einer Matrix in eine andere an einer bestimmten Position.
	 * @param x vertikale Position des Ausschnitts
	 * @param y horizontale Position des Ausschnitts
	 * @param pasteMatrix einzufuegender Ausschnitt
	 * @return Matrix mit dem eingefuegten Ausschnitt
	 */
    public abstract Matrix paste(int x, int y, Matrix pasteMatrix);

	/**
	 * Ausschneiden eines Teils der Matrix an einer bestimmten Position.
	 * @param newWidth Breite des Ausschnitts
	 * @param newHeight Hoehe des Ausschnitts
	 * @param x vertikale Position des Ausschnitts
	 * @param y horizontale Position des Ausschnitts
	 * @return Ausschnitt aus der Matrix
	 */
    public abstract Matrix cut(int newWidth, int newHeight, int x, int y);

	/**
	 * Horizontales und vertikales Verschieben des Inhaltes einer Matrix um
	 * einen bestimmten Offset.
	 * @param wOffset vertikaler Offset der Verschiebung
	 * @param hOffser horizontaler Offset der Verschiebung
	 * @return Matrix mit geshiftetem Inhalt
	 */
    public abstract Matrix shift(int wOffset,int hOffset);

	/**
	 * Transponieren einer Matrix.
	 * @return transponierte Matrix
	 */
    public abstract Matrix transpose();

	/**
	 * Umdrehen einer Matrix.
	 * @return umgedrehte Matrix
	 */
    public abstract Matrix reverse ();

	/**
	 * Spiegeln einer Matrix
	 * @return gespiegelte Matrix
	 */
    public abstract Matrix partReverse();

	/**
	 * Setzen eines Pixels an einer bestimmten Position der Matrix.
	 * @param pixel Index des Pixels in der Matrix
	 * @param value Wert des Pixels
	 */
    public abstract void setPixel(int pixel, double value);

	/**
	 * Auslesen eines Pixels an einer bestimmten Position der Matrix.
	 * @param pixel Index des Pixels in der Matrix
	 * @return Wert des Pixels
	 */
    public abstract double getPixel(int pixel);

	/**
	 * Setzen der Zeile an einer bestimmten Position der Matrix
	 * @param line Daten der zu schreibenden Zeile
	 * @param i Index der zu schreibenden Zeile	 
	 */	 
    public abstract void setRow(double[] line, int i);

	/**
	 * Setzen der Spalte an einer bestimmten Position der Matrix
	 * @param line Daten der zu schreibenden Spalte
	 * @param i Index der zu schreibenden Spalte	 
	 */
    public abstract void setCol (double[] line, int i);

	/**
	 * Auslesen der Spalte an einer bestimmten Position der Matrix
	 * @param i Index der auszulesenden Spalte
	 * @return Daten der Spalte als Array of double
	 */
    public abstract double[] getCol(int i);

	/**
	 * Auslesen der Zeile an einer bestimmten Position der Matrix
	 * @param i Index der auszulesenden Zeile
	 * @return Daten der Zeiler als Array of double
	 */
    public abstract double[] getRow(int i);

	/**
	 * Ausgeben der Matrix-Daten als Single-Array
	 * @return Matrix-Daten
	 */
    public abstract double[] getPixelAsSingleArray();

	/**
	 * Verdoppeln einer Matrix
	 * @return Duplikat der Matrix
	 */
    public abstract Matrix cloneMatrix();

}
