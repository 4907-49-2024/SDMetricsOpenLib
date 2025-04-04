package com.sdmetrics.math;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestIntegerMatrix {

	IntegerMatrix im = new IntegerMatrix();

	@Test
	public void emptyMatrix() {
		assertTrue(im.isEmpty());
		im.increment(12, 35);
		assertFalse(im.isEmpty());
	}

	@Test
	public void increment() {
		assertEquals(Integer.valueOf(0), im.get(10, 11));
		assertEquals(Integer.valueOf(1), im.increment(10, 11));
		assertEquals(Integer.valueOf(1), im.get(10, 11));
		assertEquals(Integer.valueOf(2), im.increment(10, 11));
		assertEquals(Integer.valueOf(2), im.get(10, 11));
	}
}
