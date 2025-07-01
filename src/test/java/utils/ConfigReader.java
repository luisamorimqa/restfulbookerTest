package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try(InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties = new Properties();

            if(input != null) {
                properties.load(input);
            } else {
                throw new RuntimeException("Arquivo application.properties não encontrado!");
            }
        } catch (IOException exception) {
            throw new RuntimeException("Erro ao carregar arquivo application.properties", exception);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}