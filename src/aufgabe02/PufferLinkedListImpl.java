package aufgabe02;

import java.util.LinkedList;

public class PufferLinkedListImpl implements Puffer {

	private LinkedList<Object> puffer;
	
	@Override
	public int inhalt() {
		return puffer.size();
	}

	@Override
	public Object get(int index) {
		return puffer.get(index);
	}

	@Override
	public boolean empty() {
		return puffer.isEmpty();
	}

	@Override
	public void add(Object data) {
		puffer.add(data);
		
	}

	@Override
	public void remove(Object data) {
		puffer.remove(data);
	}

}
