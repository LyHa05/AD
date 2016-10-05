package aufgabe02;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class PufferAbstractImplArray extends PufferAbstract {

	private Object[] puffer;

	public PufferAbstractImplArray(int kapazitaet) {
		
		this.puffer = new Object[kapazitaet];
		this.kapazitaet = kapazitaet;
		this.oberstesElement = 0;
		this.letztesElement = 0;
	}

	@Override
	protected int inhaltImpl() {
		int counter = 0;
		for(Object o : puffer){
			if(o != null){
				counter++;
			}
		}
		return counter;
	}

	@Override
	protected boolean emptyImpl() {
		for (Object o : puffer) {
			if (o != null) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected void addImpl(Object data) {
		letztesElement++;
		if (letztesElement > (kapazitaet - 1)) {
			letztesElement = letztesElement % kapazitaet;
		}
		puffer[letztesElement] = data;
	}

	@Override
	protected void removeImpl(Object data) {
		int i = 0;
		for (Object o : puffer) {
			if (o.equals(data)) {
				puffer[i] = null;
				oberstesElement--;
				if (oberstesElement < 0) {
					oberstesElement = kapazitaet - 1;
				}
				return;
			}
			i++;
		}
	}

	@Override
	public Object get(int index) {
		return puffer[index];
	}

}
