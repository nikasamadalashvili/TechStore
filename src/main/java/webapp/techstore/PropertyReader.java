package webapp.techstore;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String propFileName="application.properties";

        InputStream inputStream = PropertyReader.class.getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }
        System.out.println(properties.getProperty("datasource.jdbc.username"));
        return properties;
    }
}
