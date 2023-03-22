package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimpleDeleteTest extends BaseApiClass {
    @Test public void deleteSingleUser(){

        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        String id = "2";

        Response response = httpRequest.request(Method.DELETE,id);

        Assert.assertEquals(response.getStatusCode(),204);

    }
}
