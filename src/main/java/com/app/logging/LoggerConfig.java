package com.app.logging;

import java.io.InputStream;
import java.util.Properties;

//configuration class to load logging settings from file (resources/logging.properties)
public class LoggerConfig {

    private boolean enabled;
    private LogLevel level;

    public LoggerConfig() {
        // load file from resources
        // parse values
        try (InputStream input =
                getClass().getClassLoader().getResourceAsStream("logger.properties")) {
            
            if (input == null) {
                throw new IllegalStateException("logger.properties not found in resources");
}
            Properties props = new Properties();
            props.load(input);

            this.enabled = Boolean.parseBoolean(props.getProperty("enabled"));
            this.level = LogLevel.valueOf(props.getProperty("level"));

        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void run(){
        System.out.println("Running logger config");
        System.out.println("Logging enabled: " + enabled);
        System.out.println("Logging level: " + level);
    }
    public LogLevel getLevel() {
        return level;
    }
}