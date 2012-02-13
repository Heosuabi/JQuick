package eu.scilled.jquick.parser;

public class DoubleParser extends PropertyParser<Double> {

    @Override
    public Double load(final String input) {
        return Double.parseDouble(input);
    }

    @Override
    public String save(final Double input) {
        return String.valueOf(input);
    }

}
