/* $Id: MVList.java,v 1.8 2003/01/10 07:47:31 ii3839 Exp $ */

package ppl.mv;

/**
 * Die Klasse MVList implementiert eine einfach verkettete Liste mit einem
 * @link MachineValue als Datenkomponente.
 * @author Malte Hopmann (ii4271)
 * @author Peter Blicharski (ii3839)
 * @version 1.0
 */

class Node extends MVList
{
	/**
	 * Infokomponente des Listen-Elements
	 */
	private
	MachineValue value;
	
	/**
	 * Referenz auf das naechste Element in der Liste
	 */
	private
	MVList next;
	
	/**
	 * Konstruktor fuer das Erzeugen eines Knotens.
	 * @param next Referenz auf das naechste Element in der Liste
	 * @param value Datenkomponente des Listen-Knotens	 
	 */
	Node(MVList next, MachineValue value)
	{
		this.next = next;
		this.value = value;
	}
	
	/**
	 * Test, ob die Liste leer ist. Da aber ein Knoten existiert, ist die Liste
	 * nicht leer.
	 * @return es existiert eine Liste
	 */
	public 	
	boolean isEmpty()
	{
		return false;
	}
	
	/**
	 * Liefert die Datenkomponente vom Kopf einer Liste zurueck.
	 * @return erstes Element in der Liste
	 */
	public	
	MachineValue getHead()
	{
		return value;
	}
	
	/**
	 * Liefert die Liste ohne das erste Element zurueck.
	 * @return Rest der Liste
	 */
	public	
	MVList getTail()
	{
		return next;
	}
	
	/**
	 * Liefert die Laenge einer Liste zurueck.
	 * @return Laenge der Liste
	 */
	public	
	int getLength()
	{
		return 1+getTail().getLength();
	}
	
	/**
	 * Liefert die Datenkomponente des indizierten Listen-Knotens zurueck.
	 * @param index Index des auszulesenden Knotens
	 * @return Datenkomponente an dem Index
	 */
	public	
	MachineValue getIndex(int index)
	{
		if (index==0)
			return value; //eventuell durch value.copy() ersetzen
		else
			return next.getIndex(index-1);		
	}
	
	/**
	 * Fuegt den angegebenen Wert an den Anfang der Liste ein.
	 * @param value einzufuegender Wert
	 * @return Liste mit dem hinzugefuegten Element
	 */
	public	
	MVList prependMV(MachineValue value)
	{
		return new Node(this, value);
	}
	
	/**
	 * Fuegt den angegebenen Wert an das Ende der Liste ein.
	 * @param value anzuhaengender Wert
	 * @return Liste mit dem hinzugefuegten Element
	 */
	public	
	MVList appendMV(MachineValue value)
	{
		next = next.appendMV(value);
		return this;
	}
	
	/**
	 * Haengte die angegebene Liste an das Ende dieser Liste an.
	 * @param list anzuhaengende Liste
	 * @return Liste mit der angehaengten Liste
	 */
	public	
	MVList appendList(MVList list)
	{
		next = next.appendList(list);
		return this;
	}
	
	/**
	 * Kopiert eine Liste vollstaendig.
	 * @return Kopie der Liste
	 */
	public	
	MachineValue copy()
	{
		return new Node((MVList)next.copy(), value.copy());
	}
	
	/**
	 * Konvertiert die Liste in einen String.
	 * @return Liste als String dargestellt
	 */
	public	
	String toString()
	{
		return value.toString()+"->"+next.toString();
	}
}

class EmptyNode extends MVList
{
	/**
	 * Test, ob die Liste leer ist. Da aber ein kein Knoten existiert, ist die 
	 * Liste leer.
	 * @return es existiert keine Liste
	 */
	public	
	boolean isEmpty()
	{
		return true;
	}
	
	/**
	 * Liefert die Laenge einer Liste zurueck. Da die Liste leer ist, ist die
	 * Laenge der Liste leer.
	 * @return Laenge der Liste
	 */
	public	
	int getLength()
	{
		return 0;
	}
	
	/**
	 * Fuegt den angegebenen Wert an den Anfang der Liste ein.
	 * @param value einzufuegender Wert
	 * @return Liste mit dem hinzugefuegten Element
	 */	 	
	public	
	MVList prependMV(MachineValue value)
	{
		return new Node(this, value);
	}
	
	/**
	 * Fuegt den angegebenen Wert an das Ende der Liste ein.
	 * @param value anzuhaengender Wert
	 * @return Liste mit dem hinzugefuegten Element
	 */	
	public	
	MVList appendMV(MachineValue value)
	{
		return new Node(this, value);
	}
	
	/**
	 * Haengte die angegebene Liste an das Ende dieser Liste an. Da diese Liste
	 * leer ist, wird die angegebene Liste zurueckgegeben.
	 * @param list anzuhaengende Liste
	 * @return Liste mit der angehaengten Liste
	 */
	public	
	MVList appendList(MVList list)
	{
		return list;
	}
	
	/**
	 * Kopiert das Ende einer Liste.
	 * @return Kopie des Listenendes
	 */
	public	
	MachineValue copy()
	{
		return this;
	}
	
	/**
	 * Konvertiert die Liste in einen String.
	 * @return Liste als String dargestellt
	 */
	public	
	String toString()
	{
		return "EndList";
	}
}

public
abstract
class MVList extends MachineValue
{
	/**
	 * Referenz auf eine leere Liste
	 */
	private
	final
	static
	MVList empty = new EmptyNode();
	
	/**
	 * Erzeugt eine leere Liste.
	 */
	public
	static
	MVList makeEmpty()
	{
		return empty;
	}	
	
	/**
	 * Test, ob die Liste leer ist.
	 * @return ist die Liste leer?
	 */
	public 
	abstract 
	boolean isEmpty();
	
	/**
	 * Liefert die Datenkomponente vom Kopf einer Liste zurueck.
	 * @return erstes Element in der Liste
	 * @throws RuntimeException die Liste ist leer
	 */
	public	
	MachineValue getHead()
	{
		throw new RuntimeException("getHead: auf leerer Liste nicht definiert");
	}
	
	/**
	 * Liefert die Liste ohne das erste Element zurueck.
	 * @return Rest der Liste
	 * @throws RuntimeException die Liste ist leer
	 */
	public	
	MVList getTail()
	{
		throw new RuntimeException("getTail: auf leerer Liste nicht definiert");
	}

	/**
	 * Liefert die Laenge einer Liste zurueck.
	 * @return Laenge der Liste
	 */	
	public
	abstract
	int getLength();
	
	/**
	 * Liefert die Datenkomponente des indizierten Listen-Knotens zurueck.
	 * @param index Index des auszulesenden Knotens
	 * @return Datenkomponente an dem Index
	 * @throws RuntimeException die Liste ist leer
	 */
	public	
	MachineValue getIndex(int index)
	{
		throw new RuntimeException("getIndex: Index ausserhalb der Listengrenzen");
	}
	
	/**
	 * Fuegt den angegebenen Wert an den Anfang der Liste ein.
	 * @param value einzufuegender Wert
	 * @return Liste mit dem hinzugefuegten Element
	 */
	public
	abstract
	MVList prependMV(MachineValue value);
	
	/**
	 * Fuegt den angegebenen Wert an das Ende der Liste ein.
	 * @param value anzuhaengender Wert
	 * @return Liste mit dem hinzugefuegten Element
	 */
	public
	abstract
	MVList appendMV(MachineValue value);
	
	/**
	 * Haengte die angegebene Liste an das Ende dieser Liste an.
	 * @param list anzuhaengende Liste
	 * @return Liste mit der angehaengten Liste
	 */
	public
	abstract
	MVList appendList(MVList list);
	
	/**
	 * Kopiert eine Liste vollstaendig.
	 * @return Kopie der Liste
	 */
	public
	abstract
	MachineValue copy();
	
	/**
	 * Konvertiert die Liste in einen String.
	 * @return Liste als String dargestellt
	 */
	public
	abstract
	String toString();
}
