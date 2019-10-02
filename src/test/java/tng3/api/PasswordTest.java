package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Profile;
import tng3.api.entity.Raw;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class PasswordTest extends BaseTest {

    private final String endpoint = "/profile/password";
    private final String endpointGet = "/profile";



    @Test
    public void changePassword(){
        APIResponse response = utils.go(endpointGet, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());

                response = utils.go(endpoint, Method.POST, new Raw(profile.password));
                assertThat(response.getSuccess(), equalTo(true));
    }



    @Test
    public void changePasswordWithEmpty(){
        APIResponse response = utils.go(endpoint, Method.POST, new Raw(""));
        assertThat(response.getSuccess(), equalTo(false));
        assertThat(utils.getErrorCode(response.getError()), equalTo(162));
    }



    @Test
    public void getPassword(){
        APIResponse response = utils.go(endpointGet, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());

                response = utils.go(endpoint, Method.PUT, new Raw(profile.email));
                assertThat(response.getSuccess(), equalTo(true));
    }




    @Autowired
    private Utils utils;
}
