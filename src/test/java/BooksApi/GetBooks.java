package BooksApi;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
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
        JsonPath toString = new JsonPath(responseBody.asString());
        int numberOfAllBooks = toString.getInt("data.size()");
        String booksAsString = responseBody.asString();

        System.out.println(booksAsString.length());
        System.out.println("Number of all books is : " + numberOfAllBooks);




        int statusCode = responseBody.getStatusCode();
        Assert.assertEquals(statusCode, 200 );
        System.out.println("Status code received from Response is : " + statusCode);

        //first book
        //name
        assertThat("Name value.", jsonPath.get("name[0]"), equalTo("The Russian"));
        String name = jsonPath.get("name[0]");
        System.out.println("First book info: ");
        System.out.println("Name received from Response is : " + name);


        //type
        assertThat("Type value.", jsonPath.get("type[0]"), equalTo("fiction"));
        String type = jsonPath.get("type[0]");
        System.out.println("Type received from Response is : " + type);


        //available
        Boolean available = jsonPath.getBoolean("available[0]");
        Assert.assertEquals(true,available);
        System.out.println("Availability received from Response is : " + available);




        //second book
        //name
        assertThat("Name value.", jsonPath.get("name[1]"), equalTo("Just as I Am"));
        name = jsonPath.get("name[1]");
        System.out.println("Second book info: ");
        System.out.println("Name received from Response is : " + name);

        //type
        assertThat("Type value.", jsonPath.get("type[1]"), equalTo("non-fiction"));
        type = jsonPath.get("type[1]");
        System.out.println("Type received from Response is : " + type);

        //available
        available = jsonPath.getBoolean("available[1]");
        Assert.assertEquals(false,available);
        System.out.println("Availability received from Response is : " + available);




        //third book
        //name
        assertThat("Name value.", jsonPath.get("name[2]"), equalTo("The Vanishing Half"));
        name = jsonPath.get("name[2]");
        System.out.println("Third book info: ");
        System.out.println("Name received from Response is : " + name);

        //type
        assertThat("Type value.", jsonPath.get("type[2]"), equalTo("fiction"));
        type = jsonPath.get("type[2]");
        System.out.println("Type received from Response is : " + type);

        //available
        available = jsonPath.getBoolean("available[2]");
        Assert.assertEquals(true,available);
        System.out.println("Availability received from Response is : " + available);

    }
}