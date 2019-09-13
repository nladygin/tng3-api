package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Profile;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileTest extends BaseTest {


    @Autowired
    private Utils utils;

    private final String endpoint = "/profile";




    @Test
    public void putProfile(){
        Profile profile = new Profile();
        APIResponse response = utils.go(endpoint, Method.PUT, profile);
        assertThat(response.getSuccess(), equalTo(true));
        assertThat(profile.equals(
                new Profile(
                        (LinkedHashMap<String, Object>) response.getPayload()
                )), equalTo(true));
    }


    @Test
    public void putProfileWithExistedEmail(){
        Profile profile = new Profile();
        String email = profile.email;

            APIResponse response = utils.go(endpoint, Method.PUT, profile);
            assertThat(response.getSuccess(), equalTo(true));

                Profile profileDouble = new Profile(0,null,null,null,null,null,null,null,null,null,null,null,email,null,null,null,null,null,null,null,null,null,null,null,null);

                    response = utils.go(endpoint, Method.PUT, profileDouble);
                    assertThat(response.getSuccess(), equalTo(false));
                    assertThat(utils.getErrorCode(response.getError()), equalTo(121));
    }



    @Test
    public void putProfileWithExistedPhone(){
        Profile profile = new Profile();
        String cellPhone = profile.cellPhone;

            APIResponse response = utils.go(endpoint, Method.PUT, profile);
            assertThat(response.getSuccess(), equalTo(true));

                Profile profileDouble = new Profile(0,null,null,null,null,null,null,null,null,null,null,cellPhone,null,null,null,null,null,null,null,null,null,null,null,null,null);

                    response = utils.go(endpoint, Method.PUT, profileDouble);
                    assertThat(response.getSuccess(), equalTo(false));
                    assertThat(utils.getErrorCode(response.getError()), equalTo(122));
    }



    @Test
    public void getProfile(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));
    }


    @Test
    public void postProfile(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(true));
                assertThat(profile.equals(
                        new Profile(
                                (LinkedHashMap<String, Object>) response.getPayload()
                        )), equalTo(true));
    }


}
