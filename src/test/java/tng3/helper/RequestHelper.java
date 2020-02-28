package tng3.helper;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.AppConfig;
import tng3.base.Entity;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.apache.http.HttpStatus.SC_OK;



@Component
public class RequestHelper {

    private String appId;
    private String sessionId;



    public RequestHelper setEnv(String appId, String sessionId) {
        this.appId = appId;
        this.sessionId = sessionId;
        return this;
    }


    private String makeURL(String endpoint, HashMap<String, String> additional, Boolean withSession){
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
                + "?app_id=" + appId
                + (withSession ? ((sessionId != null) ? "&session_id=" + sessionId: "") : "")
                + "&lang=" + appConfig.lang
                + additionalString;
    }



    public APIResponse go(String endpoint, Method method, Entity body, HashMap<String, String> additional){
        return go(endpoint, method, body, additional, true);
    }

    public APIResponse go(String endpoint, Method method, Entity body, HashMap<String, String> additional, Boolean withSession){
        String url = makeURL(endpoint, additional, withSession);
        LogManager.getLogger().info(method + " " + url);

        String b = (body != null) ? body.asJsonString() : "";
        RequestSpecification requestSpecification =
                given()
                        .contentType(ContentType.JSON)
                        .body(b);
        LogManager.getLogger().info("BODY: " + b);

        Response response = requestSpecification.request(method, url);
//        Response response = request(method, url);

        LogManager.getLogger().info("RESULT: " + response.getBody().asString());
        return response
                .then()
                .statusCode(SC_OK)
                .extract()
                .as(APIResponse.class);
    }






    @Autowired private AppConfig appConfig;
}
