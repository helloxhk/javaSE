package test_java;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestA {
	@SuppressWarnings("all")
	public static void main(String[] args) throws Exception, SecurityException {
		Method method = null;
		Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
	}
}
