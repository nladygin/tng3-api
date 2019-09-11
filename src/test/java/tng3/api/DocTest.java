package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Account;
import tng3.api.entity.Doc;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource({"data.properties"})
public class DocTest extends BaseTest {

    @Autowired
    private Doc doc;

    @Autowired
    private Utils utils;

    @Value("${doc.offset}")
    private String offset;

    @Value("${doc.count}")
    private String count;

    @Value("${doc.account}")
    private String account;


    private final String endpoint = "/docs";


    @Test
    public void getDocs(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", offset);
            additional.put("count", count);
                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getDocsByAccount(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", offset);
            additional.put("count", count);
            additional.put("account",account);

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void getDocsByFromTill(){
        HashMap<String, String> additional = new HashMap<>();
            additional.put("offset", offset);
            additional.put("count",count);
            additional.put("from", utils.generateDate("dd.MM.YYYY", -30));
            additional.put("till", utils.generateDate("dd.MM.YYYY", 0));

                APIResponse response = utils.go(endpoint, Method.GET, null, additional);
                assertThat(response.getSuccess(), equalTo(true));
    }

}
