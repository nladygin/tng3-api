package tng3.tests.staffapi;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import tng3.helper.RequestHelper;
import tng3.helper.Utils;
import tng3.auth.Session;
import tng3.tests.staffapi.config.Config;
import tng3.base.Data;

@ContextConfiguration(classes = Config.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BaseTest {


    @Before
    public void beforeTest(){
        requestHelper.setEnv(config.staffAppID, session.getStaffSessionId());
    }



    @Autowired private Session session;
    @Autowired private RequestHelper requestHelper;
    @Autowired private Config config;
    @Autowired protected Data data;
    @Autowired protected Utils utils;

}
