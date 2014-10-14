package relop;

/**
 * The projection operator extracts columns from a relation; unlike in
 * relational algebra, this operator does NOT eliminate duplicate tuples.
 */
public class Projection extends Iterator {

    private Iterator iterator;
    private Integer[] fields;

    private Tuple nextTuple = null;

    //Used for debugging:
    private boolean debug = true;


    /**
     * Constructs a projection, given the underlying iterator and field numbers.
     */
    public Projection(Iterator iter, Integer... fields) {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'Projection()'");
        }

        //Our iterator to remove columns from.
        this.iterator = iter;
        //I assume this array of Integers, refers to the schema and the tuples locations therein?
        this.fields = fields.clone();
        //Schema must be set in all subclass constructors:
        this.schema = iter.schema;
    }

    /**
     * Gives a one-line explanation of the iterator, repeats the call on any
     * child iterators, and increases the indent depth along the way.
     *
     * Note: What this do it simply to print out the statements, nothing else.
     */
    public void explain(int depth) {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'explain()'");
        }

        System.out.print("\n PROJECT * WHERE (");
        if (fields.length > 0) {
            for (int i = 0; i < fields.length - 1; i++) {
                System.out.print(fields[i].toString() + " AND ");
            }
            System.out.print(fields[fields.length - 1] + ")");
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
        if (iterator.hasNext()){
            return true;
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

} // public class Projection extends Iterator
