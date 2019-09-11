package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Account;
import tng3.api.entity.Ticket;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"data.properties"})
public class TicketTest extends BaseTest {

    @Autowired
    private Ticket ticket;

    @Autowired
    private Utils utils;

    @Value("${emplMagstripe}")
    private String emplMagstripe;


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
                        additional.put("empl", emplMagstripe);

                            response = utils.go(endpoint + "/replace/" + originalCode + "/" + originalCode + "01", Method.POST, null, additional);
                            assertThat(response.getSuccess(), equalTo(true));
    }

}
