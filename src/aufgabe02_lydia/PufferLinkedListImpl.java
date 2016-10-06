package aufgabe02_lydia;

/**
 * @author Lydia Pflug, Lucas Anders
 * @date 06.10.2016
 *
 */

import java.util.LinkedList;

public class PufferLinkedListImpl extends PufferLinkedList {

	public PufferLinkedListImpl(int kapazitaet) {
		super(kapazitaet);
		puffer = new LinkedList<>();
	}

	@Override
	Object get(int index) {
		return puffer.get(index);
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
		// erstes Element
		if(empty()) {
			//letztesElement wird nicht verändert
		// weitere Elemente: mit Ueberschlag
		} else {
			if(letztesElement == kapazitaet-1) {
				letztesElement = 0;
			// weitere Elemente: ohne Ueberschlag
			} else {
				++letztesElement;
			}
		}
		puffer.add(data);
	}

	@Override
	void removeImpl(Object data) {
		
		for (Object element : puffer) {
			if (data.equals(element)) {
				// erstes Element entfernt
				if (puffer.getFirst().equals(data)) {
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
			        	letztesElement = kapazitaet-1;
			            // kein Pufferueberschlag
			        } else {
			            --letztesElement;
			        }
				}
				break;
			}
		}        
		puffer.remove(data);
	}

}
