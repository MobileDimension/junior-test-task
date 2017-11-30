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
        private int currentCursor = -1;

        public boolean hasNext() {
            return currentCursor < backed.length-1;
        }

        public Integer next() {
            if (hasNext()){
                return backed[++currentCursor];
            }else {
                throw new NoSuchElementException("No more elements");
            }
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
