package aufgabe01;

import java.util.ArrayList;

/**
 * @author Lydia Pflug, Lucas Anders
 * @date 26.09.2016
 *
 */

class Puffer {
	
	ArrayList<Object> puffer;
	int kapazitaet;
	int oberstesElement;
	int letztesElement;
		
	public Puffer(int kapazitaet) {
		puffer = new ArrayList<Object>();
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
				(empty() || ergebnis == inhaltBerechnet()));
		return ergebnis;
	}
	
	
	/**
	 * Berechnet die Anzahl der enthaltenen Elemente.
	 * 
	 * @return ergebnis
	 */
	private int inhaltBerechnet() {
		
		int ergebnis = 0;
		
		if (letztesElement > oberstesElement) {
			ergebnis = Math.abs(letztesElement - oberstesElement) + 1;
		} else if (letztesElement < oberstesElement) {
			ergebnis = letztesElement - oberstesElement;
		} else if ((letztesElement == oberstesElement) && puffer.get(oberstesElement) == null){
			ergebnis = 0;
		} else if ((letztesElement == oberstesElement) && puffer.get(oberstesElement) != null){
			ergebnis = 1;
		}

		return ergebnis;
	}

	/**
	 * Gibt die Anzahl der enthaltenen Elemente zurueck.
	 * 
	 * @return ergebnis
	 */
	private int inhaltImpl() {
		return 0;
	}
	
	/**
	 * Gibt true zurueck, wenn der Puffer leer ist, ansonsten false.
	 * Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @return ergebnis
	 */
	public boolean empty() {
		assert(puffer != null);
		boolean ergebnis = emptyImpl();
		assert((!puffer.isEmpty() || inhalt() == 0) &&
				(puffer.isEmpty() || inhalt() != 0));
		return ergebnis;
	}
	
	/**
	 * Gibt true zurueck, wenn der Puffer leer ist, ansonsten false.
	 * 
	 * @return ergebnis
	 */
	private boolean emptyImpl() {
		return false;
	}
	
	/**
	 * Fuegt Element in naechsten freien Position ein, wenn Puffer noch nicht voll ist.
	 * Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @param data
	 */
	public void add(Object data) {
		assert(puffer != null && data != null && kapazitaet != inhalt());
		int enthalteneElementeVorher = inhalt();
		addImpl(data);
		assert((enthalteneElementeVorher + 1 == inhalt()) && !puffer.isEmpty());
	}
	
	/**
	 * Fuegt Element in naechsten freien Position ein, wenn Puffer noch nicht voll ist.
	 * 
	 * @param data
	 */
	private void addImpl(Object data) {
	}
	
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
				(indexLetzesElementeVorher + 1 == letztesElement ||
				indexLetzesElementeVorher - 1 == letztesElement));
	}
	
	/**
	 * Entfernt uebergebenes Element aus Puffer.
	 * 
	 * @param data
	 */
	private void removeImpl(Object data) {
		
	}
	

}
