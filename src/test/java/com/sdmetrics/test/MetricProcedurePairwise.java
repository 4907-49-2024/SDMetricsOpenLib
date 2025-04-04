package com.sdmetrics.test;

import com.sdmetrics.math.ExpressionNode;
import com.sdmetrics.metrics.*;
import com.sdmetrics.model.ModelElement;

import java.util.Collection;
import java.util.Comparator;


public class MetricProcedurePairwise extends MetricProcedure {

	@Override
	public Object calculate(ModelElement element, Metric metric)
			throws SDMetricsException {
		ProcedureAttributes attributes = metric.getAttributes();

		Variables vars = new Variables(element);
		Collection<ModelElement> set = getRelationOrSet(element, attributes,
				vars);
		if (set == null) {
			return Integer.valueOf(0);
		}

		boolean allTuples = attributes.getBooleanValue("tuples", false);
		boolean withSelf = attributes.getBooleanValue("withself", allTuples);
		ExpressionNode pairCondition = attributes
				.getExpression("paircondition");

		FilterAttributeProcessor fap = getFilterAttributeProcessor(attributes);
		SummationHelper sum = new SummationHelper(getMetricsEngine(),
				attributes);
		Comparator<ModelElement> comparator = ModelElement.getComparator();

		for (ModelElement first : fap.validIteration(set, vars)) {
			vars.setVariable("_first", first);
			for (ModelElement second : fap.validIteration(set, vars)) {
				int comp = comparator.compare(first, second);
				if (comp == 0 && !withSelf) {
					continue;
				}
				if (comp > 0 && !allTuples) {
					continue;
				}

				vars.setVariable("_second", second);
				if (pairCondition == null
						|| evalBooleanExpression(element, pairCondition, vars)) {
					sum.add(second, vars);
				}
			}
		}
		return sum.getTotal();
	}
}
