package BooksApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetBooks {



    @Test
    public void getAllBooks() {
        Response responseBody=  given()
                .when()
                .get("https://simple-books-api.glitch.me/books")
                .then().extract().response();

        JsonPath jsonPath=responseBody.jsonPath();
        assertThat("Name value.", jsonPath.get("name[0]"), equalTo("The Russian"));
        String name = jsonPath.get("name[0]");
        System.out.println("Name received from Response " + name);
    }


}