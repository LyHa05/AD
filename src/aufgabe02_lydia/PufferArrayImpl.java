package aufgabe02_lydia;

import java.lang.reflect.Array;

public class PufferArrayImpl extends PufferArray {
	
//	private Object[] puffer;

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
		return this.kapazitaet;
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
        if(oberstesElement == puffer.length-1){
        	oberstesElement = 0;
        } else {
        	++oberstesElement;
        }
	}

	@Override
	void removeImpl(Object data) {
		for (int i = 0; i < puffer.length; i++) {
			Object element = puffer[i];
			if (element.equals(data)) {
				puffer[i] = null;
				if (i != letztesElement) {
					//TODO Index verschieben
//					while
				}
			}
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean isEmpty() {
		if (puffer[oberstesElement] == null) {
			return true;
		}
		return false;
	}

}
