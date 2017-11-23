package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    int[] backed;
    private int count = 0;

    public IntIterable(int[] backed) {
        this.backed = backed;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        public boolean hasNext() {

            return (count < backed.length);
        }

        public Integer next() {

            if(count >= backed.length){
                System.out.println("No elements in Array!");
                throw new NoSuchElementException("There is no more or zero elements in array.");
            }

            return backed[count++];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
