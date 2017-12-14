package ru.buyanov.hunting;

import org.w3c.dom.ranges.Range;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {

    private int[] backed;
    private int index;


    public IntIterable(int[] backed) {
        this.backed = backed;
        this.index = 0;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {
            return index < backed.length;
        }

        public Integer next() {
            if (hasNext()) {
                return backed[index++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
