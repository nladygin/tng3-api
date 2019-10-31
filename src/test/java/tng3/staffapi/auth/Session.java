package tng3.staffapi.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;

import java.io.File;
import java.io.IOException;


@Component
public class Session {

    private String id;



    public Session() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("staffapi-auth.json").getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        APIResponse response = objectMapper.readValue(file, APIResponse.class);
        this.id = (String) response.getPayload();
    }


    public String getId() {
        return id;
    }
}
