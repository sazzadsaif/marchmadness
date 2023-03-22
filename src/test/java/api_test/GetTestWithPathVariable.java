package api_test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetTestWithPathVariable extends BaseApiClass {
    @Test
    public void getSingleUser() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification httpRequest = RestAssured.given();

        String id = "2";

        Response response = httpRequest.request(Method.GET, id);
        LOGGER.debug(response.getBody().asString());
        LOGGER.debug(response.getBody().prettyPrint());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        String actualEmailId = jsonPath.get("data.email");
        String expectedEmailId = "janet.weaver@reqres.in";

        Assert.assertEquals(expectedEmailId, actualEmailId);
    }
    @Test
    public void attemptToGetUserWithInvalidId() {

            RestAssured.baseURI = "https://reqres.in/api/users";
            RequestSpecification httpRequest = RestAssured.given();

            String id = "23";

            Response response = httpRequest.request(Method.GET, id);
            LOGGER.debug(response.getBody().asString());
            LOGGER.debug(response.getBody().prettyPrint());

            Assert.assertEquals(response.getStatusCode(), 404);

            JsonPath jsonPath = response.jsonPath();

            String actualBodyContent = jsonPath.get().toString();

            String expectedBodyContent = "{}";

            Assert.assertEquals(expectedBodyContent,actualBodyContent);

    }
    }

