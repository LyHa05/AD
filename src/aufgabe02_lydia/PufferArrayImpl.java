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
			        if(letztesElement == 0) {
			            letztesElement = puffer.length-1;
//			            // Nachruecken der Elemente vor Ueberschlag
//			            for (int i = index; i < puffer.length; i++) {
//							
//							puffer[i] = puffer[i+1];
//						}
//			            puffer[puffer.length-1] = null;
//			            // Nachruecken der Elemente beim Ueberschlag
//			            puffer[0] = puffer[puffer.length-1];
//			            // Nachruecker der Elemente nach Ueberschlag
////			            for (int i = 0; i < )
			            
			        // kein Pufferueberschlag
			        } else {
			            --letztesElement;
			            // Nachruecken der Elemente
//			            if(index != puffer.length-1) {
//							for (int i = index; i < puffer.length; i++) {
//								
//								puffer[i] = puffer[i+1];
//							}
//							puffer[puffer.length-1] = null;
//						}
			        }
			        
			    	// Nachruecken der Elemente ohne Ueberschlag
			        if (((letztesElement + 1) > oberstesElement) || (index > 0)) {
			        	for (int i = index; i < puffer.length; i++) {
							
							puffer[i] = puffer[i+1];
						}
						puffer[letztesElement + 1] = null;			        	
					// Nachruecken der Elemente mit Ueberschlag
			        } else {

						// Nachruecken der Elemente vor Ueberschlag
			        	if (index != puffer.length-1) {
			        		for (int i = index; i < puffer.length; i++) {
			        			puffer[i] = puffer[i+1];
			        		}
			        	}
			        	
			            puffer[puffer.length-1] = null;
			            
			            // Nachruecken der Elemente beim Ueberschlag
			            puffer[0] = puffer[puffer.length-1];
			            
			            // Nachruecker der Elemente nach Ueberschlag
			            for (int i = 0; i < (letztesElement + 1); i++) {
			            	puffer[i] = puffer[i+1];
			            }
			            
			            // letztes verrutschtes Element null setzten
			            puffer[letztesElement + 1] = null;
			            
			        }
				}
				
			}
			++index;
		} 
	}

}
