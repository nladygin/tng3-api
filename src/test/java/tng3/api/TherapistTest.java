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
public class TherapistTest extends BaseTest {

    private final String endpoint = "/therapist";



    @Test
    public void getTherapist(){
        HashMap<String, String> additional = new HashMap<>();
        additional.put("outlet_id", String.valueOf(config.outletID));

            APIResponse response = utils.go(endpoint, Method.GET, null, additional);
            assertThat(response.getSuccess(), equalTo(true));
    }





    @Autowired
    private Utils utils;

    @Autowired
    private Config config;
}
