package tng3.guestapi;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import tng3.auth.Session;
import tng3.base.Data;
import tng3.guestapi.config.Config;
import tng3.helper.RequestHelper;
import tng3.helper.Utils;


@ContextConfiguration(classes = Config.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {


    @Before
    public void beforeTest(){
        requestHelper.setEnv(config.guestAppID, session.getGuestSessionId());
    }



    @Autowired private Session session;
    @Autowired private RequestHelper requestHelper;
    @Autowired private Config config;
    @Autowired protected Data data;
    @Autowired protected Utils utils;

}
