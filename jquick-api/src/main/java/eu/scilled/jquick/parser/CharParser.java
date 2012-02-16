package eu.scilled.jquick.parser;

public class CharParser extends PropertyParser<Character> {
    @Override
    public Character load(final String input) {
        return input.charAt(0);
    }

    @Override
    public String save(final Character input) {
        return Character.toString(input);
    }
}
