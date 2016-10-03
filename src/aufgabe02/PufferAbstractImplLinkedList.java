package aufgabe02;

import java.util.LinkedList;

public class PufferAbstractImplLinkedList extends PufferAbstract {
	
	private LinkedList<Object> puffer;
	
	public PufferAbstractImplLinkedList(int kapazitaet) {
		this.puffer = new LinkedList<Object>();
		this.kapazitaet = kapazitaet;
	}

	@Override
	public Object get(int index) {
		return puffer.get(index);
	}

	@Override
	protected int inhaltImpl() {
		return puffer.size();
	}

	@Override
	protected boolean emptyImpl() {
		return puffer.isEmpty();
	}

	@Override
	protected void addImpl(Object data) {
		puffer.add(data);
		
	}

	@Override
	protected void removeImpl(Object data) {
		puffer.remove(data);
	}

}
