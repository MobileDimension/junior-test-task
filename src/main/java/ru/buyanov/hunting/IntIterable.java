package ru.buyanov.hunting;

import java.util.Arrays;
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
        private int cursor;

        public boolean hasNext() {
            return (backed.length > 0);
        }

        public Integer next() {
            int len = backed.length;
            if (len==0){
                throw new NoSuchElementException();
            }
            int current = backed[0];
            backed = Arrays.copyOfRange(backed, 1, len);
            return current;
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
