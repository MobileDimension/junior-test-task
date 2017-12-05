package ru.buyanov.hunting;

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

    /**
     * Weakly consistent iterator for {@link IntIterable}
     */
    private class IntIterator implements Iterator<Integer> {
        int counter;
        int[] backedCopy = backed.clone();//Iterator goes over copy of array, further array modifications ignored

        public boolean hasNext() {
            return counter < backedCopy.length;
        }

        public Integer next() {
            if (hasNext()) {
                return backedCopy[counter++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
