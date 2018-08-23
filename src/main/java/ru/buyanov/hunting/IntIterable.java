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
        int index = 0;
        int size = backed.length;

        /**
         *0 is valid
         */
        public boolean hasNext() {

            return (index < size) ;
        }

        public Integer next() {

            return backed[index++];
        }

        public void remove() {

            throw new IllegalStateException("Could not remove from array");
        }
    }
}
