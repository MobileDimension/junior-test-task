package ru.buyanov.hunting;

import java.util.Iterator;
import java.util.stream.Stream;

/*
* Nothing to see here
* */
public class TypedIterable<T> implements Iterable<T>{

    private T[] backed;

    public TypedIterable(T[] backed) {
        this.backed = backed;
    }

    public Iterator<T> iterator() {
        return new TypedIterator();
    }

    public Stream<T> stream() {
        return Stream.of(backed);
    }

    private class TypedIterator implements Iterator<T> {
        private int cursor = 0;

        public boolean hasNext() {
            return cursor < backed.length;
        }

        public T next() {
            return backed[cursor++];
        }

        public void remove() {
            throw new UnsupportedOperationException("Could not remove from array");
        }
    }
}
