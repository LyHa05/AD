package aufgabe02_lydia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import aufgabe02_lydia.PufferArrayImpl;

/**
 * @author Lydia Pflug, Lucas Anders
 * @date 26.09.2016
 *
 */

public class JUnitPufferArray {

	private PufferArray puffer;
	private PufferArray puffer2;
	
	@Before
	public void setUp() throws Exception {
		puffer = new PufferArrayImpl(5);
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
	 * Methode testet add() auf Hinzufuegen von Elementen.
	 */
	@Test
	public void testAdd1() {
		assertTrue(puffer.inhalt() == 0);
		puffer.add(1);
		assertTrue(puffer.inhalt() == 1);
	}
	
	/**
	 * Methode testet add() auf Hinzufuegen von Elementen,
	 * die null sind.
	 */
	@Test(expected = AssertionError.class)
	public void testAdd2() {
		puffer.add(1);
		puffer.add(null);
		assertTrue(puffer.inhalt() == 1);
	}
	
	/**
	 * Methode testet add() auf Hinzufuegen von
	 * mehr Elemente als moegliche Kapazitaet.
	 */
	@Test(expected = AssertionError.class)
	public void testAdd3() {
		puffer.add(1);
		puffer.add(2);
		puffer.add(3);
		puffer.add(4);
		puffer.add(5);
		assertTrue(puffer.inhalt() == 5);
		puffer.add(6);
		assertTrue(puffer.inhalt() == 5);
	}
	
	/**
	 * Methode testet remove() auf Entfernen
	 * von Elementen.
	 */
	@Test
	public void testRemove1() {
		puffer.add(1);
		assertTrue(puffer.inhalt() == 1);
		puffer.remove(1);
		assertTrue(puffer.inhalt() == 0);	
	}
	
	/**
	 * Methode testet remove() Entfernen
	 * von Elementen, die nicht enthalten sind.
	 */
	@Test(expected = AssertionError.class)
	public void testRemove2() {
		puffer.add(1);
		puffer.remove(3);
		assertTrue(puffer.inhalt() == 1);
		puffer.add(2);
		puffer.remove(2);
		assertTrue(puffer.inhalt() == 1);
	}
	
	/**
	 * Methode testet remove() auf Entfernen von Elementen,
	 * die null sind.
	 */
	@Test(expected = AssertionError.class)
	public void testRemove3() {
		puffer.add(1);
		puffer.remove(null);
		assertTrue(puffer.inhalt() == 1);
	}

	/**
	 * Methode testet add() und remove() mit Entfernen
	 * des ersten Elements und Hinzufuegen eines neuen.
	 * 
	 */
	@Test
	public void testAddRemove1() {
		puffer.add(0);
		puffer.add(1);
		puffer.add(2);
		puffer.add(3);
		puffer.add(4);
		assertSame(0,puffer.oberstesElement);
		assertSame(4,puffer.letztesElement);
		puffer.remove(0);
		assertSame(1,puffer.oberstesElement);
		assertSame(4,puffer.letztesElement);
		puffer.add(5);
		assertSame(1,puffer.oberstesElement);
		assertSame(0,puffer.letztesElement);	
	}

	/**
	 * Methode testet add() und remove() mit Entfernen
	 * eines mittleren Elements und Hinzufuegen eines neuen.
	 * 
	 */
	@Test
	public void testAddRemove2() {
		puffer.add(0);
		puffer.add(1);
		puffer.add(2);
		puffer.add(3);
		puffer.add(4);
		assertSame(0,puffer.oberstesElement);
		assertSame(4,puffer.letztesElement);
		puffer.remove(2);
		assertSame(0,puffer.oberstesElement);
		assertSame(3,puffer.letztesElement);
		System.out.println("__________");
		puffer.add(5);
		assertSame(0,puffer.oberstesElement);
		assertSame(4,puffer.letztesElement);
		System.out.println("__________");
	}
	
	/**
	 * Methode testet add() und remove() mit Entfernen
	 * eines mittleren Elements und Hinzufuegen eines neuen.
	 * 
	 */
	@Test
	public void testAddRemove3() {
		puffer.add(0);
		puffer.add(1);
		puffer.add(2);
		puffer.add(3);
		puffer.add(4);
		puffer.remove(0);
		puffer.add(5);
		assertSame(1,puffer.oberstesElement);
		assertSame(0,puffer.letztesElement);
		puffer.remove(3);
		assertSame(1,puffer.oberstesElement);
		assertSame(4,puffer.letztesElement);	
	}
}
