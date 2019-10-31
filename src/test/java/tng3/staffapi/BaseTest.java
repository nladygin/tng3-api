package tng3.staffapi;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import tng3.helper.RequestHelper;
import tng3.staffapi.auth.Session;
import tng3.staffapi.config.Config;

@ContextConfiguration(classes = Config.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {


    @Before
    public void beforeTest(){
        requestHelper.setEnv(config.appID, session.getId());
    }



    @Autowired private Session session;
    @Autowired private RequestHelper requestHelper;
    @Autowired private Config config;
}
