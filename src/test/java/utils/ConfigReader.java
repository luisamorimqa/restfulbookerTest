package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try(InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream("application.properties")) {

            if(input == null) {
                throw new RuntimeException("Não foi possível encontrar o arquivo application.json");
            }
            properties.load(input);
        } catch (IOException exception) {
            throw new RuntimeException("Erro ao carregar o arquivo application.properties", exception);
        }
    }

    public static String getProperty(String key) {
         return properties.getProperty(key);
    }
}
