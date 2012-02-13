package eu.scilled.jquick.parser;

public class StringParser extends PropertyParser<String> {

    @Override
    public String load(final String input) {
        return input;
    }

    @Override
    public String save(final String input) {
        return input;
    }

}
