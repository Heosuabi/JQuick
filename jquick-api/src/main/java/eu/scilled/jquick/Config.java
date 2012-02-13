package eu.scilled.jquick;

import eu.scilled.jquick.parser.Parser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>Marks a method as a configuration value.</p>
 * <p>The value string is the name of the key of the Map or the Properties.
 * If no explicit Parser is set, JQuick tries to automatically recognize the correct Parser type.</p>
 * <p>For now only primitive values and Strings are automatically parsed.</p>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Config {
    String value();

    Class<? extends Parser<?, ?>> parser() default AutomaticParser.class;
}
