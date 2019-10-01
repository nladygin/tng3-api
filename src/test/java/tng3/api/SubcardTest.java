package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Subcard;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class SubcardTest extends BaseTest {

    @Autowired
    private Utils utils;

    private final String endpoint = "/profile/subcards";


    @Test
    public void getSubcards(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void addEditDeleteSubcard(){
        Subcard subcard = new Subcard();

            APIResponse response = utils.go(endpoint, Method.POST, subcard);
            assertThat(response.getSuccess(), equalTo(true));

                int id = ((HashMap<String,Integer>) response.getPayload()).get("id");

                    response = utils.go(endpoint + "/" + id, Method.POST, subcard);
                    assertThat(response.getSuccess(), equalTo(true));

                        response = utils.go(endpoint + "/" + id, Method.DELETE, subcard);
                        assertThat(response.getSuccess(), equalTo(true));
    }


}
