package aufgabe02_lydia;

/**
 * @author Lydia Pflug, Lucas Anders
 * @date 26.09.2016
 *
 */

abstract class PufferArray {
	
	Object[] puffer;
	int kapazitaet;
	int oberstesElement;
	int letztesElement;
		
	public PufferArray(int kapazitaet) {
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
		} else if ((letztesElement == oberstesElement) && get(oberstesElement) == null){
			ergebnis = 0;
		} else if ((letztesElement == oberstesElement) && get(oberstesElement) != null){
			ergebnis = 1;
		}

		return ergebnis;
	}
	
	
	/**
	 * @param index
	 * @return
	 */
	abstract Object get(int index);

	/**
	 * Gibt die Anzahl der enthaltenen Elemente zurueck.
	 * 
	 * @return ergebnis
	 */
	abstract int inhaltImpl();
	
	/**
	 * Gibt true zurueck, wenn der Puffer leer ist, ansonsten false.
	 * Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @return ergebnis
	 */
	public boolean empty() {
		assert(puffer != null);
		boolean ergebnis = emptyImpl();
		assert((!isEmpty() || inhalt() == 0) &&
				(isEmpty() || inhalt() != 0));
		return ergebnis;
	}
	
	abstract boolean isEmpty();
	
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
		assert(puffer != null && data != null && kapazitaet != inhalt());
		int enthalteneElementeVorher = inhalt();
		addImpl(data);
		assert((enthalteneElementeVorher + 1 == inhalt()) && !isEmpty());
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
				(indexLetzesElementeVorher + 1 == letztesElement ||
				indexLetzesElementeVorher - 1 == letztesElement));
	}
	
	/**
	 * Entfernt uebergebenes Element aus Puffer.
	 * 
	 * @param data
	 */
	abstract void removeImpl(Object data);
	

}