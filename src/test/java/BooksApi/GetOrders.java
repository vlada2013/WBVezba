package BooksApi;

import common.FileReaderHelper;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetOrders {
    private FileReaderHelper fr;

    public GetOrders() throws IOException {
        fr = new FileReaderHelper("payload.json");
    }

    @Test
    public void getAllOrders() {

        Response responseBody=  given().headers(
                        "Authorization",
                        "Bearer " + "4c01afc0db6a11b6ecb3a027a1e816008bfbe399c339bc08bc5c8eede18759c8",
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .get("https://simple-books-api.glitch.me/orders")
                .then().extract().response();

        JsonPath jsonPath=responseBody.jsonPath();
        JsonPath toString = new JsonPath(responseBody.asString());
        int numberOfAllOrders = toString.getInt("data.size()");
        String ordersAsString = responseBody.asString();

        System.out.println(ordersAsString.length());
        System.out.println("Number of all order is : " + numberOfAllOrders);


        int statusCode = responseBody.getStatusCode();
        Assert.assertEquals(statusCode, 200 );
        System.out.println("Status code received from Response is : " + statusCode);

        //first Order

        //id number
        assertThat("id value.", jsonPath.get("id[0]"), equalTo("aRMWH4fYwJXYsjIWVmH_n"));
        String id = jsonPath.get("id[0]");
        System.out.println("First order ID info: ");
        System.out.println("ID received from Response is : " + id);


        //BookId
        assertThat("bookId value.", jsonPath.get("bookId[0]"), equalTo(6));
        Integer bookId = jsonPath.get("bookId[0]");
        System.out.println("The Book ID received from Response is : " + bookId);

        //CustomerName
        assertThat("customerName value.", jsonPath.get("customerName[0]"), equalTo("Sladja"));
        String customerName = jsonPath.get("customerName[0]");
        System.out.println("The first made by the following customer : " + customerName);

        //quantity
        assertThat("quantity value.", jsonPath.get("quantity[0]"), equalTo(1));
        Integer quantity = jsonPath.get("quantity[0]");
        System.out.println("The quantity made by this customer is : " + quantity);

        //timestamp
        assertThat("timestamp value.", jsonPath.get("timestamp[0]"), equalTo(1647282460262L));
        Long timestamp = jsonPath.get("timestamp[0]");
        System.out.println("The oder hav the following timestamp : " + timestamp);

    }
}
