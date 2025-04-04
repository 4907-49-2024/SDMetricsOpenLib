package com.sdmetrics.metrics;

import com.sdmetrics.test.MetricTestContext;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class TestRule {

	private MetricTestContext mtc;
	private Rule rule;

	@Before
	public void loadTestFixture() throws Exception {
		mtc = MetricTestContext.getStandardContext04();
		rule = mtc.getRule("NoOps", "class");
	}

	// TODO: fix test
//	@Test
//	public void toStringWithLocation() {
//		assertEquals("rule NoOps for elements of type class (line 168)",
//				rule.toString());
//	}

	@Test
	public void toStringNoLocation() {
		Rule r = new Rule("Test", mtc.getType("package"), "testing", "none",
				Collections.<String>emptyList(), true);
		assertEquals("rule Test for elements of type package", r.toString());
	}
}
