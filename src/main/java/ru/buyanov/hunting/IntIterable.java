package ru.buyanov.hunting;

import java.util.Iterator;

/**
 * @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    private int current = -1;
    private int[] backed;


    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return backed.length - 1 > current;
        }

        public Integer next() {
            if (hasNext()) {
                current += 1;
                return backed[current];
            }
            return null;
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
