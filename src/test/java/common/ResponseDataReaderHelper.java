package common;

import io.restassured.path.json.JsonPath;

import java.util.HashMap;

public class ResponseDataReaderHelper {

    public HashMap<String, String> name;
    public HashMap<String, Integer> id;
    public HashMap<String, Boolean> available;
    public HashMap<String, String> type;

    public ResponseDataReaderHelper(JsonPath jsonPath)
    {
        name = GetHashMap(jsonPath, "name");
        id = GetHashMap(jsonPath, "id");
        available = GetHashMap(jsonPath, "available");
        type = GetHashMap(jsonPath, "type");
    }


    public <T> HashMap<String, T> GetHashMap(JsonPath jsonPath, String paramName)
    {
        HashMap<String, T> result = new HashMap<String, T>();
        //Integer s = jsonPath.get().size();

        for (int i=0; i<6; i++)
        {
            result.put("Book" + Integer.toString(i), jsonPath.get(paramName + "[" + Integer.toString(i) + "]"));
        }
        return result;
    }
}
