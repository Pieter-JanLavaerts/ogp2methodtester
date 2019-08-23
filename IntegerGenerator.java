import java.util.Stack;

public class IntegerGenerator implements ParameterGenerator<Integer> {
	Stack<Integer> generatedParameters = new Stack<>();

	public IntegerGenerator() {
		generatedParameters.push(0);
		generatedParameters.push(1);
		generatedParameters.push(-1);
	}

	@Override
	public boolean hasNext() {
		return generatedParameters.empty();
	}

	@Override
	public Integer getNext() {
		return generatedParameters.pop();
	}
}
