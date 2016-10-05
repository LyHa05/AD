package aufgabe02;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import aufgabe02_lydia.PufferLinkedListImpl;

/**
 * @author Lydia Pflug, Lucas Anders
 * @date 26.09.2016
 *
 */

public class JUnitPufferLinkedList {

	private PufferAbstractImplLinkedList puffer;
	
	@Before
	public void setUp() throws Exception {
		puffer = new PufferAbstractImplLinkedList(5);
	}
	
	/**
	 * Methode testet inhalt() auf Grenzwerte
	 * (keine Elemente enthalten, hinzufuegen und
	 * entfernen von Elementen)
	 */
	@Test
	public void testInhalt() {
		assertSame(0,puffer.inhalt());
		puffer.add(1);
		puffer.add(2);
		assertSame(2,puffer.inhalt());
		puffer.remove(1);
		assertSame(1,puffer.inhalt());
	}
	
	/**
	 * Methode testet empty() auf Grenzwerte
	 * (keine Elemente enthalten, hinzufuegen und
	 * entfernen von Elementen)
	 */
	@Test
	public void testEmpty() {
		assertSame(puffer.inhalt() == 0, puffer.empty());
		puffer.add(3);
		puffer.add(4);
		assertSame(puffer.inhalt() != 0,!(puffer.empty()));
		puffer.remove(3);
		puffer.remove(4);
		assertSame(puffer.inhalt() == 0, puffer.empty());
	}
	
	/**
	 * Methode testet add() auf Grenzwerte
	 * (hinzufuegen von Elementen, auch oberhalb der moeglichen
	 * Kapazitaet)
	 */
	@Test(expected = AssertionError.class)
	public void testAdd() {
		assertTrue(puffer.inhalt() == 0);
		puffer.add(1);
		assertTrue(puffer.inhalt() == 1);
		// null in Liste speichern
		puffer.add(null);
		assertTrue(puffer.inhalt() == 1);
		puffer.add(2);
		puffer.add(3);
		puffer.add(4);
		puffer.add(5);
		assertTrue(puffer.inhalt() == 5);
		// mehr Elemente als Kapazitaet speichern
		puffer.add(6);
		assertTrue(puffer.inhalt() == 5);
	}
		
	/**
	 * Methode testet remove() auf Grenzwerte
	 * (entfernen von Elementen, auch
	 * ohne das Element enthalten ist)
	 */
	@Test(expected = AssertionError.class)
	public void testRemove() {
		puffer.add(1);
		assertTrue(puffer.inhalt() == 1);
		puffer.remove(1);
		assertTrue(puffer.inhalt() == 0);
		puffer.add(2);
		//Element 3 ist nicht enthalten
		puffer.remove(3);
		assertTrue(puffer.inhalt() == 1);
		puffer.remove(2);
		assertTrue(puffer.inhalt() == 0);
	}

}
