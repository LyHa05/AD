package aufgabe02_lydia;

import java.lang.reflect.Method;

/**
 * @author Lucas Anders, Lydia Pflug
 * @date 06.10.2016
 * Die Klasse beinhaltet Wrappermethoden, die die eigentliche Methode aufrufen und deren Laufzeit zurückgibt.
 *
 */
public class LaufzeiterfassungArray {

	PufferArray pufferArray;

	public LaufzeiterfassungArray(PufferArray pufferArray) {
		this.pufferArray = pufferArray;
	}

	public long pufferArrayRuntime(int kapazitaet) {
		long before = System.nanoTime();
		new PufferArrayImpl(kapazitaet);
//		System.out.println("Konstruktor: " + (System.nanoTime() - before) + " ms");
		return System.nanoTime() - before;
	}

	/**
	 * Gibt die Anzahl der enthaltenen Elemente zurueck. Methode mit Pruefung
	 * der Vor- und Nachbedingungen.
	 * 
	 * @return ergebnis
	 */
	public long inhaltRuntime() {
		long before = System.nanoTime();
		pufferArray.inhalt();
//		System.out.println("Inhalt: " + (System.nanoTime() - before) + " ms");
		return System.nanoTime() - before;
	}

	/**
	 * @param index
	 * @return
	 */
	public long getRuntime(int index) {
		long before = System.nanoTime();
		pufferArray.get(index);
//		System.out.println("get: " + (System.nanoTime() - before) + " ms");
		return System.nanoTime() - before;

	}

	/**
	 * Gibt true zurueck, wenn der Puffer leer ist, ansonsten false. Methode mit
	 * Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @return ergebnis
	 */
	public long emptyRuntime() {
		long before = System.nanoTime();
		pufferArray.empty();
//		System.out.println("Empty: " + (System.nanoTime() - before) + " ms");
		return System.nanoTime() - before;
	}

	/**
	 * Fuegt Element in naechsten freien Position ein, wenn Puffer noch nicht
	 * voll ist. Methode mit Pruefung der Vor- und Nachbedingungen.
	 * 
	 * @param data
	 */
	public long addRuntime(Object data) {
		long before = System.nanoTime();
		pufferArray.add(data);
//		System.out.println("Add: " + (System.nanoTime() - before) + " ms");
		return System.nanoTime() - before;
	}

	/**
	 * Entfernt uebergebenes Element aus Puffer. Methode mit Pruefung der Vor-
	 * und Nachbedingungen.
	 * 
	 * @param data
	 */
	public long removeRuntime(Object data) {
		long before = System.nanoTime();
		pufferArray.remove(data);
//		System.out.println("Remove: " + (System.nanoTime() - before) + " ms");
		return System.nanoTime() - before;
	}

}
