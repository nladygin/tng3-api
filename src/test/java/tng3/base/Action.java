package tng3.base;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.apache.logging.log4j.LogManager;
import org.hamcrest.CoreMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.helper.RequestHelper;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class Action {


    public Action checkResponseSuccess(APIResponse apiResponse, boolean success){
        assertThat(apiResponse.getSuccess(), CoreMatchers.equalTo(success));
        return this;
    }


    public Action checkResponseErrorCode(APIResponse response, int expected) {
        assertThat(response.getErrorCode(), CoreMatchers.equalTo(expected));
        return this;
    }


    public Action validateResponsePayload(APIResponse response, Class cl, boolean isList) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            String json = mapper.writeValueAsString(response.getPayload());
            if (isList) {
                CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, cl);
                mapper.readValue(json, type);
                assertThat(true, CoreMatchers.equalTo(true));
            } else {
                mapper.readValue(json, cl);
                assertThat(true, CoreMatchers.equalTo(true));
            }
        } catch (IOException e) {
            assertThat(false, CoreMatchers.equalTo(true));
            LogManager.getLogger().error(e.getStackTrace().toString());
        }
        return this;
    }


    public Action checkResponsePayloadIsEmptyList(APIResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            String json = mapper.writeValueAsString(response.getPayload());
            CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Object.class);
            List<Object> objects = mapper.readValue(json, type);
            assertThat(objects.size(), CoreMatchers.equalTo(0));
        } catch (IOException e) {
            assertThat(true, CoreMatchers.equalTo(false));
            LogManager.getLogger().error(e.getStackTrace().toString());
        }

        return this;
    }


    public Action checkResponsePayloadIsEmpty(APIResponse response) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            String json = mapper.writeValueAsString(response.getPayload());
            Object objects = mapper.readValue(json, Object.class);
            assertThat(objects, CoreMatchers.equalTo(null));
        } catch (IOException e) {
            assertThat(true, CoreMatchers.equalTo(false));
            LogManager.getLogger().error(e.getStackTrace().toString());
        }

        return this;
    }

/*
    public Action validateResponsePayload(APIResponse response, Object type){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            mapper.readValue(response.getPayload().toString(), (TypeReference) type);
//            mapper.readValue(response.getPayload().toString(), cl);
            assertThat(true, CoreMatchers.equalTo(true));
        } catch (IOException e) {
            assertThat(true, CoreMatchers.equalTo(false));
            LogManager.getLogger().error(e.getStackTrace().toString());
        }

        return this;
    }
*/


    @Autowired protected RequestHelper requestHelper;
}
