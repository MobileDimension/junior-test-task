package ru.buyanov.hunting;

import org.junit.Ignore;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

@Ignore
public class TypedIterableTest {

    @Test
    public void testForeach() {
        String[] arr = {"0", "1", "2", "3", "4"};
        TypedIterable<String> intIterable = new TypedIterable<>(arr);
        AtomicInteger effectivelyFinal = new AtomicInteger();
        intIterable.forEach( (s) -> {effectivelyFinal.incrementAndGet(); assertEquals(s + " element doesn't match", arr[Integer.parseInt(s)], s);});
        assertEquals("Didn't pass through array fully", effectivelyFinal.get(), arr.length);
    }

    @Test
    public void testBlankForeach() {
        new TypedIterable<>(new String[0]).forEach( (s) -> assertFalse("Shouldn't come here", true));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testRemoveFailure() {
        new TypedIterable<>(new String[0]).iterator().remove();
    }
}