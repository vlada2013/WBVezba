package BooksApi;

import common.ResponseDataReaderHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;


public class GetBooks {


    Response responseBody=  given()
            .when()
            .get("https://simple-books-api.glitch.me/books")
            .then().extract().response();

    JsonPath jsonPath=responseBody.jsonPath();
    JsonPath toString = new JsonPath(responseBody.asString());
    int numberOfAllBooks = toString.getInt("data.size()");
    String booksAsString = responseBody.asString();
    @Test
    public void getAllBooks() {


        String arr[] = {booksAsString};
        System.out.println(arr[0]);


        String firstBookAsString = responseBody.asString();
        String[] strArray = firstBookAsString.split("}");
        String strArray2 = strArray[0];
        System.out.println(strArray2);
        String[] strArray3 = strArray2.split(",");
        System.out.println(strArray3[0]);
        assertThat("Number of book attributes should be equal to 4", strArray3, arrayWithSize(4));
        System.out.println("Number of book attributes is : " + strArray3.length);


        int statusCode = responseBody.getStatusCode();
        //dva nacina asertacije:
        Assert.assertEquals(statusCode, 200 );
        assertTrue(responseBody.getStatusCode()==200);
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
        assertThat(available, equalTo(true));
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

    @Test
    public void getFirstBook() {

        Response responseBody=  given()
                .when()
                .get("https://simple-books-api.glitch.me/books/1")
                .then().extract().response();


        JsonPath jsonPath=responseBody.jsonPath();
        //JsonPath toString = new JsonPath(responseBody.asString());
        String firstBookAsString = responseBody.asString();
        String[] strArray = firstBookAsString.split(",");

        System.out.println(firstBookAsString);
        System.out.println(strArray[0]);

        assertThat("Number of book attributes should be equal to 8", strArray, arrayWithSize(8));



        //status
        int statusCode = responseBody.getStatusCode();
        Assert.assertEquals(statusCode, 200 );
        System.out.println("Status code received from Response is : " + statusCode);

        //id
        Integer id = jsonPath.get("id");
        System.out.println("ID is " + id);
        assertTrue("Id is correct", id == 1);
        System.out.println("Id received from Response is : " + id);

        //name
        assertThat("Name value.", jsonPath.get("name"), equalTo("The Russian"));
        String name = jsonPath.get("name");
        System.out.println("Name received from Response is : " + name);

        //author
        assertThat("Author value.", jsonPath.get("author"), equalTo("James Patterson and James O. Born"));
        String author = jsonPath.get("author");
        System.out.println("Author received from Response is : " + author);

        //isbn
        assertThat("Isbn value.", jsonPath.get("isbn"), equalTo("1780899475"));
        String isbn = jsonPath.get("isbn");
        System.out.println("Isbn received from Response is : " + isbn);


        //type
        assertThat("Type value.", jsonPath.get("type"), equalTo("fiction"));
        String type = jsonPath.get("type");
        System.out.println("Type received from Response is : " + type);

        //price
        Float price = jsonPath.get("price");
        assertEquals(12.98,price,0.01);
        System.out.println("Price received from Response is : " + price);


        // current-stock
        Integer currentStock = jsonPath.get("current-stock");
        assertTrue("Current Stock is correct", currentStock == 12);
        System.out.println("Current Stock received from Response is : " + currentStock);

        //available
        Boolean available = jsonPath.getBoolean("available");
        Assert.assertEquals(true,available);
        System.out.println("Availability received from Response is : " + available);

    }

    @Test
    public void hamcrestAssert(){

        List<String> allBooksName = jsonPath.getList("name");
        System.out.println("All Books Names : " + allBooksName);
        assertThat(allBooksName, hasSize(6));
        System.out.println("Number of all books names : " +allBooksName.size());

        assertThat(allBooksName, hasItems("Just as I Am"));


        List<String> allBooksType = jsonPath.getList("type");
        assertThat(allBooksType, hasItems("fiction"));
        assertThat(booksAsString, containsString("fiction"));
        assertThat(allBooksType, containsInAnyOrder("fiction","fiction","fiction","fiction","non-fiction","non-fiction") );

    }

    @Test
    public void hashMaps(){
        ResponseDataReaderHelper rdrh = new ResponseDataReaderHelper(jsonPath);
        String name = rdrh.name.get("Book3");
        System.out.println(name);
        Integer id = rdrh.id.get("Book3");
        System.out.println(id);
        Boolean available = rdrh.available.get("Book3");
        System.out.println(available);
        String type = rdrh.type.get("Book3");
        System.out.println(type);

    }

}