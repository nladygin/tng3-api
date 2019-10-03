package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"data.properties"})
public class ClassTest extends BaseTest {

    private final String endpoint = "/classes";


    @Test
    public void getClasses(){
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
