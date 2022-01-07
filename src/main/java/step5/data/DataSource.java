package step5.data;

import com.google.common.io.Resources;

import java.io.*;
import java.util.Properties;

public class DataSource {

    public final String URL;
    public final String USER;
    public final String PASSWORD;

    public DataSource() {
        Properties properties = loadProperties();
        this.URL = properties.getProperty("url");
        this.USER = properties.getProperty("user");
        this.PASSWORD = properties.getProperty("password");
    }

    private Properties loadProperties() {
        String resource = "DB.properties";
        Properties properties = new Properties();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resource)){
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}
