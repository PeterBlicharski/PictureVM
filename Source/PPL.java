/* $Id: PPL.java,v 1.13 2003/01/10 07:47:31 ii3839 Exp $ */

import ppl.Executable;

/**
 * Die Klasse PPL ist fuer das Laden und ausfuehren eines PPL-Programms
 * zustaendig. Dazu wird zunaechst eine Instanz der auszufuehrenden Klasse
 * gebildet. Nach einem Cast zu Executable kann die Instanz ausgefuehrt werden.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharsik (ii3839)
 * @version 1.0
 */
public
class PPL {
	
    /**
     * Hauptprogramm
     * @param args Argumente des Programms
     */
    public static void main(String args[]) {
	    System.out.println("Starting PPLVM...\n");		
	    try
	    {
		  System.out.println("Loading "+args[0]+"...");
		  Class programClass = Class.forName("ppl."+args[0]);
		  System.out.println("Running "+args[0]+"...\n");
		  /* Instanz erzeugen */
		  Executable program = (Executable)programClass.newInstance();
		  /* Parameter kopieren */
		  for(int i=1;i<args.length;++i)
		  {
		  	program.appendArg(args[i]);		  			  	
			}
		  /* Programm ausfuehren */
		  program.run();		  
		  System.out.println("Program "+args[0]+" finished.\n");
	    }
	    catch (Exception e)
	    {
		  System.out.println("Fehler bei der Programmausfuehrung..."+e.getMessage());
	    }
	    
      }
}
