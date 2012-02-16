package eu.scilled.jquick.examples.guice;

import com.google.inject.Inject;

/**
 * WindowConfigWriter is allowed to write the window configuration.
 */
public class WindowConfigWriter {

    private WritableWindowConfig config;

    @Inject
    public WindowConfigWriter(WritableWindowConfig config) {
        this.config = config;
    }

    public void setSize(int w, int h) {
        config.setWidth(w);
        config.setHeight(h);
    }
}
