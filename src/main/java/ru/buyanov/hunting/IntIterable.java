package ru.buyanov.hunting;

import java.util.Iterator;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    int size;
    int[] backed;


    public IntIterable(int[] backed) {
        this.backed = backed;
        this.size = backed.length;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        int index = 0;

        public boolean hasNext() {
            //TODO: You task is implement this method
            return index < size;
        }

        public Integer next() {
            //TODO: You task is implement this method
            return backed[index++];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
