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
		if (puffer.size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	void addImpl(Object data) {
		puffer.add(data);
        if(oberstesElement == puffer.size()-1){
        	oberstesElement = 0;
        } else {
        	++oberstesElement;
        }
	}

	@Override
	void removeImpl(Object data) {
		puffer.remove(data);
        if(letztesElement == puffer.size()-1){
            letztesElement = 0;
        } else {
            ++letztesElement;
        }
	}

	@Override
	boolean isEmpty() {
		return puffer.isEmpty();
	}

}
