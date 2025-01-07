package com.sdmetrics.metrics;

import com.sdmetrics.test.MetricTestContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestMetricProcedureFilterValue {

	@Test
	public void values() throws Exception {
		MetricTestContext mtc = MetricTestContext.getStandardContext04();

		assertEquals("",
				mtc.getMetricStrValue("ClientName", "Vehicle", "class"));
		assertEquals("Manufacturer",
				mtc.getMetricStrValue("ClientName", "Supplier", "class"));
		assertEquals(mtc.getElement("Manufacturer", "class").getXMIID(),
				mtc.getMetricStrValue("ClientElement", "Supplier", "class"));
		assertEquals("",
				mtc.getMetricStrValue("ClientName", "Manufacturer", "class"));
	}
}
