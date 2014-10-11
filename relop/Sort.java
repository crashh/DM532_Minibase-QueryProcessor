package relop;

import global.*;

public class Sort extends Iterator implements GlobalConst {

    private boolean debug = true;
			
  /**
   * Constructs a sort operator. 
   * @param sortMemSize the size the memory used for internal sorting. For simplicity, you can assume it is in the unit of tuples.
   * @param bufSize the total buffer size for the merging phase in the unit of page.   
   */
	public Sort(Iterator iter, int sortfield, int sortMemSize, int bufSize) {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'Sort()'");
        }
	    throw new UnsupportedOperationException("Not implemented");
	}
	

	@Override
	public void explain(int depth) {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'explain()'");
        }
	    throw new UnsupportedOperationException("Not implemented");
		
	}

	@Override
	public void restart() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'restart()'");
        }
	    throw new UnsupportedOperationException("Not implemented");
		
	}

	@Override
	public boolean isOpen() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'isOpen()'");
        }
	    throw new UnsupportedOperationException("Not implemented");

	}

	@Override
	public void close() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'close()'");
        }
	    throw new UnsupportedOperationException("Not implemented");
		
	}

	@Override
	public boolean hasNext() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'hasNext()'");
        }
	    throw new UnsupportedOperationException("Not implemented");

	}

	@Override
	public Tuple getNext() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'getNext()'");
        }
	    throw new UnsupportedOperationException("Not implemented");

	}

}
