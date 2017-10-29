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

        private int i;

        private IntIterator() {
            i = 0;
        }

        public boolean hasNext() {
            if (backed.length == 0 || i == backed.length) {
                return false;
            }
            return true;
        }

        public Integer next() {
            return backed[i++];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
