package test.swagger.pet.dogs.enums;

public enum Category {
    ID("id"),
    NAME("name");

    public final String label;

    Category(String label) {
        this.label = label;
    }
}
