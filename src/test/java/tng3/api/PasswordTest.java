package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Profile;
import tng3.api.entity.Raw;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class PasswordTest extends BaseTest {

    @Autowired
    private Profile profile;

    @Autowired
    private Utils utils;

    private final String endpoint = "/profile/password";


    @Test
    public void changePassword(){
        APIResponse response = utils.go(endpoint, Method.POST, new Raw(profile.password));
        assertThat(response.getSuccess(), equalTo(true));
    }

    @Test
    public void getPassword(){
        APIResponse response = utils.go(endpoint, Method.PUT, new Raw(profile.email));
        assertThat(response.getSuccess(), equalTo(true));
    }

}
