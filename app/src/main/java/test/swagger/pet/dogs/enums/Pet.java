package test.swagger.pet.dogs.enums;

public enum Pet {
    ID("id"),
    NAME("name"),
    CATEGORY("category"),
    PHOTO_URLS("photoUrls"),
    TAGS("tags"),
    STATUS("status");

    public final String label;

    Pet(String label) {
        this.label = label;
    }
}
