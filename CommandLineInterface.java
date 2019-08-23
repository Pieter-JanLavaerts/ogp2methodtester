import java.util.*;

public class CommandLineInterface
{
	public void displayGreeting()
	{
		System.out.println("Welcome to the classtester 9000!");
	}

	private void displayPrompt(String subject)
	{
		System.out.println("Please enter "+subject+" you'd like to test.");
		System.out.print("> ");
	}

	public void displayClassPrompt()
	{
		displayPrompt("the name of the class");
	}

	public void displayMethodPrompt()
	{
		displayPrompt("the name of the method");
	}

	public void displayFailedLoadingClass(String className)
	{
		System.out.println(className + " class not found! Please try a different name.");
	}

	public void displayFailedLoadingMethod(String className)
	{
		System.out.println(className + " method not found! Please try a different name.");
	}


	public String readInput()
	{
		Scanner input = new Scanner(System.in);
		return input.next();
	}

	public void displayMethodNames(List<String> names)
	{
		System.out.println("The available methods are:");
		for (String name : names){
			System.out.println(name);
		}
	}
}
