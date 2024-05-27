package test.swagger.pet;

import com.fasterxml.uuid.Generators;

public interface Swagger {
    String HOST = "petstore3.swagger.io";
    String URL = String.format("https://%s/api/v3", HOST);
    String TYPE = "application/json";
    String UUID4 = Generators.timeBasedGenerator().generate().toString();
    String token = String.format("Bearer %s", UUID4);
}
