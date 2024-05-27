package test.swagger.pet;

public enum Headers {
    ACCEPT("accept"),
    AUTHORIZATION("Authorization"),
    CONTENT_TYPE("Content-Type"),
    HOST("Host");

    public final String label;

    Headers(String label) {
        this.label = label;
    }
}
