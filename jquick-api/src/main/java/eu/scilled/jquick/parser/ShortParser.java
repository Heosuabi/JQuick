package eu.scilled.jquick.parser;

public class ShortParser extends PropertyParser<Short> {
    @Override
    public Short load(final String input) {
        return Short.parseShort(input);
    }

    @Override
    public String save(final Short input) {
        return Short.toString(input);
    }
}
