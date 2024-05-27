package test.swagger.pet;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.hamcrest.core.Is;

import static io.restassured.RestAssured.*;
import static test.swagger.pet.Swagger.*;
import static test.swagger.pet.dogs.requested_body.RequestedBodyPetJson.*;

public class SwaggerPet {

    private final String NAME = "name";
    private final String STATUS = "status";
    private final String CATEGORY_NAME = "category.name";

    @Given("the fact that the dog {string} must be created with id {string}")
    public void theFactThatTheDogMustBeCreatedWithId(String pet, String idString) {
        int id = Integer.parseInt(idString);
        baseURI = String.format("%s/pet", URL);

        given()
                .header(Headers.ACCEPT.label, TYPE)
                .header(Headers.AUTHORIZATION.label, token)
                .header(Headers.CONTENT_TYPE.label, TYPE)
                .header(Headers.HOST.label, HOST)
                .body(bodyPost(pet, id))
                .post().then().statusCode(200)
                .assertThat()
                .body(NAME, Is.is(pet))
                .body(STATUS, Is.is("available"))
                .body(CATEGORY_NAME, Is.is("Dogs"));

    }

    @When("the dog {string} with id {string} has been created correctly")
    public void theDogWithIdHasBeenCreatedCorrectly(String pet, String idString) {
        int id = Integer.parseInt(idString);
        baseURI = String.format("%s/pet/%s", URL, id);

        given()
                .header(Headers.ACCEPT.label, TYPE)
                .header(Headers.AUTHORIZATION.label, token)
                .header(Headers.CONTENT_TYPE.label, TYPE)
                .header(Headers.HOST.label, HOST)
                .when().get().then()
                .assertThat()
                .body(NAME, Is.is(pet))
                .body(STATUS, Is.is("available"))
                .body(CATEGORY_NAME, Is.is("Dogs"));
    }


    @And("the data of dog with id {string} with a new name {string} has been updated successfully")
    public void theDataOfDogWithIdWithANewNameHasBeenUpdatedSuccessfully(String idString, String newName) {
        int id = Integer.parseInt(idString);
        baseURI = String.format("%s/pet", URL);

        String fakeUrl = Faker.instance().internet().url();

        given()
                .header(Headers.ACCEPT.label, TYPE)
                .header(Headers.AUTHORIZATION.label, token)
                .header(Headers.CONTENT_TYPE.label, TYPE)
                .header(Headers.HOST.label, HOST)
                .body(body(newName, id, fakeUrl))
                .put().then().statusCode(200)
                .assertThat()
                .body(NAME, Is.is(newName))
                .body(STATUS, Is.is("available"))
                .body(CATEGORY_NAME, Is.is("Dogs"));
    }

    @Then("the dog with {string} should be deleted without any problems")
    public void theDogWithShouldBeDeletedWithoutAnyProblems(String idString) {
        int id = Integer.parseInt(idString);
        baseURI = String.format("%s/pet/%s", URL, id);

        given()
                .header(Headers.ACCEPT.label, TYPE)
                .header(Headers.AUTHORIZATION.label, token)
                .header(Headers.CONTENT_TYPE.label, TYPE)
                .header(Headers.HOST.label, HOST)
                .delete().then().statusCode(200)
                .assertThat()
                .body(Is.is("Pet deleted"));
    }
}
