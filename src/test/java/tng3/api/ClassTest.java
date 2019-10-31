package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.config.Config;
import tng3.api.entity.APIResponse;
import tng3.api.entity.BookingComment;
import tng3.helper.Method;
import tng3.helper.Utils;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"data.properties"})
public class ClassTest extends BaseTest {

    private final String endpoint = "/api/classes";


    @Test
    public void getClasses(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("outlet_id", String.valueOf(config.outletID));

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void subscribeClasses(){
        HashMap<String, String> additional = new HashMap<>();
//            additional.put("verbose", String.valueOf(true));

                APIResponse response = utils.go(endpoint + "/" + config.classID + "/subscribe", Method.POST, null, additional);
                assertThat(response.getSuccess(), equalTo(true));

                    int bookingID = (int) response.getPayload();

                        response = utils.go( "/api/bookings/" + bookingID, Method.DELETE, bookingComment);
                        assertThat(response.getSuccess(), equalTo(true));
    }









    private BookingComment bookingComment = new BookingComment();

    @Autowired
    private Utils utils;

    @Autowired
    private Config config;
}
