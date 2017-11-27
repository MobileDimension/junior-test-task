package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    private int[] backed;
    private int currentSize;
    private int currentIndex = 0;

    public IntIterable(int[] backed) {
        this.backed = backed;
        this.currentSize = backed.length;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return currentIndex < currentSize;
        }

        public Integer next() {
            if (hasNext()) {
                return backed[currentIndex++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
