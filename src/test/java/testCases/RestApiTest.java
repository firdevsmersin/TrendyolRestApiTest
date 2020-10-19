package testCases;

import io.restassured.http.ContentType;

import org.junit.Before;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



public class RestApiTest {
    final static String ROOT_URI = " http://localhost:3000/api/book";
    @Before
    public  void StartWithEmptyStore(){

    }
    @Test(priority = 1)
    public void ListOfAllBooksSuccessfully() {

        given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
        .when()
                .get(ROOT_URI)
        .then()
                .statusCode(200)
                .log().body();
    }
    @Test(priority = 2)
    public void PutRequestExistingWithBookId(){
        Integer existingId = 1;
        given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().body()
        .when()
                .get(ROOT_URI+"/"+existingId)
        .then()
                .log().body()
                .statusCode(200)
                .body("id", equalTo(existingId));
    }
    @Test(priority = 3)
    public void PutRequestNonExistingWithBookId(){
        Integer nonExistingId = 2;
        given().
                contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .log().body()
                .when()
                .get(ROOT_URI+"/"+nonExistingId)
                .then().statusCode(400);
    }
}

