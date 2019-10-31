package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.config.Config;
import tng3.api.entity.APIResponse;
import tng3.api.helper.Method;
import tng3.api.helper.Utils;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class DocTest extends BaseTest {

    private final String endpoint = "/docs";


    @Test
    public void getDocs(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", config.offset);
            additional.put("count", config.count);

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getDocsByAccount(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", config.offset);
            additional.put("count", config.count);
            additional.put("account", config.account);

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getDocsByFromTill(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", config.offset);
            additional.put("count", config.count);
            additional.put("from", utils.generateDate("dd.MM.YYYY", -30));
            additional.put("till", utils.generateDate("dd.MM.YYYY", 0));

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getDocsWithBadOffset(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", "-1");
            additional.put("count", config.count);
            additional.put("from", utils.generateDate("dd.MM.YYYY", -30));
            additional.put("till", utils.generateDate("dd.MM.YYYY", 0));

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(0));
                assertThat(utils.getErrorMessage(response.getError()), equalTo("Bad offset"));
    }


    @Test
    public void getDocsWithBadCount(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", config.offset);
            additional.put("count", "0");
            additional.put("from", utils.generateDate("dd.MM.YYYY", -30));
            additional.put("till", utils.generateDate("dd.MM.YYYY", 0));

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(0));
                assertThat(utils.getErrorMessage(response.getError()), equalTo("Bad count"));
    }





    @Autowired
    private Utils utils;

    @Autowired
    private Config config;
}
