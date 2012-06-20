/* $Id: testPic.java,v 1.1 2002/12/02 23:22:55 ii3839 Exp $ */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.*;

class testPic {

//     private static BufferedReader io;
    
    public static BufferedInputStream io = null;
    
    public static PnmPicture header;

    public static void main(String args[]) {

	
// 	byte[] buf = new byte[1256]; 
// 	String line = new String();

    	/*DEBUG 0*/System.out.println("Starte Picture Loader ...");

	try {
	    /*DEBUG 1*/System.out.println("\t÷ffne Bild");
	    io = new BufferedInputStream(new FileInputStream("../lena.pgm"));
	} catch (FileNotFoundException e) {
	    System.out.println("Picture not found!");
	}
	/*DEBUG 1*/System.out.println("\tBild offen");
	/*DEBUG 1*/System.out.println("\tStarte parsen des Headers ...");
	System.out.println("Objekt: "+io);
	header = new PnmPicture(new BufferedInputStream(io));
	io = header.parse();
// Bild offen
	System.out.println("Objekt: "+io);
	try {
	    io.close();
	} catch (IOException e) {
	    System.out.println("Could not close Picture");
	}
	
   }
}
