package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Account;
import tng3.api.entity.Doc;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class DocTest extends BaseTest {

    @Autowired
    private Doc doc;

    @Autowired
    private Utils utils;

    private final String endpoint = "/docs";


    @Test
    public void getDocs(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", "0");
            additional.put("count", "10");

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getDocsByAccount(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", "0");
            additional.put("count", "10");
            additional.put("account","DEPO");

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getDocsByFromTill(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", "0");
            additional.put("count", "10");
            additional.put("from","01.01.2019");
            additional.put("till","01.01.2100");

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }

}
