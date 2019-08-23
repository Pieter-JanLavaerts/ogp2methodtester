import java.lang.reflect.*;
import java.util.stream.Collectors;
import java.util.*;

public class MethodTesterModel
{
	private Class loadedClass;
	private Method loadedMethod;

	public void loadClass(String className) throws ClassNotFoundException
	{
		loadedClass = Class.forName(className);
	}

	public void loadMethod(String methodName) throws NoSuchMethodException
	{
		for (Method m : loadedClass.getMethods()) {
			if (m.getName().equals(methodName)) {
					loadedMethod = m;
					return;
			}
		}
		loadedMethod = loadedClass.getMethod(methodName); //will throw NoSuchMethodException
	}

	public List<String> getMethodNames()
	{
		Method[] methods = loadedClass.getMethods();
		return Arrays.stream(methods).map(Method::getName).collect(Collectors.toList());
	}

	public void test()
	{
		ParameterGeneratorFactory factory = new ParameterGeneratorFactory();
		Optional<ParameterGenerator> generator = factory.create(loadedMethod.getParameterTypes());
		if (generator.isPresent()) {
			while (generator.get().hasNext()) {
				try {
					loadedMethod.invoke(generator.get().getNext());
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
