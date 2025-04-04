package com.sdmetrics.metrics;

import com.sdmetrics.test.MetricTestContext;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestMetricProcedureValueSet {

	@Test
	public void valueSetOperation() throws Exception {
		MetricTestContext mtc = MetricTestContext.getStandardContext04();
		ProcedureAttributes procAttr = new ProcedureAttributes();
		Metric metric = new Metric("test", mtc.getType("class"), null);
		metric.setAttributes(procAttr);

		MetricProcedureValuesetOperation setOperation = new MetricProcedureValuesetOperation();
		setOperation.setMetricsEngine(mtc.me);
		procAttr.setExpressionNode("set", mtc.parse("IncomingDependencies"));

		assertEquals(Integer.valueOf(2), setOperation.calculate(
				mtc.getElement("Vehicle", "class"), metric));
	}

}
