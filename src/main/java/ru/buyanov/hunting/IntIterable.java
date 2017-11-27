package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    int[] backed;


    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return backed.length > 0;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int[] backedSub = new int[backed.length - 1];
            System.arraycopy(backed, 1, backedSub, 0, backed.length - 1);
            int result = backed[0];
            backed = backedSub;
            return result;
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
