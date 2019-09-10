package tng3.api;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Entity;
import tng3.api.entity.Token;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;

@Component
public class Utils {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private Token token;

    private final Logger log = LogManager.getLogger();





    public String makeURL(String endpoint){
        return makeURL(endpoint, null, null);
    }

    public String makeURL(String endpoint, String token){
        return makeURL(endpoint, token, null);
    }


    public String makeURL(String endpoint, String token, HashMap<String, String> additional){
        String additionalString = "";
        if (additional != null) {
            for (String key : additional.keySet()) {
                additionalString += "&"
                        + key
                        + "="
                        + additional.get(key);
            }

        }
        return appConfig.serverURL
                + endpoint
                + "?app_id=" + appConfig.appID
                + "&lang=" + appConfig.lang
                + ((token != null) ? "&session_id=" + token : "")
                + additionalString;
    }



    public APIResponse go(String endpoint, Method method){
        return go(endpoint,method,null);
    }

    public APIResponse go(String endpoint, Method method, Entity body){
        return go(endpoint,method,body,null);
    }


    public APIResponse go(String endpoint, Method method, Entity body, HashMap<String, String> additional){
        String url = makeURL(endpoint, token.getSessionID(), additional);
        log.info(method + " " + url);

        String b = (body != null) ? body.asJsonString() : "";
        RequestSpecification requestSpecification =
                given()
                        .contentType(ContentType.JSON)
                        .body(b);
        log.info("BODY: " + b);

        Response response = null;
        switch (method) {
            case GET:       response = requestSpecification.get(url); break;
            case POST:      response = requestSpecification.post(url); break;
            case PUT:       response = requestSpecification.put(url); break;
            case DELETE:    response = requestSpecification.delete(url); break;
        }

        log.info("RESULT: " + response.getBody().asString());
        return response
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(APIResponse.class);
    }


    public String generateSalt(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return dateFormat.format( new Date() );
    }










    public Utils(){}
}
