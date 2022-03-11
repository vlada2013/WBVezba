package common;

import java.io.*;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

public class FileReaderHelper {

    private String path = "";
    private String text;
    private JSONObject json;

    public FileReaderHelper(String path) throws IOException {
        this.path = path;
        this.ReadFile(path);
    }

    public void ReadFile(String path) throws IOException {

        File f = new File(path);
        if (f.exists()){
            InputStream is = new FileInputStream(path);
            text = IOUtils.toString(is, "UTF-8");
            json = new JSONObject(text);
        }
    }

    public String Get(String key)
    {
        return json.getString(key);
    }

    public String Get()
    {
        return text;
    }
}