/* $Id: MachineState.java,v 1.12 2003/01/10 07:47:31 ii3839 Exp $ */ 

package ppl.machine;

import ppl.mv.*;

/**
 * Die Klasse MaschineState beinhaltet alle Funktionen und Daten fuer die
 * Ablaufsteuerung der Virtuellen Maschine. Es kann maximal eine Instanz dieser
 * Klasse erzeugt werden (als Singelton implementiert).
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
class MachineState
{
	/**
	 * Stack der Virtuellen Maschine
	 */
	private     
    TypedStack stack = new TypedStack();
    
    /**
     * Program-Counter der Virtuellen Maschine
     */
    private    
    PC pc;
    
    /**
     * globaler Speicher der Virtuellen Maschine
     */
    private
    Mem mem;
    
    /**
     * Frames fuer die Verwaltung von lokalem Speicher
     */
    private
    Frames frames = new Frames();
    
    /**
     * Status der Virtuellen Maschine
     */    
    private
    Status status = Status.makeStatus();
    
    /**
     * Argumente des PPL-Programms
     */
    private
    MVList Args = MVList.makeEmpty();
    
    /**
     * geschuetzter Default-Konstruktor
     */
    private
	MachineState()
	{
	}
	
	/**
	 * Referenz auf dieses Objekt. Wird fuer die Implementierung als Singelton
	 * benoetigt.
	 */
	private
	static
	MachineState ref;
	
	/**
	 * Erzeugen einer neuen Ablaufsteuerung.
	 * @return Neues Objekt zur Verwaltung des System-Zustandes
	 */ 	
	public
	static
	MachineState MakeMS()
	{
		if (ref == null)
			ref = new MachineState();
		return ref;
	}


/*** Methoden zur Verwaltung des System-Status ********************************/

	/**
	 * Ueberpruefen, ob kein Fehler aufgetreten ist
	 * @return true=kein Fehler ist aufgetreten
	 */
    public
    boolean statusOK()
    {    	
    	return status.isOK();
    }
    
    /**
	 * Methode zum Setzen eines System-Fehlers. Das Programm wird danach beendet.
	 * @param error Auszugebende Fehlermeldung
	 */
    public 
    void setStatusError(String error)
    {    	
    	status.setError(error);
    }
    
    /**
	 * Methode zum Beenden des Programms.
	 */
    public
    void setStatusTerminate()
    {
    	status.setTerminate();
    }
    
    /**
	 * Methode zum Abbrechen eines Programms mit einer auszugebenden Meldung.
	 * @param message Nachricht, die beim Programmabbruch ausgegeben wird
	 */
    public
    void setStausAbort(String message)
    {
    	status.setAbort(message);
    }
    
    /**
	 * Ausgeben der Statusmeldung
	 * @return Statusmeldung
	 */
    public
    String getStatusMessage()
    {
    	return status.toString();
    }


/*** Methoden zur Verwaltung des globalen Speichers ***************************/

	/**
	 * Erzeugt einen neuen Speicherbereich, in dem globale Variablen abgelegt
	 * werden koennen.
	 * @param size Groesse des zu reservierenden Speichers
	 */
    public 
    void newGlobalMem(int size)
    {
    	mem = new Mem(size);
    }

	/**
	 * Liest den Inhalt einer globalen Variable aus und liefert eine Kopie
	 * derselben zurueck.
	 * @param index Index der zu lesenden globalen Variable
	 * @return Wert der globalen Variable
	 */
    public
    MachineValue getGlobalVar(int index)
    {
    	return mem.getValue(index);
    }
    
    /**
	 * Schreibt den angegebenen Wert in die indizierte globale Variable.
	 * @param index Index der zu schreibenden globalen Variable
	 * @param value neuer Wert der globalen Variable
	 */
    public
    void setGlobalVar(int index, MachineValue value)
    {
    	mem.setValue(index, value);
    }
    

/*** Methoden zur Verwaltung des lokalen Speichers ****************************/

	/**
	 * Erzeugt einen neuen Speicherbereich, in dem lokale Variablen abgelegt
	 * werden koennen.
	 * @param size Groesse des zu reservierenden Speichers
	 */
    public
    void newLocalMem(int size)
    {
    	frames.newFrame(size);
    }
    
    /**
	 * Loescht den zuletzt erzeugten Speicherbereich fuer lokale Variablen.
	 */
    public
    void removeLocalMem()
    {
    	frames.removeFrame();
    }
    
    /**
	 * Liest den Inhalt einer lokalen Variable aus und liefert eine Kopie
	 * derselben zurueck.
	 * @param index Index der zu lesenden globalen Variable
	 * @return Wert der lokalen Variable
	 */
    public
    MachineValue getLocalVar(int index)
    {
    	return frames.getFrame().getValue(index);
    }
    
    /**
	 * Schreibt den angegebenen Wert in die indizierte lokale Variable.
	 * @param index Index der zu schreibenden lokalen Variable
	 * @param value neuer Wert der lokalen Variable
	 */
    public
    void setLocalVar(int index, MachineValue value)
    {
    	frames.getFrame().setValue(index, value);
    }


/*** Methoden zur Verwaltung des Auswertungs-Stacks ***************************/
    
    /**
     * Dupliziert das oberste Element auf dem Stack. Dazu wird eine Kopie
     * vom obersten Element auf den Stack geschrieben.
     */
    public
    void dupStackTop()
    {
    	stack.pushMV(stack.peekMV().copy());
    }
    
    /**
     * Liefert das oberste Stackelement zurueck.
     * @return oberstes Element auf dem Stack
     */
    public
    MachineValue popStack()
    {
    	return stack.popMV();	
    }
	
	/**
     * Legt den angegebenen Wert auf dem Stack ab.
     * @param value auf dem Stack abzulegender Wert
     */
	public
	void pushStack(MachineValue value)
	{
		stack.pushMV(value);
	}
    

/*** Methoden zur Verwaltung des Program-Counters *****************************/

	/**
	 * Erzeugt einen neuen Program-Counter mit dem angegebenen Code-Bereich.
	 * @param codeSize Adresse des letzten Befehls im Code-Bereich
	 */
    public
    void newPC(int codeSize)
    {
    	pc = PC.makePC(codeSize);
    }
    
	/**
	 * Erhoeht den Program-Counter um 1.
	 * @return Status der Operation
	 */
	public 
	boolean incPC()
	{		
		return pc.addPC(1);		
	}
    
    /**
     * Ausfuehren eines relativen Sprunges.
     * @param disp Displacement fuer den relativen Sprung
     */
	public
    void jumpPCRelative(int disp)
    {    	    	
    	pc.addPC(disp-1);
    }
    
    /**
     * Ausfuehren eines absoluten Sprunges.
     * @param addr Adresse fuer den absoluten Sprung
     */
    public
    void jumpPCAbsolute(int addr)
    {
    	pc.setAddress(addr);
    }
    
    /**
     * Auslesen der momentanen Adresse des Program-Counters
     * @return aktuelle Adresse des Program-Counters
     */
    public
    int getPCAddress()
    {
    	return pc.getAddress();
    }

  
/*** Methoden zur Verwaltung der Programmparameter ****************************/

	/**
     * Hinzufuegen eines neuen Parameters fuer das PPL-Programm.
     * @param arg Hinzuzufuegendes Argument
     */
	public
	void appendArg(String arg)
	{		
		Args = Args.appendMV(new MVString(arg));		
	}
	
	/**
	 * Diese Funktion speicher eine Kopie der Argumentliste auf dem Stack
	 */
	public
	void pushArgs()
	{
		stack.pushMV(Args.copy());
	}
	
	/**
	 * Ermitteln der Referenz auf die Parameterliste
	 */
	public
	MachineValue getArgs()
	{
		return Args.copy();
	}
}
