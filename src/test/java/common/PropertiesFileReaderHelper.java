package common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileReaderHelper {
    private String path;
    private Properties prop;

    public PropertiesFileReaderHelper(String path)
    {
        this.path = path;
        LoadFile();
    }

    public void LoadFile()
    {
        try (InputStream input = new FileInputStream(path)) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String Get(String key)
    {
        return prop.getProperty(key);
    }
}
