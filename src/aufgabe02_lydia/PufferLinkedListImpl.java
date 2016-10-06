package aufgabe02_lydia;

import java.util.Iterator;
import java.util.LinkedList;

public class PufferLinkedListImpl extends PufferLinkedList {

	public PufferLinkedListImpl(int kapazitaet) {
		super(kapazitaet);
		puffer = new LinkedList<>();
	}

	@Override
	Object get(int index) {
		Iterator<Object> puffIter = puffer.iterator();
		int zaehler = 0;
		Object element = null;
		
		while (puffIter.hasNext()) {
			
			if (zaehler == index) {
				element = puffIter.next();
			}
			
			++zaehler;
		}

		return element;
	}

	@Override
	int inhaltImpl() {
		return puffer.size();
	}

	@Override

	boolean emptyImpl() {
		System.out.println("oberstesElement: " + oberstesElement);
		return puffer.isEmpty();
	}

	@Override
	void addImpl(Object data) {
		// erstes Element
		if(empty()) {
			//letztesElement wird nicht verändert
			puffer.add(data);
		// weitere Elemente: mit Ueberschlag
		} else {
			if(letztesElement == kapazitaet-1) {
				letztesElement = 0;
				puffer.add(data);
			// weitere Elemente: ohne Ueberschlag
			} else {
				++letztesElement;
				puffer.add(data);
			}
		}
//		puffer.add(data);
	}

	@Override
	void removeImpl(Object data) {
		
//		int index = 0;
		for (Object element : puffer) {
			if (data.equals(element)) {
				// erstes Element entfernt
				
				if (puffer.getFirst() == data) {
					if(oberstesElement == kapazitaet-1) {
			        	oberstesElement = 0;
			        // kein Pufferueberschlag
			        } else {
			            ++oberstesElement;
			        }
				// letztes Element oder aus Mitte entfernt
				} else {
					// Pufferueberschlag
			        if(letztesElement == 0) {
			        	System.out.println("alter Wert letztes: " + letztesElement);
			            letztesElement = kapazitaet-1;
			            System.out.println("neuer Wert letztes: " + letztesElement);
			        // kein Pufferueberschlag
			        } else {
			            --letztesElement;
			        }
				}
			}
//			++index;
		}        
		puffer.remove(data);
	}

}
