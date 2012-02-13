package eu.scilled.jquick.parser;

public class LongParser extends PropertyParser<Long> {
    @Override
    public Long load(final String input) {
        return Long.parseLong(input);
    }

    @Override
    public String save(final Long input) {
        return String.valueOf(input);
    }
}
