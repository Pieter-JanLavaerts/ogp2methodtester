import java.util.Optional;

public class ParameterGeneratorFactory
{
	public Optional<ParameterGenerator> create(Class[] parameters) {
		if (parameters.length > 1) {
			return Optional.empty();
		}
		if (parameters.length == 0) {
			return Optional.of(new VoidGenerator());
		}
		switch (parameters[0].getName()) {
		case "Integer":
			return Optional.of(new IntegerGenerator());
		case "String":
			return Optional.of(new StringGenerator());
		default:
			return Optional.empty();
		}
	}
}
