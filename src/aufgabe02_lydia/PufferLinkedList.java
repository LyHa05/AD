package aufgabe02_lydia;

import java.util.LinkedList;

/**
 * @author Lydia Pflug, Lucas Anders
 * @date 26.09.2016
 *
 */

abstract class PufferLinkedList {
	
	LinkedList<Object> puffer;
	int kapazitaet;
	int oberstesElement;
	int letztesElement;
		
	public PufferLinkedList(int kapazitaet) {
		this.kapazitaet = kapazitaet;
		oberstesElement = 0;
		letztesElement = 0;
	}
	
	/**
	 * Gibt die Anzahl der enthaltenen Elemente zurueck.
	 * Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @return ergebnis
	 */
	public int inhalt() {
		assert(puffer != null);
		int ergebnis = inhaltImpl();
		assert((!empty() || ergebnis == 0) &&
				(empty() || ergebnis == puffer.size()));
		return ergebnis;
	}
	
	/**
	 * Gibt die Anzahl der enthaltenen Elemente zurueck.
	 * 
	 * @return ergebnis
	 */
	abstract int inhaltImpl();

	/**
	 * @param index
	 * @return
	 */
	abstract Object get(int index);

	/**
	 * Gibt true zurueck, wenn der Puffer leer ist, ansonsten false.
	 * Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @return ergebnis
	 */
	public boolean empty() {
		assert(puffer != null);
		boolean ergebnisEmpty = emptyImpl();
		assert(!ergebnisEmpty || puffer.size() == 0);
		return ergebnisEmpty;
	}
	
	/**
	 * Gibt true zurueck, wenn der Puffer leer ist, ansonsten false.
	 * 
	 * @return ergebnis
	 */
	abstract boolean emptyImpl();
	
	/**
	 * Fuegt Element in naechsten freien Position ein, wenn Puffer noch nicht voll ist.
	 * Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @param data
	 */
	public void add(Object data) {
		assert(puffer != null && data != null && kapazitaet > inhalt());
		int enthalteneElementeVorher = inhalt();
		addImpl(data);
		assert((enthalteneElementeVorher + 1 == inhalt()) && !empty());
	}
	
	/**
	 * Fuegt Element in naechsten freien Position ein, wenn Puffer noch nicht voll ist.
	 * 
	 * @param data
	 */
	abstract void addImpl(Object data);
	
	/**
	 * Entfernt uebergebenes Element aus Puffer.
	 * Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @param data
	 */
	public void remove(Object data) {
		assert(puffer != null && data != null && !empty());
		int enthalteneElementeVorher = inhalt();
		int indexLetzesElementeVorher = letztesElement;
		removeImpl(data);
		assert((enthalteneElementeVorher - 1 == inhalt()) && 
				(indexLetzesElementeVorher - 1 == letztesElement || 
				indexLetzesElementeVorher == letztesElement ||
				letztesElement == kapazitaet-1));
	}
	
	/**
	 * Entfernt uebergebenes Element aus Puffer.
	 * 
	 * @param data
	 */
	abstract void removeImpl(Object data);

	/**
	 * Methode gibt String mit enthaltenen Elementen im Puffer zurueck.
	 * 
	 * @return Elemente im Puffer als String
	 */
	@Override
	public String toString() {
		String ausgabe = "";
		for(Object element : puffer) {
			ausgabe = ausgabe + element.toString();
		}
		return ausgabe;
		
	}
		
}