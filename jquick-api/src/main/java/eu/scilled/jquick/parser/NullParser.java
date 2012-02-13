package eu.scilled.jquick.parser;

public class NullParser implements Parser<Object, Object> {

    @Override
    public Object load(final Object input) {
        return null;
    }

    @Override
    public Object save(final Object input) {
        return null;
    }

}
