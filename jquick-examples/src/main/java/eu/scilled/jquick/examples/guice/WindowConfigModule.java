package eu.scilled.jquick.examples.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import eu.scilled.jquick.JQuick;

import java.util.HashMap;
import java.util.Map;

/**
 * We define a new guice module and bind JQuick instances to the configuration interfaces.<br>
 * We are using the same Map/Properties for both interfaces: readable and writable.
 */
public class WindowConfigModule extends AbstractModule {

    private Map<String, String> config;

    public WindowConfigModule(Map<String, String> config) {
        this.config = config;
    }

    @Override
    protected void configure() {
        bind(WindowConfig.class).toInstance(JQuick.create(config, WindowConfig.class));
        bind(WritableWindowConfig.class).toInstance(JQuick.create(config, WritableWindowConfig.class));
    }

    public static void main(String[] args) {
        //We create a Map for our configuration. This can be properties as well.
        Map<String, String> config = new HashMap<String, String>();
        config.put("width", "800");
        config.put("height", "600");

        //We create our guice injector with our module and our Map.
        Injector injector = Guice.createInjector(new WindowConfigModule(config));
        WindowConfigPrinter printer = injector.getInstance(WindowConfigPrinter.class);
        WindowConfigWriter writer = injector.getInstance(WindowConfigWriter.class);

        printer.print(); //This will print the current size 800x600
        writer.setSize(1024, 768); //We change the config with our writer to 1024x768
        printer.print(); //The new configuration is reflected here
    }
}
