package com.sdmetrics.metrics;

import com.sdmetrics.test.MetricTestContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMetricProcedureSubelements {

	@Test
	public void values() throws Exception {
		MetricTestContext mtc = MetricTestContext.getStandardContext04();

		assertEquals(3,
				mtc.getMetricValue("RecClassCount", "package1_1", "package"), 0);
		assertEquals(0,
				mtc.getMetricValue("RecClassCount", "package2", "package"), 0);
	}
}
