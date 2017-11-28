package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    private int[] backed;


    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {
        private int cursor;

        public boolean hasNext() {
            return (cursor < backed.length);
        }

        public Integer next() {
            int current = cursor;
            cursor++;
            if (current>=backed.length){
                throw new NoSuchElementException();
            }
            return backed[current];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
