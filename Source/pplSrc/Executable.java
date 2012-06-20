/* $Id: Executable.java,v 1.30 2003/01/10 08:58:07 ii3839 Exp $ */

package ppl;

import ppl.Opcodes;
import ppl.machine.MachineState;
import ppl.mv.MachineValue;
import ppl.mv.*;
import ppl.op.*;
import ppl.instr.*;
import ppl.syscalls.*;

/**
 * Diese Klasse ist der Kern der Virtuellen Maschine. Hier wird der Zustand der
 * Maschine verwaltet. Das Programm wird geladen und ausgefuehrt.
 *
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */
public
    class Executable implements Opcodes {
    
    /**
     * Zustand der Virtuellen Maschine */
    private
    static
    MachineState ms = MachineState.MakeMS();

	/**
	 * Speicher fuer das Programm
	 */
	public final
	    Instr [] code;

	/**
	 * Konstruktor fuer das Erzeugen eines Objektes dieser Klasse. Dabei wird
	 * der Programm-Code geladen, der globale Speicher reserviert und der
	 * PC auf den Anfang des Codes gesetzt.
	 * @param code Array fuer die Instruktionen des PPL-Programms
	 * @param dataSegmentLen Groesse des Speichers fuer globale Variablen.
	 */
	public		
	Executable(Instr [] code, int dataSegmentLen) 
	{			    
		this.code = code;
		/* Erzeugen eines Speichers fuer globale Variablen */
		ms.newGlobalMem(dataSegmentLen);
		/* Erzeugen des PCs der VM */
		ms.newPC(code.length);			    
	}
	
	/**
	 * Diese Methode ist fuer die Ausfuehrung des PPL-Programms verantwortlich.
	 * Der Befehl an der aktuellen PC-Adresse wird ausgefuehrt und anschliessend
	 * wird der PC inkrementiert. Um Fehler zu vermeiden, wird hier der Status
	 * der VM abgefragt.
	 */
	public
	void run()
	{		
		do
		{				
			code[ms.getPCAddress()].exec();
			ms.incPC();
		}
		while ((ms.getPCAddress()<code.length) && ms.statusOK());
		System.out.println(ms.getStatusMessage());
	}
	
	/**
	 * Methode zum Anfuegen von Parametern an das PPL-Programm.
	 * @param Arg Anzufuegender Parameter
	 */
	public
	void appendArg(String Arg)
	{
		ms.appendArg(Arg);
	}

	/**
	 * Erzeugen eines Objektes zum Laden eines Integer-Wertes auf den 
	 * Evaluation-Stack.
	 * @param value zu ladender Wert
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr loadi(int value)
	{
		return InstrPushMV.makeOne(ms, new MVInt(value));
	}

	/**
	 * Erzeugen eines Objektes zum Laden eines Float-Wertes auf den 
	 * Evaluation-Stack.
	 * @param value zu ladender Wert
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr loadf(float value)
	{
		return InstrPushMV.makeOne(ms, new MVFloat(value));
	}

	/**
	 * Erzeugen eines Objektes zum Laden eines String-Wertes auf den 
	 * Evaluation-Stack.
	 * @param value zu ladender Wert
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr loads(String value)
	{	    
		return InstrPushMV.makeOne(ms, new MVString(value));
	}

	/**
	 * Erzeugen eines Objektes zum Laden eines Undef-Wertes auf den 
	 * Evaluation-Stack.
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr undef() 
	{	    
		return InstrPushMV.makeOne(ms, new MVUndef());	    
	}

	/**
	 * Erzeugen eines Objektes zum Laden einer leeren Liste auf den 
	 * Evaluation-Stack.	 
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr emptyl()
	{
		return InstrPushMV.makeOne(ms, MVList.makeEmpty());	    
	}

	/**
	 * Erzeugen eines Objektes zum Laden einer Variable auf den Evaluation-Stack.
	 * @param addrType Art der Variable (lokal/global)
	 * @param offset Adresse der Variable im Speicherbereich
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr load(int addrType, int offset)
	{	    
		return InstrLoad.makeOne(ms, addrType, offset);
	}

	/**
	 * Erzeugen eines Objektes zum Verdoppeln des obersten Elementes vom
	 * Evaluation-Stacks.
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr dup()
	{	    
		return InstrDupMV.makeOne(ms);
	}

	/**
	 * Erzeugen eines Objektes zum Speichern eines Wertes vom Evaluation-Stack
	 * in einer Variable.
	 * @param addrType Art der Variable (lokal/global)
	 * @param offset Adresse der Variable im Speicherbereich
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr store(int addrType, int offset)
	{	    
		return InstrStore.makeOne(ms, addrType, offset);
	}

	/**
	 * Erzeugen eines Objektes fuer einen Sprung zu einem Unterprogramm.
	 * @param displ Displacement fuer den relativen Sprung
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr pushj(int displ)
	{	    
		return InstrPushJ.makeOne(ms, displ);
	}

	/**
	 * Erzeugen eines Objektes zum Entfernen des obersten Evaluation-Stack-Elements.
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr pop()
	{	    
		return InstrPopMV.makeOne(ms);
	}

	/**
	 * Erzeugen eines Objektes fuer einen Ruecksprung aus einem Unterprogramm.
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr popj()
	{	    
		return InstrPopJ.makeOne(ms);
	}

	/**
	 * Speicher fuer Referenzen auf OP-Code-Objekte. Somit wird von jedem
	 * OP-Code nur maximal einer erzeugt.
	 */
	private
	static Instr [] references = new Instr [Opcodes.ENDE];

	/**
	 * Erzeugen von Objekten fuer die einzelnen OP-Codes. Dabei wird maximal
	 * eine Instanz von einem OP-Code gebildet.
	 * @param opcode Bezeichner fuer das zu erzeugende OP-Code-Objekt
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr compute(int opcode) 
	{
		/* Zwischenspeicher fuer das erzeugte OP-Code-Objekt */
		Instr temp;
		
		if (references[opcode] == null)
		{
			switch (opcode)
			{
				/* OP-Codes auf Integer-Zahlen */
				case Opcodes.addi:		temp = InstrCompute.makeOne(ms, new OPaddi(), 2); break;
				case Opcodes.subi:		temp = InstrCompute.makeOne(ms, new OPsubi(), 2); break;
				case Opcodes.muli:		temp = InstrCompute.makeOne(ms, new OPmuli(), 2); break;
				case Opcodes.divi:		temp = InstrCompute.makeOne(ms, new OPdivi(), 2); break;
				case Opcodes.modi:		temp = InstrCompute.makeOne(ms, new OPmodi(), 2); break;
				case Opcodes.maxi:		temp = InstrCompute.makeOne(ms, new OPmaxi(), 2); break;
				case Opcodes.mini:		temp = InstrCompute.makeOne(ms, new OPmini(), 2); break;
				case Opcodes.eqi:		temp = InstrCompute.makeOne(ms, new OPeqi(), 2); break;
				case Opcodes.gei:		temp = InstrCompute.makeOne(ms, new OPgei(), 2); break;
				case Opcodes.gti:		temp = InstrCompute.makeOne(ms, new OPgti(), 2); break;
				
				case Opcodes.incri:		temp = InstrCompute.makeOne(ms, new OPincri(), 1); break;
				case Opcodes.decri:		temp = InstrCompute.makeOne(ms, new OPdecri(), 1); break;
				
				/* OP-Codes auf Float-Zahlen */
				case Opcodes.addf:		temp = InstrCompute.makeOne(ms, new OPaddf(), 2); break;
				case Opcodes.subf:		temp = InstrCompute.makeOne(ms, new OPsubf(), 2); break;
				case Opcodes.mulf:		temp = InstrCompute.makeOne(ms, new OPmulf(), 2); break;
				case Opcodes.divf:		temp = InstrCompute.makeOne(ms, new OPdivf(), 2); break;
				case Opcodes.maxf:		temp = InstrCompute.makeOne(ms, new OPmaxf(), 2); break;
				case Opcodes.minf:		temp = InstrCompute.makeOne(ms, new OPminf(), 2); break;
				case Opcodes.eqf:		temp = InstrCompute.makeOne(ms, new OPeqf(), 2); break;
				case Opcodes.gef:		temp = InstrCompute.makeOne(ms, new OPgef(), 2); break;
				case Opcodes.gtf:		temp = InstrCompute.makeOne(ms, new OPgtf(), 2); break;
				
				/* OP-Codes zum Konvertieren */
				case Opcodes.i2s:		temp = InstrCompute.makeOne(ms, new OPi2s(), 1); break;
				case Opcodes.f2s:		temp = InstrCompute.makeOne(ms, new OPf2s(), 1); break;
				case Opcodes.i2f:		temp = InstrCompute.makeOne(ms, new OPi2f(), 1); break;
				case Opcodes.trunc:		temp = InstrCompute.makeOne(ms, new OPtrunc(), 1); break;
				case Opcodes.round:		temp = InstrCompute.makeOne(ms, new OPround(), 1); break;
				
				/* Op-Codes auf Strings */
				case Opcodes.concs:		temp = InstrCompute.makeOne(ms, new OPconcs(), 2); break;
				
				/* OP-Codes auf Listen */
				case Opcodes.isemptyl:	temp = InstrCompute.makeOne(ms, new OPisemptyl(), 1); break;
				case Opcodes.lengthl:	temp = InstrCompute.makeOne(ms, new OPlengthl(), 1); break;
				case Opcodes.taill:		temp = InstrCompute.makeOne(ms, new OPtaill(), 1); break;
				case Opcodes.concl:		temp = InstrCompute.makeOne(ms, new OPconcl(), 2); break;
				case Opcodes.prependl:	temp = InstrCompute.makeOne(ms, new OPprependl(), 2); break;
				case Opcodes.appendl:	temp = InstrCompute.makeOne(ms, new OPappendl(), 2); break;
				case Opcodes.indexl:	temp = InstrCompute.makeOne(ms, new OPindexl(), 2); break;

				/* OP-Codes auf Bilder */
				case Opcodes.width:		temp = InstrCompute.makeOne(ms, new OPwidth(), 1); break;
				case Opcodes.height:	temp = InstrCompute.makeOne(ms, new OPheight(), 1); break;
				case Opcodes.black:		temp = InstrCompute.makeOne(ms, new OPblack(), 2); break;    
				case Opcodes.white:		temp = InstrCompute.makeOne(ms, new OPwhite(), 2); break;    
				case Opcodes.grey:		temp = InstrCompute.makeOne(ms, new OPgrey(), 3); break;    

				case Opcodes.gamma:				temp = InstrCompute.makeOne(ms, new OPgamma(), 2); break;
				case Opcodes.invert:			temp = InstrCompute.makeOne(ms, new OPinvert(), 1); break;
				case Opcodes.bitmap:			temp = InstrCompute.makeOne(ms, new OPbitmap(), 1); break;
				case Opcodes.blackAndWhite:		temp = InstrCompute.makeOne(ms, new OPbw(), 1); break;
				case Opcodes.reduceColor:		temp = InstrCompute.makeOne(ms, new OPreduceColor(), 2); break;
				case Opcodes.flipHorizontal:	temp = InstrCompute.makeOne(ms, new OPflipH(), 1); break;
				case Opcodes.flipVertical:		temp = InstrCompute.makeOne(ms, new OPflipV(), 1); break;
				case Opcodes.flipDiagonal:		temp = InstrCompute.makeOne(ms, new OPflipD(), 1); break;
				case Opcodes.rotate:			temp = InstrCompute.makeOne(ms, new OProtate(), 1); break;
				case Opcodes.shift:				temp = InstrCompute.makeOne(ms, new OPshift(), 3); break;
				case Opcodes.cut:				temp = InstrCompute.makeOne(ms, new OPcut(), 5); break;
				case Opcodes.paste:				temp = InstrCompute.makeOne(ms, new OPpaste(), 4); break;
				case Opcodes.scale:				temp = InstrCompute.makeOne(ms, new OPscale(), 3); break;
				case Opcodes.replicate:			temp = InstrCompute.makeOne(ms, new OPreplicate(), 3); break;
				case Opcodes.resize:			temp = InstrCompute.makeOne(ms, new OPresize(), 3); break;
				case Opcodes.sideBySide:		temp = InstrCompute.makeOne(ms, new OPsideBySide(), 2); break;
				case Opcodes.above:				temp = InstrCompute.makeOne(ms, new OPabove(), 2); break;    

				/* OP-Codes zur Bildzerlegung */
				case Opcodes.partitionHorizontal:   temp = InstrCompute.makeOne(ms, new OPpartH(), 2); break;
				case Opcodes.partitionVertical:     temp = InstrCompute.makeOne(ms, new OPpartV(), 2); break;
				case Opcodes.splitHorizontal:       temp = InstrCompute.makeOne(ms, new OPsplitH(), 2); break;
 				case Opcodes.splitVertical:         temp = InstrCompute.makeOne(ms, new OPsplitV(), 2); break;
				case Opcodes.mergeHorizontal:       temp = InstrCompute.makeOne(ms, new OPmergeH(), 1); break;
 				case Opcodes.mergeVertical:         temp = InstrCompute.makeOne(ms, new OPmergeV(), 1); break;
				case Opcodes.concatHorizontal:      temp = InstrCompute.makeOne(ms, new OPconcatH(), 1); break;
 				case Opcodes.concatVertical:        temp = InstrCompute.makeOne(ms, new OPconcatV(), 1); break; 				

    
				case Opcodes.mean:			temp = InstrCompute.makeOne(ms, new OPmean(), 2); break;				    				
				case Opcodes.diff:			temp = InstrCompute.makeOne(ms, new OPdiff(), 2); break;				    
				case Opcodes.inverseMean:	temp = InstrCompute.makeOne(ms, new OPinverseMean(), 2); break;
				case Opcodes.inverseDiff:	temp = InstrCompute.makeOne(ms, new OPinverseDiff(), 2); break;

				case Opcodes.mulp:			temp = InstrCompute.makeOne(ms, new OPmulp(), 2); break;
				case Opcodes.maxp:			temp = InstrCompute.makeOne(ms, new OPmaxp(), 2); break;
				case Opcodes.minp:			temp = InstrCompute.makeOne(ms, new OPminp(), 2); break;

				/* OP-Codes zur Ablaufsteuerung */
				case Opcodes.terminate:		temp = InstrCompute.makeOne(ms, new OPterminate(), 0);break;
				case Opcodes.abort:			temp = InstrCompute.makeOne(ms, new OPabort(), 1);break;
				
				/* Wenn ein OP-Code nicht implementiert ist */
				default:	throw new RuntimeException("Ungueliger Opcode!");
			}
			/* Speichern der Objekt-Referenz */
			references[opcode] = temp;
		}
		/* Rueckgabe der Objekt-Referenz */
		return references[opcode];
	}

	/**
	 * Speicher fuer Referenzen auf SYS-Code-Objekte. Somit wird von jedem
	 * SYS-Code nur maximal einer erzeugt.
	 */
	private
	static Instr [] SYSreferences = new Instr [Opcodes.SYSEND];

	/**
	 * Erzeugen von Objekten fuer die einzelnen SYS-Codes. Dabei wird maximal
	 * eine Instanz von einem SYS-Code gebildet.
	 * @param subroutine Bezeichner fuer das zu erzeugende SYS-Code-Objekt
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr svc(int subroutine)
	{
		/* Zwischenspeicher fuer das erzeugte SYS-Code-Objekt */
		Instr temp;
		
		if (SYSreferences[subroutine] == null)
		{
			switch (subroutine)
			{
				/* SYS-Codes zum Laden von Bildern */
				case Opcodes.store:			temp = InstrSyscall.makeOne(ms, new SYSstore(), 2); break;
				case Opcodes.load:			temp = InstrSyscall.makeOne(ms, new SYSload(), 1); break;
				
				/* SYS-Codes zur String-Ausgabe */
				case Opcodes.write:			temp = InstrSyscall.makeOne(ms, new SYSwrite(), 1); break;
				case Opcodes.writeln:		temp = InstrSyscall.makeOne(ms, new SYSwriteln(), 1); break;
				
				/* SYS-Codes zur Parameterverwaltung */
				case Opcodes.getArgs:		temp = InstrSyscall.makeOne(ms, new SYSgetArgs(), 0); break;
				
				/* SYS-Codes zur Ablaufsteuerung */
				case Opcodes.abort:			temp = InstrSyscall.makeOne(ms, new SYSabort(), 0); break;
				case Opcodes.exit:			temp = InstrSyscall.makeOne(ms, new SYSexit(), 0); break;
				
				/* Wenn ein SYS-Code nicht implementiert ist */
				default:			throw new RuntimeException("Ungueliger System-Call!");
			}
			/* Speichern der Objekt-Referenz */
			SYSreferences[subroutine] = temp;
		}
		/* Rueckgabe der Objekt-Referenz */	    
	    return SYSreferences[subroutine];
	}

	/**
	 * Erzeugen eines Objektes zum Reservieren von Speicher fuer lokale Variablen.
	 * @param len Groesse des zu reservierenden Speicherbereiches
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr entry(int len)
	{	    
		return InstrEntry.makeOne(ms, len);
	}

	/**
	 * Erzeugen eines Objektes zum Freigeben von Speicher fuer lokale Variablen.
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr exit()
	{
		return InstrExit.makeOne(ms);
	}

	/**
	 * Erzeugen eines Objektes zum Ausfuehren von bedingten relativen Spruengen.
	 * @param cond Bedingung fuer den relativen Sprung
	 * @param disp Displacement fuer den relativen Sprung
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr branch(boolean cond, int disp) 
	{
		return InstrBranch.makeOne(ms, cond, disp);
	}

	/**
	 * Erzeugen eines Objektes zum Reservieren von Speicher fuer lokale
	 * Variablen.
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr jump(int displ)
	{	    
		return InstrJump.makeOne(ms, displ);
	}

	/**
	 * Erzeugen eines Objektes fuer eine illegale Instruktion
	 * @return Referenz auf die Instruktion
	 */
	public static
	Instr illegalInstr(String error)
	{	    
		return InstrIllegal.makeOne(ms, error);
	}
}
