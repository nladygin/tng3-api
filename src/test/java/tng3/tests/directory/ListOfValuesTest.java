package tng3.tests.directory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.directory.action.ListOfValuesAction;
import tng3.common.entity.ListOfValues;
import tng3.common.entity.Value;


@RunWith(SpringJUnit4ClassRunner.class)
public class ListOfValuesTest extends BaseTest {



    @Test
    public void appendNewValueIntoExistLOV() {
        ListOfValues listOfValues = new ListOfValues();
            listOfValues.add(new Value("code1", "Value #1"));
            listOfValues.add(new Value("code2", "Value #2"));
            listOfValues.add(new Value("code3", "Value #3"));
            listOfValues.add(new Value(utils.generateString(3), utils.generateString(10)));
        APIResponse response = listOfValuesAction.syncLov("autotest", listOfValues);
        listOfValuesAction.checkResponseSuccess(response, true);
    }

    @Test
    public void appendNewLOV() {
        ListOfValues listOfValues = new ListOfValues();
            listOfValues.add(new Value("code1", "Value #1"));
            listOfValues.add(new Value("code2", "Value #2"));
            listOfValues.add(new Value("code3", "Value #3"));
        APIResponse response = listOfValuesAction.syncLov(utils.generateString(10), listOfValues);
        listOfValuesAction.checkResponseSuccess(response, true);
    }



    @Autowired private ListOfValuesAction listOfValuesAction;
}
