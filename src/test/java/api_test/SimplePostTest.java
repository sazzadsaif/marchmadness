package api_test;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SimplePostTest extends BaseApiClass {
    @Test
    public void createNewUser(){
        RestAssured.baseURI = "https://reqres.in/api/users";

        RequestSpecification httpRequest = RestAssured.given();

        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String jobTitle = faker.job().title();
        //LOGGER.debug("Name is " + fullName);
        //LOGGER.debug("Title is " + jobTitle);

        JSONObject reqBody = new JSONObject();
        reqBody.put("name",fullName);
        reqBody.put("job",jobTitle);

        httpRequest.header("Content-type","application/json");
        httpRequest.body(reqBody.toJSONString());

        Response response = httpRequest.request(Method.POST);
        //LOGGER.debug(response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(),201);

        JsonPath jsonPath = response.jsonPath();
        String actualName = jsonPath.getString("name");

        Assert.assertEquals(actualName,fullName);
    }
}
