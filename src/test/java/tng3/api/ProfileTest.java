package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Profile;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileTest extends BaseTest {

    @Autowired
    private Profile profile;

    @Autowired
    private Utils utils;

    private final String endpoint = "/profile";




    @Test
    public void putProfile(){
        APIResponse response = utils.go(endpoint, Method.PUT, profile);
        assertThat(response.getSuccess(), equalTo(false));
    }


    @Test
    public void getProfile(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void postProfile(){
        APIResponse response = utils.go(endpoint, Method.POST, profile);
        assertThat(response.getSuccess(), equalTo(true));
    }


}
