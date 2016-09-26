package aufgabe01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Lydia Pflug, Lucas Anders
 * @date 26.09.2016
 *
 */

public class JUnitPuffer {

	@Before
	public void setUp() throws Exception {
//		Puffer puffer = new Puffer(5);
	}

	
	
	/**
	 * Methode testet inhalt() auf Grenzwerte
	 * (keine Elemente enthalten, hinzufuegen und
	 * entfernen von Elementen)
	 */
	@Test
	public void testInhalt() {
		assertSame(puffer.size(),puffer.inhalt());
		puffer.add(1);
		puffer.add(2);
		assertSame(puffer.size(),puffer.inhalt());
		puffer.remove(1);
		assertSame(puffer.size(),puffer.inhalt());
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
	@Test
	public void testAdd() {
		assertTrue(puffer.inhalt() == 0);
		puffer.add(1);
		assertTrue(puffer.inhalt() == 1);
		puffer.add(2);
		puffer.add(3);
		puffer.add(4);
		puffer.add(5);
		assertTrue(puffer.inhalt() == 5);
		puffer.add(6);
		assertTrue(puffer.inhalt() == 5);
	}
	
	/**
	 * Methode testet remove() auf Grenzwerte
	 * (entfernen von Elementen, auch
	 * ohne das Element enthalten ist)
	 */
	@Test
	public void testRemove() {
		puffer.add(1);
		assertTrue(puffer.inhalt() == 1);
		puffer.remove(1);
		assertTrue(puffer.inhalt() == 0);
		puffer.add(2);
		puffer.remove(3);
		assertTrue(puffer.inhalt() == 1);
		puffer.remove(2);
	}

}
