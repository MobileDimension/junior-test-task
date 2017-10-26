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

        public boolean hasNext() {
            return backed.length != 0;
        }

        public Integer next() {
            int[] subArrayOfBacked = new int[backed.length - 1];
            for (int i = 1; i < backed.length; i++) subArrayOfBacked[i - 1] = backed[i];
            int res = backed[0];
            backed = subArrayOfBacked;
            return res;
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}