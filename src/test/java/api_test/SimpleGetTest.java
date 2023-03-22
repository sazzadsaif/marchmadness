package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SimpleGetTest extends BaseApiClass {
    @Test
    public void getAllUsers(){
        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET);
        LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(),200);

        JsonPath jsonPath = response.jsonPath();
        List<String> list = jsonPath.get("data.email");
        String expectedEmail = "george.bluth@reqres.in";
        boolean emailExist = list.contains(expectedEmail);
        Assert.assertTrue(emailExist,expectedEmail + " Does not exist ");
    }
}
