package eu.scilled.jquick.parser;

public class IntParser extends PropertyParser<Integer> {

    @Override
    public Integer load(final String input) {
        return Integer.parseInt(input);
    }

    @Override
    public String save(final Integer input) {
        return String.valueOf(input);
    }

}
