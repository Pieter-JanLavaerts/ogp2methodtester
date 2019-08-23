public class VoidGenerator implements ParameterGenerator {
	private boolean notCalled = true;

	@Override
	public boolean hasNext() {
		return notCalled;
	}

	public Object getNext() {
		notCalled = false;
		return null;
	}
}
