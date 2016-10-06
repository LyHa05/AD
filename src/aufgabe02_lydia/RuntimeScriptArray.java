package aufgabe02_lydia;

public class RuntimeScriptArray {

	public static void main(String[] args) {

		PufferArray puffer = new PufferArrayImpl(1000);
		PufferLinkedList pufferLinkedList = new PufferLinkedListImpl(1000);

		LaufzeiterfassungArray runtime = new LaufzeiterfassungArray(puffer);

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

	}

}
