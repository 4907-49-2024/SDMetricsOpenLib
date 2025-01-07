package com.sdmetrics.metrics;

import com.sdmetrics.model.ModelElement;
import com.sdmetrics.test.MetricTestContext;
import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertEquals;

public class TestSetProcedureCompound {

	@Test
	public void compound() throws Exception {
		MetricTestContext mtc = MetricTestContext.getStandardContext04();
		HashSet<ModelElement> result = new HashSet<>();
		result.add(mtc.getElement("Resource", "class"));
		result.add(mtc.getElement("Supplier", "class"));
		assertEquals(result,
				mtc.getSetValue("DependingClassesTC", "Manufacturer", "class"));
	}
}
