package org.example;

import bluej.extensions.BlueJ;
import bluej.extensions.Extension;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestExtensionJavaFX extends Extension {
    private static final String NAME = "BlueJ Counter";
    private static final String DESCRIPTION = "Proof of concept JavaFX BlueJ extension";

    @Override
    public boolean isCompatible() {
        return true;
    }

    @Override
    public void startup(BlueJ bluej) {
        // Register a generator for menu items
        bluej.setMenuGenerator(new MenuBuilder());
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getVersion() {
        String version = "unknown";
        try (InputStream stream = TestExtensionJavaFX.class.getResourceAsStream("/META-INF/maven/org.example/bluej-counter/pom.properties")) {
            if (stream != null) {
                Properties properties = new Properties();
                properties.load(stream);
                version = properties.getProperty("version");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /* ignored */
        return version;
    }

    @Override
    public String getDescription() {
        return DESCRIPTION;
    }
}
