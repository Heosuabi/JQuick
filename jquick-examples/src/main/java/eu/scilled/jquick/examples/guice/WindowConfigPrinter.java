package eu.scilled.jquick.examples.guice;

import com.google.inject.Inject;

/**
 * WindowConfigPrinter is only allowed to read the window configuration.
 */
public class WindowConfigPrinter {

    private WindowConfig config;

    @Inject
    public WindowConfigPrinter(WindowConfig config) {
        this.config = config;
    }

    public void print() {
        System.out.println("Width: " + config.getWidth());
        System.out.println("Height: " + config.getHeight());
    }
}

