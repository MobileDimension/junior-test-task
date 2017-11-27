package ru.buyanov.hunting;

import java.util.ConcurrentModificationException;
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

    /**
     * An iterator over an integer array.
     * This implementation is not thread-safe.
     */
    private class IntIterator implements Iterator<Integer> {
        private int length = backed.length;
        private int current;

        public boolean hasNext() {
            return current < backed.length;
        }

        public Integer next() {
            if (length!=backed.length) {
                //somebody has modified our precious array!
                throw new ConcurrentModificationException();
            }
            int index = current;
            if (index >= backed.length) {
                throw new NoSuchElementException();
            }
            current = current + 1;
            return backed[index];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
