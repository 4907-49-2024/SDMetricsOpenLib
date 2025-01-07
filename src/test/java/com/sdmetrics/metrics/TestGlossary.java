package com.sdmetrics.metrics;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestGlossary {

	Glossary entry = new Glossary("Test");

	@Test
	public void toStringNoLocation() {
		assertEquals("glossary entry Test", entry.toString());
	}
}
