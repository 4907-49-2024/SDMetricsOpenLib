package com.sdmetrics.test;

import com.sdmetrics.model.MetaModelElement;
import com.sdmetrics.model.ModelElement;

public class Utils {

	public static final String TEST_APP_DIR = "src/test/java/com/sdmetrics/app/";
	public static final String TEST_METRICS_DIR = "src/test/java/com/sdmetrics/metrics/";
	public static final String TEST_MODEL_DIR = "src/test/java/com/sdmetrics/model/";
	public static final String TEST_OUTPUT_DIR = "src/test/java/com/sdmetrics/output/";
	public static final String TEST_UTIL_DIR = "src/test/java/com/sdmetrics/util/";

	public static String dump(ModelElement e) {
		MetaModelElement type = e.getType();
		StringBuilder s = new StringBuilder(type.getName());
		s.append("(");
		for (String attrName : type.getAttributeNames()) {
			if (s.length() > 0) {
				s.append(',');
			}
			s.append(attrName);
			s.append(':');
			if (type.isSetAttribute(attrName)) {
				s.append(e.getSetAttribute(attrName));
			} else if (type.isRefAttribute(attrName)) {
				s.append(e.getRefAttribute(attrName) + " (ref)");
			} else {
				s.append(e.getPlainAttribute(attrName) + " (data)");
			}
		}
		s.append(')');
		return s.toString();
	}
}
