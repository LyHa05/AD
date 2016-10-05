package aufgabe02_lydia;

public class LaufzeitTest {

	public static void main(String[] args) {
		PufferLinkedList pufferLinkedList = new PufferLinkedListImpl(5);
		pufferLinkedList.add(1);
		System.out.println(pufferLinkedList);
		pufferLinkedList.add(2);
		System.out.println(pufferLinkedList);
		pufferLinkedList.remove(1);
		System.out.println(pufferLinkedList);
		pufferLinkedList.add(3);
		pufferLinkedList.add(4);
		pufferLinkedList.add(5);
		System.out.println(pufferLinkedList);
		pufferLinkedList.add(6);
		System.out.println(pufferLinkedList);
		System.out.println(pufferLinkedList.kapazitaet);
		System.out.println(pufferLinkedList.inhalt());
//		pufferLinkedList.add(7);
//		System.out.println(pufferLinkedList);
//		System.out.println(pufferLinkedList.kapazitaet);
//		System.out.println(pufferLinkedList.inhalt());
	}
	
}
