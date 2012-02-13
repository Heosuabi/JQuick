package eu.scilled.jquick.parser;

public interface Parser<ParseType, ResultType> {
    ResultType load(ParseType input);

    ParseType save(ResultType input);
}
