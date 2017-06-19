package ru.buyanov.hunting;

import java.util.Iterator;

/**
 * @author https://github.com/alex-on-java 03.02.2016
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
        int indexOfElement = 0;

        public boolean hasNext() {
            //Check for an existing index in an array
            return indexOfElement < backed.length;
        }

        public Integer next() {
            //Check for an existing index in an array
            if (!hasNext()) {
                throw new ArrayIndexOutOfBoundsException();
            }

            //increment index and return the next element
            indexOfElement++;

            return backed[indexOfElement - 1];
        }


        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
