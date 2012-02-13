package eu.scilled.jquick.parser;

/**
 * <p>A Parser parses one type to another. This is used to load various types of objects.</p>
 * 
 * @param <ParseType> The type which will be loaded and saved to.
 * @param <ResultType> The real type which will be used in code.
 */
public interface Parser<ParseType, ResultType> {
    ResultType load(ParseType input);

    ParseType save(ResultType input);
}
