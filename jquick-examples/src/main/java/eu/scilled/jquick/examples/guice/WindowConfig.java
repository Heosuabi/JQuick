package eu.scilled.jquick.examples.guice;

import eu.scilled.jquick.Config;

/**
 * We define a simple readable only interface for window properties like width and height.
 */
public interface WindowConfig {
    @Config("width")
    int getWidth();

    @Config("height")
    int getHeight();
}
