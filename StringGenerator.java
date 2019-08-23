import java.util.Stack;

public class StringGenerator implements ParameterGenerator<String> {
	private Stack<String> generatedParameters = new Stack<>();

	public StringGenerator() {
		generatedParameters.push("");
		generatedParameters.push("Hello");
	}

	@Override
	public boolean hasNext() {
		return generatedParameters.empty();
	}

	@Override
	public String getNext() {
		return generatedParameters.pop();
	}
}
