package tng3.staffapi.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;


@Component
public class Session {

    private String staffAPISession;
    private String guestAPISession;



    public Session() throws IOException {
        this.staffAPISession = (String) loadToken("staffapi-auth.json");
        this.guestAPISession = ((HashMap<String, String>) loadToken("guestapi-auth.json")).get("session");
    }


    private Object loadToken(String jsonFile) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(jsonFile).getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        APIResponse response = objectMapper.readValue(file, APIResponse.class);
        return response.getPayload();
    }


    public String getGuestId() {
        return guestAPISession;
    }


    public String getStaffId() {
        return staffAPISession;
    }

}
