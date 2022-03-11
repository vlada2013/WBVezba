package BooksApi;

import common.FileReaderHelper;
import io.restassured.http.ContentType;
import org.junit.Test;

import java.io.IOException;

import static io.restassured.RestAssured.*;

public class CreateOrder {
    private FileReaderHelper fr;

    public CreateOrder() throws IOException {
        fr = new FileReaderHelper("payload.json");
    }

    @Test
    public void createNewOrder() {

        //String payload1 = "{\"bookId\": 3,\n" +
        //        "  \"customerName\": \"John\"}";
        String payload = fr.Get();

        given().headers(
                        "Authorization",
                        "Bearer " + "e6ba949a9c95e5aa4a160252425182d166826648353c5df5198e3175c55b29a1",
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON)
                .when()
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post("https://simple-books-api.glitch.me/orders");
    }
}

