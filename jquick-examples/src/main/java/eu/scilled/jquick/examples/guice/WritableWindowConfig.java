package eu.scilled.jquick.examples.guice;

import eu.scilled.jquick.Config;

/**
 * We extend our readable interface and add setter for write access.
 */
public interface WritableWindowConfig extends WindowConfig {
    @Config("width")
    void setWidth(int width);

    @Config("height")
    void setHeight(int height);
}
