package eu.scilled.jquick.parser;

public class ByteParser extends PropertyParser<Byte> {
    @Override
    public Byte load(final String input) {
        return Byte.parseByte(input);
    }

    @Override
    public String save(final Byte input) {
        return Byte.toString(input);
    }
}
