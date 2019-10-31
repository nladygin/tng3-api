package tng3.api;

import tng3.api.config.AppConfig;
import tng3.api.entity.Credentials;
import tng3.api.entity.Token;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tng3.helper.Utils;

@ContextConfiguration(classes = {
        AppConfig.class,
        Credentials.class,
        Utils.class,
        Token.class
})
/*
@TestExecutionListeners(
        listeners = CassandraUnitTestExecutionListener.class,
        mergeMode = MERGE_WITH_DEFAULTS
)
*/
public class BaseTest {

    @Autowired
    private Token token;


    @Before
    public void before() {

    }

    @BeforeClass
    public static void beforeClass(){

    }

}
