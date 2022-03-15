package BooksApi;


import common.ResponseDataReaderHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Books {
    // Import the HashMap class

    @Test
    public void books() {
        Response responseBody=  given()
                .when()
                .get("https://simple-books-api.glitch.me/books")
                .then().extract().response();

        JsonPath jsonPath=responseBody.jsonPath();

        ResponseDataReaderHelper rdrh = new ResponseDataReaderHelper(jsonPath);
        String name = rdrh.name.get("Book3");

    }

}
