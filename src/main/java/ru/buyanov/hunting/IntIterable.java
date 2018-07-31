package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/SultanIsaev 01.08.2018
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
        int current = 0;

        public boolean hasNext() {
            return current < backed.length;
        }

        public Integer next() {
            if(hasNext()){
                return backed[current++];
            }else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
