package tng3.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.api.entity.APIResponse;
import tng3.api.entity.Profile;
import tng3.api.helper.Method;
import tng3.api.helper.Utils;

import java.util.LinkedHashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileTest extends BaseTest {

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



    @Test
    public void postProfileWithBadLastName(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.lastName=utils.generateString(41);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(101));
    }



    @Test
    public void postProfileWithBadFirstName(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.firstName=utils.generateString(41);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(102));
    }


    @Test
    public void postProfileWithBadSecondName(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.secondName=utils.generateString(41);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(103));
    }



    @Test
    public void postProfileWithBadGender(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.gender="Q";

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(104));
    }



    @Test
    public void postProfileWithBadCountry(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.country=utils.generateString(21);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(106));
    }



    @Test
    public void postProfileWithBadZipCode(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.zipCode=utils.generateString(11);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(107));
    }



    @Test
    public void postProfileWithBadStreetAddress(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.streetAddress=utils.generateString(101);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(108));
    }



    @Test
    public void postProfileWithBadSCity(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.city=utils.generateString(51);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(109));
    }



    @Test
    public void postProfileWithBadPhone(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.phone=utils.generateString(51);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(110));
    }



    @Test
    public void postProfileWithBadCellPhone(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.cellPhone=utils.generateString(51);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(111));
    }



    @Test
    public void postProfileWithBadEmail(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.email=utils.generateString(51);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(112));
    }



    @Test
    public void postProfileWithBadNotes(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.notes=utils.generateString(1001);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(113));
    }



    @Test
    public void postProfileWithBadCompany(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.company=utils.generateString(101);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(114));
    }



    @Test
    public void postProfileWithBadJobTitle(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.jobTitle=utils.generateString(31);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(115));
    }



    @Test
    public void postProfileWithBadPassport(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.passport=utils.generateString(101);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(116));
    }



    @Test
    public void postProfileWithBadUDFS1(){
        APIResponse response = utils.go(endpoint, Method.GET);
        assertThat(response.getSuccess(), equalTo(true));

            Profile profile = new Profile((LinkedHashMap<String, Object>) response.getPayload());
            profile.udfs1=utils.generateString(1001);

                response = utils.go(endpoint, Method.POST, profile);
                assertThat(response.getSuccess(), equalTo(false));
                assertThat(utils.getErrorCode(response.getError()), equalTo(118));
    }




    @Autowired
    private Utils utils;
}
