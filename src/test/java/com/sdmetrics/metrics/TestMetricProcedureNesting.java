package com.sdmetrics.metrics;

import com.sdmetrics.test.MetricTestContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMetricProcedureNesting {

	@Test
	public void nesting() throws Exception {
		MetricTestContext mtc = MetricTestContext.getStandardContext04();
		assertEquals(3,
				mtc.getMetricValue("Nesting", "package1_1_1", "package"), 0);
		assertEquals(0, mtc.getMetricValue("Nesting", "scope", "package"), 0);
		assertEquals(0, mtc.getMetricValue("Nesting", "testModel04", "model"),
				0);
	}

}
