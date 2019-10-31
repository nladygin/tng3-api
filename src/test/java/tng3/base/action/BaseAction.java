package tng3.base.action;


import org.hamcrest.CoreMatchers;
import org.springframework.stereotype.Component;
import tng3.base.entity.APIResponse;

import static org.hamcrest.MatcherAssert.assertThat;

@Component
public class BaseAction {


    public BaseAction checkResponseSuccess(APIResponse apiResponse, boolean success){
        assertThat(apiResponse.getSuccess(), CoreMatchers.equalTo(success));
        return this;
    }

}
