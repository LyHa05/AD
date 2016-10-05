package aufgabe02_lydia;

public class LaufzeitTest {

	public static void main(String[] args) {
		
//		LinkedList
		
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
		
		System.out.println("________________________");
		
//		Array
		
		PufferArray pufferArray = new PufferArrayImpl(5);
		pufferArray.add(1);
		System.out.println(pufferArray);
		pufferArray.add(2);
		System.out.println(pufferArray);
		pufferArray.remove(1);
		System.out.println(pufferArray);
		pufferArray.add(3);
		pufferArray.add(4);
		pufferArray.add(5);
		System.out.println(pufferArray);
		pufferArray.add(6);
		System.out.println(pufferArray);
		System.out.println(pufferArray.kapazitaet);
		System.out.println(pufferArray.inhalt());
		pufferArray.add(7);
		System.out.println(pufferArray);
		System.out.println(pufferArray.kapazitaet);
		System.out.println(pufferArray.inhalt());
		
	}
	
}
