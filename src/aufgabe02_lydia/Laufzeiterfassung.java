package aufgabe02_lydia;

import java.lang.reflect.Method;

public class Laufzeiterfassung {

	PufferArray pufferArray;

	public Laufzeiterfassung(PufferArray pufferArray) {
		this.pufferArray = pufferArray;
	}

	public PufferArray pufferArrayRuntime(int kapazitaet) {
		long before = System.nanoTime();
		PufferArray toReturn = new PufferArrayImpl(kapazitaet);
		System.out.println(System.nanoTime() - before);
		return toReturn;
	}

	/**
	 * Gibt die Anzahl der enthaltenen Elemente zurueck. Methode mit Pruefung
	 * der Vor- und Nachbedingungen.
	 * 
	 * @return ergebnis
	 */
	public int inhaltRuntime() {
		long before = System.nanoTime();
		int toReturn = pufferArray.inhalt();
		System.out.println(System.nanoTime() - before);
		return toReturn;
	}

	/**
	 * Berechnet die Anzahl der enthaltenen Elemente.
	 * 
	 * @return ergebnis
	 */
	public int sizeRuntime() {
		long before = System.nanoTime();
		int toReturn = pufferArray.size();
		System.out.println(System.nanoTime() - before);
		return toReturn;
	}

	/**
	 * @param index
	 * @return
	 */
	public Object getRuntime(int index) {
		long before = System.nanoTime();
		Object toReturn = pufferArray.get(index);
		System.out.println(System.nanoTime() - before);
		return toReturn;

	}

	/**
	 * Gibt true zurueck, wenn der Puffer leer ist, ansonsten false. Methode mit
	 * Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @return ergebnis
	 */
	public boolean emptyRuntime() {
		long before = System.nanoTime();
		boolean toReturn = pufferArray.empty();
		System.out.println(System.nanoTime() - before);
		return toReturn;
	}

	/**
	 * Fuegt Element in naechsten freien Position ein, wenn Puffer noch nicht
	 * voll ist. Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @param data
	 */
	public void addRuntime(Object data) {
		long before = System.nanoTime();
		pufferArray.add(data);
		System.out.println(System.nanoTime() - before);
	}

	/**
	 * Entfernt uebergebenes Element aus Puffer. Methode mit Pruefung der Vor-
	 * und Nachbedingungen.
	 * 
	 * @param data
	 */
	public void removeRuntime(Object data) {
		long before = System.nanoTime();
		pufferArray.remove(data);
		System.out.println(System.nanoTime() - before);
	}

}
