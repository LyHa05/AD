package aufgabe02;

public class PufferArrayImpl implements Puffer {

	private Object[] puffer;
	private int kapazitaet;
	private int indexErstes;
	private int indexLetztes;

	public PufferArrayImpl(int kapazitaet) {
		this.kapazitaet = kapazitaet;
		this.puffer = new Object[kapazitaet];
		this.indexErstes = 0;
		this.indexLetztes = 0;
	}

	@Override
	public int inhalt() {
		// TODO Auto-generated method stub
		return 0;
		
//		assert((!empty() || ergebnis == 0) &&
//				// (empty() || ergebnis == inhaltBerechnet()));
//				// return ergebnis;
	}

	@Override
	public Object get(int index) {
		return puffer[index];
	}

	@Override
	public boolean empty() {
		return((indexErstes == indexLetztes) && puffer[indexErstes] == null);
	}

	@Override
	public void add(Object data) {
		this.indexLetztes++;
		//out of index abfangen
		puffer[indexLetztes] = data;

	}

	@Override
	public void remove(Object data) {
		// TODO Auto-generated method stub

	}

}
