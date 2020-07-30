package tng3.guestapi.action;

import io.restassured.http.Method;
import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import tng3.base.APIResponse;
import tng3.base.Action;
import tng3.base.Entity;
import tng3.guestapi.entity.Profile;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class ProfileAction extends Action {

    private final String endpoint = "/api/profile";



    public APIResponse createProfile(Profile profile) {
        return requestHelper.go(endpoint, Method.PUT, profile, null);
    }


    public ProfileAction equalData(Entity source, Profile profile) {
        assertThat(profile.equals(source), CoreMatchers.equalTo(true));
        return this;
    }


    public APIResponse getProfile(){
        return requestHelper.go(endpoint, Method.GET, null, null);
    }


    public APIResponse editProfile(Profile profile) {
        return requestHelper.go(endpoint, Method.POST, profile, null);
    }


    public APIResponse getCreditCards() {
        return requestHelper.go(endpoint + "/creditcards", Method.GET, null, null);
    }


    public APIResponse deleteCreditCards(int id) {
        return requestHelper.go(endpoint + "/creditcards/" + id, Method.DELETE, null, null);
    }

    public APIResponse getLinkedProfile(){
        return requestHelper.go(endpoint + "/linked", Method.GET, null, null);
    }


}
