package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {
    private int[] backed;

    public IntIterable(int[] backed) {
        this.backed = backed;
    }
    
    @Override
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

    private class IntIterator implements Iterator<Integer> {
    	private int index = 0;
    	
    	@Override
        public boolean hasNext() {
            return index<backed.length;
        }
    	
    	@Override
        public Integer next() {
    		if (hasNext()) return backed[index++];
    		throw new NoSuchElementException();
        }
    	
    	@Override
        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}