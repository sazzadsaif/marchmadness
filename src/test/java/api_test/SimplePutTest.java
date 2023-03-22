package api_test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimplePutTest extends BaseApiClass {
    @Test
    public void updateExistingAllUserValue() {
        //LOGGER.info("----API Test : Update existing user------");

        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String jobTitle = faker.job().title();
        //LOGGER.debug("Name is " + fullName);
        //LOGGER.debug("Title is " + jobTitle);

        JSONObject reqBody = new JSONObject();
        reqBody.put("name", fullName);
        reqBody.put("job", jobTitle);

        httpRequest.header("Content-type", "application/json");
        httpRequest.body(reqBody.toJSONString());

        String id = "2";

        Response response = httpRequest.request(Method.PUT,id);
        //LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200);

        JsonPath jsonPath = response.jsonPath();
        String actualName = jsonPath.getString("name");

        Assert.assertEquals(actualName, fullName);

    }
}
