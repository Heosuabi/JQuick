package eu.scilled.jquick.parser;

public class BooleanParser extends PropertyParser<Boolean> {
    @Override
    public Boolean load(final String input) {
        return Boolean.parseBoolean(input);
    }

    @Override
    public String save(final Boolean input) {
        return String.valueOf(input);
    }
}
