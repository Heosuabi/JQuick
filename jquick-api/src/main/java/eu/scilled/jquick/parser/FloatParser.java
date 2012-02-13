package eu.scilled.jquick.parser;

public class FloatParser extends PropertyParser<Float> {

    @Override
    public Float load(final String input) {
        return Float.parseFloat(input);
    }

    @Override
    public String save(final Float input) {
        return String.valueOf(input);
    }

}
