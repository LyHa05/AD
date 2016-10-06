package aufgabe02;

/**
 * @author Lucas Anders, Lydia Pflug
 * @date 06.10.2016
 * Das Skript ruft alle Methoden mehrfach auf, da dies aussagekraeftiger ist als ein einziger Aufruf
 */
public class RuntimeScript {

	public static void main(String[] args) {

		PufferArray puffer = new PufferArrayImpl(1000);
		PufferLinkedList pufferLinkedList = new PufferLinkedListImpl(1000);

		LaufzeiterfassungArray runtime = new LaufzeiterfassungArray(puffer);
		
		LaufzeiterfassungLinkedList runtime2 = new LaufzeiterfassungLinkedList(pufferLinkedList);

		
		System.out.println("Array:");
		long sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime.addRuntime(1);
		}
		System.out.println("Add bei 1000 Aufrufen: " + sum + " ms");

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime.removeRuntime(1);
		}
		System.out.println("Remove bei 1000 Aufrufen: " + sum + " ms");

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime.emptyRuntime();
		}
		System.out.println("Empty bei 1000 Aufrufen und leerem Puffer: " + sum + " ms");

		// 500 Elemente einfuegen
		for (int i = 0; i < 500; i++) {
			runtime.addRuntime(1);
		}

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime.emptyRuntime();
		}
		System.out.println("Empty bei 1000 Aufrufen und 500 Elementen: " + sum + " ms");

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime.getRuntime(284);
		}
		System.out.println("Get bei 1000 Aufrufen und 500 Elementen: " + sum + " ms");

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime.inhaltRuntime();
		}
		System.out.println("Inhalt bei 1000 Aufrufen und 500 Elementen: " + sum + " ms");
		
		
		

		System.out.println("\n\nLinkedList:");



		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime2.addRuntime(1);
		}
		System.out.println("Add bei 1000 Aufrufen: " + sum + " ms");

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime2.removeRuntime(1);
		}
		System.out.println("Remove bei 1000 Aufrufen: " + sum + " ms");

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime2.emptyRuntime();
		}
		System.out.println("Empty bei 1000 Aufrufen und leerem Puffer: " + sum + " ms");

		// 500 Elemente einfuegen
		for (int i = 0; i < 500; i++) {
			runtime2.addRuntime(1);
		}

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime2.emptyRuntime();
		}
		System.out.println("Empty bei 1000 Aufrufen und 500 Elementen: " + sum + " ms");

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime2.getRuntime(284);
		}
		System.out.println("Get bei 1000 Aufrufen und 500 Elementen: " + sum + " ms");

		sum = 0;
		for (int i = 0; i < 1000; i++) {
			sum = sum + runtime2.inhaltRuntime();
		}
		System.out.println("Inhalt bei 1000 Aufrufen und 500 Elementen: " + sum + " ms");

	}

}
