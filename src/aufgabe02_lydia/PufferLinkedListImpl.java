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
		return puffer.isEmpty();
	}

	@Override
	void addImpl(Object data) {
		puffer.add(data);
		if(letztesElement == puffer.size()-1){
			letztesElement = 0;
		} else {
			++letztesElement;
		}
	}

	@Override
	void removeImpl(Object data) {
		
		int index = 0;
		
		for (Object element : puffer) {
			if (data.equals(element)) {
				// erstes Element entfernt
				if (index == oberstesElement) {
					puffer.remove(data);
			        if(oberstesElement == puffer.size()-1) {
			        	oberstesElement = 0;
			        // kein Pufferueberschlag
			        } else {
			            --oberstesElement;
			        }
				// letztes Element oder aus Mitte entfernt
				} else {
					puffer.remove(data);
					// Pufferueberschlag
			        if(letztesElement == puffer.size()-1) {
			            letztesElement = 0;
			        // kein Pufferueberschlag
			        } else {
			            --letztesElement;
			        }
				}
			}
			++index;
		}        
	}

}
