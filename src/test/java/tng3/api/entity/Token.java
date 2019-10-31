package tng3.api.entity;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.helper.Utils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;


@Component
public class Token {

    @Autowired private Credentials credentials;

    @Autowired private Utils utils;

    private final Logger log = LogManager.getLogger();

    private final String endpoint = "/signin";

    private String sessionID;



    public String getSessionID() {
        if (sessionID == null) {
            String url = utils.makeURL(endpoint);
            RequestSpecification requestSpecification =
                    given()
                            .contentType(ContentType.JSON)
                            .body(credentials.asJsonString());
            Response response = requestSpecification.post(url);
            APIResponse resp = response
                    .then()
                    .statusCode(SC_OK)
                    .extract()
                    .as(APIResponse.class);
            if (resp.getSuccess()) {
                sessionID = ((HashMap<String,String>) resp.getPayload()).get("session");
            }
            log.info("session id: " + sessionID);
        }
        return sessionID;
    }



    public Token(){}

}
