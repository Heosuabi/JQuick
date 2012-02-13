package eu.scilled.jquick;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import eu.scilled.jquick.AutomaticParser;
import eu.scilled.jquick.parser.Parser;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Config {
    String value();

    Class<? extends Parser<?, ?>> parser() default AutomaticParser.class;
}
