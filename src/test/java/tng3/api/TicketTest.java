package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class TicketTest extends BaseTest {

    private final String endpoint = "/tickets";




    @Test
    public void getTickets(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void replaceTicket(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            String originalCode = (String) (
                    (HashMap<String, Object>)
                            ((ArrayList)
                                    (response.getPayload())).get(0)
                    ).get("number");

                        HashMap<String, String> additional = new HashMap<>();
                            additional.put("empl", config.emplMagstripe);

                            response = utils.go(endpoint + "/replace/" + originalCode + "/" + utils.generateDigits(8), Method.POST, null, additional);
                            assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void replaceNonexistentTicket(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("empl", config.emplMagstripe);

                APIResponse response = utils.go(endpoint + "/replace/" + "666" + "/" + utils.generateDigits(8), Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(10));
    }


    @Test
    public void replaceTicketWithBadEmployee(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            String originalCode = (String) (
                    (HashMap<String, Object>)
                            ((ArrayList)
                                    (response.getPayload())).get(0)
            ).get("number");

                HashMap<String, String> additional = new HashMap<>();
                    additional.put("empl", utils.generateString(10));

        response = utils.go(endpoint + "/replace/" + originalCode + "/" + utils.generateDigits(8), Method.POST, null, additional);
        assertThat(response.getSuccess(), equalTo(false));
        assertThat(utils.getErrorCode(response.getError()), equalTo(10));
    }








    @Autowired
    private Utils utils;

    @Autowired
    private Config config;
}
