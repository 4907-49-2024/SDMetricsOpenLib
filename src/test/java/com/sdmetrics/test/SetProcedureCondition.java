package com.sdmetrics.test;

import com.sdmetrics.math.ExpressionNode;
import com.sdmetrics.metrics.*;
import com.sdmetrics.model.ModelElement;

import java.util.Collection;


public class SetProcedureCondition extends SetProcedure {

	@Override
	public Collection<?> calculate(ModelElement element, Set set)
			throws SDMetricsException {

		ProcedureAttributes attributes = set.getAttributes();
		ExpressionNode condexp = attributes.getRequiredExpression("condition");
		ExpressionNode setExpr = attributes.getRequiredExpression("set");
		ExpressionNode altExpr = attributes.getRequiredExpression("alt");

		Variables vars = new Variables(element);
		boolean condition = evalBooleanExpression(element, condexp, vars);
		if (condition) {
			return evalSetExpression(element, setExpr, vars);
		}

		return evalSetExpression(element, altExpr, vars);
	}
}
