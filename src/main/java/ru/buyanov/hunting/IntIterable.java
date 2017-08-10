package ru.buyanov.hunting;

import java.util.Iterator;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    private int[] array;
    private int arraySize;


    public IntIterable(int[] newArray) {
        this.array = newArray;
        this.arraySize = array.length;
    }

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {

        private int index = 0;

        public boolean hasNext() {
            //TODO: You task is implement this method
            return arraySize > index;
        }

        public Integer next() {
            //TODO: You task is implement this method
            return array[index++];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
