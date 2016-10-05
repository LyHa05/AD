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
		return size();
	}

	@Override
	boolean emptyImpl() {
		if (puffer[oberstesElement] == null) {
			return true;
		}
		return false;
	}

	@Override
	void addImpl(Object data) {
		puffer[(letztesElement + 1)] = data;
        if(letztesElement == puffer.length-1){
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
					puffer[index] = null;
					// Pufferueberschlag
			        if(oberstesElement == size()-1) {
			        	oberstesElement = 0;
			        // kein Pufferueberschlag
			        } else {
			            --oberstesElement;
			        }
				// letztes Element oder aus Mitte entfernt
				} else {
					puffer[index] = null;
					// Pufferueberschlag
			        if(letztesElement == size()-1) {
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
