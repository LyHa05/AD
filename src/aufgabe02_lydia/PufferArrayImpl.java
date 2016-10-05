package aufgabe02_lydia;

public class PufferArrayImpl extends PufferArray {
	
	public PufferArrayImpl(int kapazitaet) {
		super(kapazitaet);
		this.puffer = new Object[kapazitaet];
	}

	@Override
	Object get(int index) {
		return puffer[index];
	}

	@Override
	int inhaltImpl() {
		int anzahl = 0;
		
		for (Object element : puffer) {
			if (element != null) {
				++anzahl;
			}
		}
		
		return anzahl;
	}

	@Override
	boolean emptyImpl() {
		System.out.println("oberstesElement: " + oberstesElement);
		if (puffer[oberstesElement] == null) {
			return true;
		}
		return false;
	}

	@Override
	void addImpl(Object data) {
		// erstes Element
		if (empty()) {
			puffer[letztesElement] = data;
		// weitere Elemente
		} else {
			if(letztesElement == puffer.length-1){
	        	letztesElement = 0;
	        } else {
	        	++letztesElement;
	        }
			puffer[letztesElement] = data;
		}       
	}

	@Override
	void removeImpl(Object data) {
		
		int index = 0;
		
		for (Object element : puffer) {
			if (data.equals(element)) {
				// erstes Element entfernt
				if (index == oberstesElement) {
					puffer[index] = null;
					// Pufferueberschlag
			        if(oberstesElement == puffer.length-1) {
			        	oberstesElement = 0;
			        // kein Pufferueberschlag
			        } else {
			            ++oberstesElement;
			        }
				// letztes Element oder aus Mitte entfernt
				} else {
					puffer[index] = null;
					// Pufferueberschlag
			        if(letztesElement == puffer.length-1) {
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
