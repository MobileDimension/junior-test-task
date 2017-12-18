package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    private int[] backed;
    private int cursor = 0;

    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            //TODO: You task is implement this method
            return cursor != backed.length;
        }

        public Integer next() {
            //TODO: You task is implement this method
            int i = cursor;
            if (i > backed.length) {
                throw new NoSuchElementException();
            }

            cursor = i + 1;
            return backed[i];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
