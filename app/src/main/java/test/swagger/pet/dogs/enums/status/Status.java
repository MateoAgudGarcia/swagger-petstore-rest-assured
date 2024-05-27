package test.swagger.pet.dogs.enums.status;

public enum Status {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    public final String label;

    Status(String label) {
        this.label = label;
    }
}
