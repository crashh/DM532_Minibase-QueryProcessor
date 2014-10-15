package relop;

/**
 * The projection operator extracts columns from a relation; unlike in
 * relational algebra, this operator does NOT eliminate duplicate tuples.
 */
public class Projection extends Iterator {

    private Iterator iterator;
    private Integer[] fields;

    //Used for debugging:
    private boolean debug = false;


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
        this.schema = new Schema(fields.length);
        /*for (Integer n : fields) {
            //Sets a field from another schema.
            this.schema.initField(n, iterator.schema, n);
        }*/

        for (int i = 0; i < fields.length; i++) {
            this.schema.initField(i, iterator.schema, fields[i].intValue());
        }
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
        iterator.close();
    }

    /**
     * Returns true if there are more tuples, false otherwise.
     */
    public boolean hasNext() {
        if (debug){
            System.out.println("DEBUG: Called " + this.toString() + " method 'hasNext()'");
        }
        return (iterator.hasNext());
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

        //Create a new tuple:
        Tuple newTuple = new Tuple(schema);
        //Get the tuple values:
        Tuple tupleValues = iterator.getNext();
        //Move relevant tuple values to the new tuple:
        for (int i = 0; i < this.fields.length; i++) {
            newTuple.setField(i, tupleValues.getField(this.fields[i].intValue()));
        }

        //Return the new yuple with the relevant values:
        return newTuple;
    }

} // public class Projection extends Iterator
