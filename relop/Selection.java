package relop;

/**
 * The selection operator specifies which tuples to retain under a condition; in
 * Minibase, this condition is simply a set of independent predicates logically
 * connected by OR operators.
 */
public class Selection extends Iterator {

    private Iterator iterator;
    private Predicate[] predicates;

    private Tuple nextTuple = null;

    //Used for debugging:
    private boolean debug = false;

    /**
     * Constructs a selection, given the underlying iterator and predicates.
     */
    public Selection(Iterator iter, Predicate... preds) {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'Selection()'");
        }

        //Our Iterator to filter on using the predicates.
        this.iterator = iter;
        //The SELECT statements.
        this.predicates = preds.clone();

        //Schema must be set in all subclass constructors:
        this.schema = iter.schema;
    }

    /**
     * Gives a one-line explanation of the iterator, repeats the call on any
     * child iterators, and increases the indent depth along the way.
     *
     * Note: What this do is simply to print out the statements, nothing else.
     * Think of typing EXPLAIN in your query is postgres.
     */
    public void explain(int depth) {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'explain()'");
        }

        System.out.print("\n SELECT * WHERE (");
        if (predicates.length > 0) {
            for (int i = 0; i < predicates.length - 1; i++) {
                System.out.print(predicates[i].toString() + " OR ");
            }
            System.out.print(predicates[predicates.length - 1] + ")");
        }
        iterator.explain(depth + 1);
    }

    /**
     * Restarts the iterator, i.e. as if it were just constructed.
     */
    public void restart() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'restart()'");
        }
        iterator.restart(); //Why does this work?
    }

    /**
     * Returns true if the iterator is open; false otherwise.
     */
    public boolean isOpen() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'isOpen()'");
        }
        return iterator.isOpen(); //Why does this work?
    }

    /**
     * Closes the iterator, releasing any resources (i.e. pinned pages).
     */
    public void close() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'close()'");
        }
        nextTuple = null;
        iterator.close();
    }

    /**
     * Returns true if there are more tuples, false otherwise.
     */
    public boolean hasNext() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'hasNext()'");
        }
        while (iterator.hasNext()) {

            // try to pass the next tuple
            nextTuple = iterator.getNext();
            if (predicates.length == 0) { // Can we delete this?
                return true;
            }
            for (Predicate predicate : predicates) {
                // if it passes, return found
                if (predicate.evaluate(nextTuple)) {
                    return true;
                }
            }
        }
        return false;
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
        // validate the next tuple
        if (nextTuple == null) {
            throw new IllegalStateException("no more tuples");
        }

        // return (and forget) the tuple
        Tuple tuple = nextTuple;
        nextTuple = null;
        return tuple;
    }

} // public class Selection extends Iterator
