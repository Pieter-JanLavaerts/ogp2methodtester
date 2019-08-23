import java.util.*;

public class MethodTesterController
{
	private MethodTesterModel model = new MethodTesterModel();
	private CommandLineInterface view = new CommandLineInterface();

	public void start() {
		view.displayGreeting();
		loadClass();
		loadMethod();
		model.test();
	}

	public void loadClass() {
		view.displayClassPrompt();
		String className = view.readInput();
		try {
			model.loadClass(className);
		}
		catch (ClassNotFoundException e) {
			view.displayFailedLoadingClass(className);
			loadClass();
		}
	}

	public void loadMethod() {
		List<String> names = model.getMethodNames();
		view.displayMethodNames(names);
		view.displayMethodPrompt();
		String methodName = view.readInput();
		try {
			model.loadMethod(methodName);
		}
		catch (NoSuchMethodException e) {
			view.displayFailedLoadingMethod(methodName);
			loadMethod();
		}
	}
}
