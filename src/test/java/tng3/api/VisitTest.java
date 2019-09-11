package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Visit;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class VisitTest extends BaseTest {

    @Autowired
    private Visit visit;

    @Autowired
    private Utils utils;

    private final String endpoint = "/visit";


    @Test
    public void getSpaVisits(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));
    }

    @Test
    public void getHotelVisits(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("hotel", "1");

                APIResponse response = utils.go(endpoint, Method.GET);
                assertThat(response.getSuccess(), equalTo(true));
    }

}
