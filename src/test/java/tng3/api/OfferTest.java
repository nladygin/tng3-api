package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Account;
import tng3.api.entity.Offer;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"data.properties"})
public class OfferTest extends BaseTest {

    @Autowired
    private Offer offer;

    @Autowired
    private Utils utils;

    @Value("${outlet_id}")
    private String outletID;

    @Value("${offer.offset}")
    private String offset;

    @Value("${offer.count}")
    private String count;

    @Value("${offer.id}")
    private String id;



    private final String endpoint = "/offers";


    @Test
    public void getOffers(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", outletID);
            additional.put("offset", offset);
            additional.put("count", count);

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getTherapistsForOffer(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", outletID);
            additional.put("offset", offset);
            additional.put("count", count);

                APIResponse response = utils.go(endpoint + "/" + id + "/therapists", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getAvailabilityForOffer(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", outletID);
            additional.put("offset", offset);
            additional.put("count", count);
            additional.put("from", utils.generateDate("ddMMYYYY", 0));
            additional.put("to", utils.generateDate("ddMMYYYY", 7));

                APIResponse response = utils.go(endpoint + "/" + id + "/availability", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getCapacityForOfferFrom(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", outletID);
            additional.put("offset", offset);
            additional.put("count", count);
            additional.put("from", utils.generateDate("dd.MM.YYYY HH:mm", 0));

                APIResponse response = utils.go(endpoint + "/" + id + "/capacity", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getCapacityForOfferFromMS(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", outletID);
            additional.put("offset", offset);
            additional.put("count", count);
            additional.put("from_ms", utils.generateDateMS(0));

                APIResponse response = utils.go(endpoint + "/" + id + "/capacity", Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }

}
