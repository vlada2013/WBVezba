package BooksApi;


import org.junit.Test;

import java.util.HashMap;

public class Books {
    // Import the HashMap class

    @Test
    public void main() {
        // Create a HashMap object called name
        HashMap<String, String> name = new HashMap<String, String>();

        // Add keys and name values for books
        name.put("name[0]", "The Russian");
        name.put("name[1]", "Just as I Am");
        name.put("name[2]", "The Vanishing Half");
        name.put("name[3]", "The Midnight Library");
        name.put("name[4]", "Untamed");
        name.put("name[5]", "Viscounts  Who Loved Me");


        // Create a HashMap object called id
        HashMap<String, Integer> id = new HashMap<String, Integer>();

        // Add keys and values (Name, Age)
        id.put("id[0]", 1);
        id.put("id[1]", 2);
        id.put("id[2]", 3);
        id.put("id[3]", 4);
        id.put("id[4]", 5);
        id.put("id[5]", 6);


        // Create a HashMap object called id
        HashMap<String, Boolean> available = new HashMap<String, Boolean>();

        // Add keys and values (Name, Age)
        available.put("available[0]", true);
        available.put("available[1]", false);
        available.put("available[2]", true);
        available.put("available[3]", true);
        available.put("available[4]", true);
        available.put("available[5]", true);


        HashMap<String, String> type = new HashMap<String, String>();

        // Add keys and name values for books
        type.put("type[0]", "fiction");
        type.put("type[1]", "non-fiction");
        type.put("type[2]", "fiction");
        type.put("type[3]", "fiction");
        type.put("type[4]", "non-fiction");
        type.put("type[5]", "fiction");
    }
}
