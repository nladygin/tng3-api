package tng3.base;


import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class Action {


    public Action checkResponseSuccess(APIResponse apiResponse, boolean success){
        assertThat(apiResponse.getSuccess(), CoreMatchers.equalTo(success));
        return this;
    }


    public Action checkResponseErrorCode(APIResponse response, int expected) {
        assertThat(response.getErrorCode(), CoreMatchers.equalTo(expected));
        return this;
    }


}
