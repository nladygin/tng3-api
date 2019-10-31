package tng3.helper;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import tng3.api.config.AppConfig;
import tng3.api.config.Config;
import tng3.api.entity.APIResponse;
import tng3.base.Entity;
import tng3.api.entity.Token;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_OK;



@Component
@PropertySource({"data.properties"})
public class Utils {

    @Autowired
    private AppConfig appConfig;

    @Autowired
    private Token token;

    @Autowired
    private Config config;

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
                + "&lang=" + config.lang
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





    public Entity toEntity(String jsonString, Class cl){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            Entity entity = null;
            try {
                entity = (Entity) mapper.readValue(jsonString, cl);
            } catch (IOException e) {
                log.error(e.getStackTrace().toString());
            }

        return entity;
    }





    public String generateDate(String dateFormat, int dayShift){
        SimpleDateFormat f = new SimpleDateFormat(dateFormat);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, dayShift);
        return f.format( DateUtils.ceiling(cal.getTime(), Calendar.HOUR) );
    }





    public String generateDateMS(int dayShift){
        LocalDateTime localDateTime = LocalDateTime.parse(generateDate("dd.MM.YYYY HH:mm", dayShift),
                DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm") );
            long millis = localDateTime
                    .atZone(ZoneId.systemDefault())
                    .toInstant().toEpochMilli();
        return String.valueOf(millis);
    }





    public String generateString(){
        return generateString(5);
    }

    public String generateString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }






    public long generateDigits() {
        return generateDigits(10);
    }

    public long generateDigits(int length) {
        int m = (int) Math.pow(10, length-1);
        return Math.abs(m + new Random().nextInt(9 * m));
    }





    public int getErrorCode(Object error){
        return ((HashMap<String, Integer>) error).get("code");
    }

    public String getErrorMessage(Object error){
        return ((HashMap<String, String>) error).get("message");
    }






    public Utils(){}
}
