package aufgabe02;

import java.util.Collection;

/**
 * @author Lydia Pflug, Lucas Anders
 * @date 26.09.2016
 *
 */

public interface Puffer {

	int kapazitaet();

	int oberstesElement();

	int letztesElement();

	/**
	 * Gibt die Anzahl der enthaltenen Elemente zurueck.
	 * 
	 * @return ergebnis
	 */
	public int inhalt();
	// assert(puffer != null);
	// int ergebnis = inhaltImpl();
	// assert((!empty() || ergebnis == 0) &&
	// (empty() || ergebnis == inhaltBerechnet()));
	// return ergebnis;

	/**
	 * @param Index
	 * @return
	 */
	public Object get(int Index);

	/**
	 * Gibt true zurueck, wenn der Puffer leer ist, ansonsten false.
	 * 
	 * @return ergebnis
	 */
	public boolean empty();
	// assert(puffer != null);
	// boolean ergebnis = emptyImpl();
	// assert((!puffer.isEmpty() || inhalt() == 0) &&
	// (puffer.isEmpty() || inhalt() != 0));
	// return ergebnis;

	/**
	 * Fuegt Element in naechsten freien Position ein, wenn Puffer noch nicht
	 * voll ist.
	 * 
	 * @param data
	 */
	public void add(Object data);
	// assert(puffer != null && data != null && kapazitaet != inhalt());
	// int enthalteneElementeVorher = inhalt();
	// addImpl(data);
	// assert((enthalteneElementeVorher + 1 == inhalt()) && !puffer.isEmpty());

	/**
	 * Entfernt uebergebenes Element aus Puffer.
	 * 
	 * @param data
	 */
	public void remove(Object data);
	// assert(puffer != null && data != null && !empty());
	// int enthalteneElementeVorher = inhalt();
	// int indexLetzesElementeVorher = letztesElement;
	// removeImpl(data);
	// assert((enthalteneElementeVorher - 1 == inhalt()) &&
	// (indexLetzesElementeVorher + 1 == letztesElement ||
	// indexLetzesElementeVorher - 1 == letztesElement));

}
