package ru.buyanov.hunting;

import java.util.Iterator;

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

        private int cursor = 0;

        public boolean hasNext() {
            return cursor < backed.length;
        }

        public Integer next() {
            if (!this.hasNext()) return null;
            return backed[cursor++];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}