package tng3.base;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.logging.log4j.LogManager;

import java.io.IOException;

public interface Entity {

    default String asJsonString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = null;
        try {
            json = mapper.writeValueAsString(this);
        } catch (IOException e) {
            LogManager.getLogger().error(e.getStackTrace());
        }
        return json;
    }
}
