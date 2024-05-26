package org.example;

import com.fasterxml.uuid.Generators;
import io.cucumber.java.en.Given;
import org.hamcrest.core.Is;
import org.json.JSONObject;

import java.util.Arrays;

import static io.restassured.RestAssured.*;


public class SwaggerPetStore {

    final String HOST = "petstore3.swagger.io";
    final String URL = String.format("https://%s/api/v3", HOST);
    final String TYPE = "application/json";

    public String bodyPost() {
        JSONObject json = new JSONObject();
        json.put("id", 10);
        json.put("name", "doggie");

        JSONObject category = new JSONObject();
        category.put("id", 1);
        category.put("name", "Dogs");

        json.put("category", category);
        json.put("photoUrls", Arrays.asList("string"));

        JSONObject tags = new JSONObject();
        tags.put("id", 0);
        tags.put("name", "string");
        json.put("tags", Arrays.asList(tags));

        json.put("status", "available");

        return json.toString();
    }

    @Given("firstTry")
    public void firstTry() {

        baseURI = String.format("%s/pet", URL);

        String UUID4 = Generators.timeBasedGenerator().generate().toString();
        String token = String.format("Bearer %s", UUID4);

        given()
                .header("accept", TYPE)
                .header("Authorization", token)
                .header("Content-Type", TYPE)
                .header("Host", HOST)
                .body(bodyPost())
                .post().then().statusCode(200)
                .log().all()
                .assertThat().body("name", Is.is("doggie"));
    }
}
