package test.swagger.pet.dogs.enums;

public enum Tags {
    ID("id"),
    NAME("name");

    public final String label;

    Tags(String label) {
        this.label = label;
    }
}
