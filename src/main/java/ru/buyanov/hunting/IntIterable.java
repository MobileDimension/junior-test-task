package ru.buyanov.hunting;

import java.util.Iterator;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    private int[] backed;
    private int position;


    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return backed.length > position;
        }

        public Integer next() {
            return backed[position++];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
