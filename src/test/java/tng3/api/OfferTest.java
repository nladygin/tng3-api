package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class OfferTest extends BaseTest {

    private final String endpoint = "/offers";



    @Test
    public void getOffers(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("offset", config.offset);
            additional.put("count", config.count);

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getTherapistsForOffer(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("offset", config.offset);
            additional.put("count", config.count);

                APIResponse response = utils.go(endpoint + "/" + config.offerID + "/therapists", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getAvailabilityForOffer(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("offset", config.offset);
            additional.put("count", config.count);
            additional.put("from", utils.generateDate("ddMMYYYY", 0));
            additional.put("to", utils.generateDate("ddMMYYYY", 7));

                APIResponse response = utils.go(endpoint + "/" + config.offerID + "/availability", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getAvailabilityWithTherapistForOffer(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("therapist_id", config.therapistID);
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("offset", config.offset);
            additional.put("count", config.count);
            additional.put("from", utils.generateDate("ddMMYYYY", 0));
            additional.put("to", utils.generateDate("ddMMYYYY", 7));

                APIResponse response = utils.go(endpoint + "/" + config.offerID + "/availability", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getCapacityForOfferFrom(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("offset", config.offset);
            additional.put("count", config.count);
            additional.put("from", utils.generateDate("dd.MM.YYYY HH:mm", 0));

                APIResponse response = utils.go(endpoint + "/" + config.offerID + "/capacity", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getCapacityForOfferFromMS(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));
            additional.put("offset", config.offset);
            additional.put("count", config.count);
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint + "/" + config.offerID + "/capacity", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }







    @Autowired
    private Utils utils;

    @Autowired
    private Config config;
}
