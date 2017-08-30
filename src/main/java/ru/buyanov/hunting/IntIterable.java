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
        int cursor;         // index of next element to return
        int lastRet = -1;   // index of last element returned; -1 if no such

        public boolean hasNext() {
            //TODO: You task is implement this method
            return cursor != backed.length;
        }

        public Integer next() {
            //TODO: You task is implement this method
            int i = cursor;
            cursor = i + 1;
            return backed[lastRet = i];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
