package tng3.api;

import org.springframework.test.context.TestExecutionListeners;
import tng3.api.entity.Credentials;
import tng3.api.entity.Token;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.context.TestExecutionListeners.MergeMode.MERGE_WITH_DEFAULTS;

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
