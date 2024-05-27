package test.swagger.pet.dogs.requested_body;

import org.json.JSONObject;
import test.swagger.pet.dogs.enums.*;
import test.swagger.pet.dogs.enums.status.Status;

import java.util.Collections;
import java.util.List;

public class RequestedBodyPetJson {
    public static String body(String pet, int id, String url) {
        JSONObject json = new JSONObject();
        json.put(Pet.ID.label, id);
        json.put(Pet.NAME.label, pet);

        JSONObject category = new JSONObject();
        category.put(Category.ID.label, 1);
        category.put(Category.NAME.label, "Dogs");

        json.put(Pet.CATEGORY.label, category);
        json.put(Pet.PHOTO_URLS.label, Collections.singletonList(url));

        JSONObject tags = new JSONObject();
        tags.put(Tags.ID.label, 0);
        tags.put(Tags.NAME.label, "string");
        json.put(Pet.TAGS.label, List.of(tags));

        json.put(Pet.STATUS.label, Status.AVAILABLE.label);

        return json.toString();
    }

    public static String bodyPost(String pet, int id) {
        return body(pet, id, "string");
    }
}
