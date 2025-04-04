package com.sdmetrics.metrics;

import com.sdmetrics.test.MetricTestContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSet {

	MetricTestContext mtc;

	@Before
	public void loadTestFixture() throws Exception {
		mtc = MetricTestContext.getStandardContext04();
	}

	@Test
	public void toStringNoLocation() {
		Set s = mtc.getSet("OpSet", "class");
		assertEquals("set OpSet for elements of type class", s.toString());
	}
}
