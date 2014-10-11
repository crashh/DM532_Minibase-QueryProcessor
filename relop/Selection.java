package relop;

/**
 * The selection operator specifies which tuples to retain under a condition; in
 * Minibase, this condition is simply a set of independent predicates logically
 * connected by OR operators.
 */
public class Selection extends Iterator {

    private boolean debug = true;

  /**
   * Constructs a selection, given the underlying iterator and predicates.
   */
  public Selection(Iterator iter, Predicate... preds) {
    if (debug){
        System.out.println("DEBUG: Called " + this.toString() + " method 'Selection()'");
    }
    throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Gives a one-line explaination of the iterator, repeats the call on any
   * child iterators, and increases the indent depth along the way.
   */
  public void explain(int depth) {
      if (debug){
          System.out.println("DEBUG: Called " + this.toString() + " method 'explain()'");
      }
      throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Restarts the iterator, i.e. as if it were just constructed.
   */
  public void restart() {
      if (debug){
          System.out.println("DEBUG: Called " + this.toString() + " method 'restart()'");
      }
      throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns true if the iterator is open; false otherwise.
   */
  public boolean isOpen() {
      if (debug){
          System.out.println("DEBUG: Called " + this.toString() + " method 'isOpen()'");
      }
      throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Closes the iterator, releasing any resources (i.e. pinned pages).
   */
  public void close() {
      if (debug){
          System.out.println("DEBUG: Called " + this.toString() + " method 'close()'");
      }
      throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Returns true if there are more tuples, false otherwise.
   */
  public boolean hasNext() {
      if (debug){
          System.out.println("DEBUG: Called " + this.toString() + " method 'hasNext()'");
      }
      throw new UnsupportedOperationException("Not implemented");
  }

  /**
   * Gets the next tuple in the iteration.
   * 
   * @throws IllegalStateException if no more tuples
   */
  public Tuple getNext() {
      if (debug){
          System.out.println("DEBUG: Called " + this.toString() + " method 'getNext()'");
      }
      throw new UnsupportedOperationException("Not implemented");
  }

} // public class Selection extends Iterator
