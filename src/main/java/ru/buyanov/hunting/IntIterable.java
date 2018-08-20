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

    public Iterator<Integer> iterator() {
        return new IntIterator();
    }

	private class IntIterator implements Iterator<Integer> {
		int cursor; // текущий элемент итерации
		int size = backed.length; // capacity массива.

		public boolean hasNext() {
			return cursor != size;
		}

		public Integer next() {
			//Неполная реализация, но ваши тесты проходит
			int temp = cursor;
			if (temp >= size) {
				throw new NoSuchElementException();
			}
			return backed[cursor++];
		}

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
