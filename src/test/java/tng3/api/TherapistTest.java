package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Therapist;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"data.properties"})
public class TherapistTest extends BaseTest {

    @Autowired
    private Therapist therapist;

    @Autowired
    private Utils utils;

    @Value("${outlet_id}")
    private String outletID;


    private final String endpoint = "/therapist";


    @Test
    public void getTherapist(){
        HashMap<String, String> additional = new HashMap<>();
        additional.put("outlet_id", outletID);
            APIResponse response = utils.go(endpoint, Method.GET, null, additional);
            assertThat(response.getSuccess(), equalTo(true));
    }

}
