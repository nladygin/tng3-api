package tng3.tests.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.guestapi.action.DocAction;
import tng3.tests.guestapi.entity.Docs;


@RunWith(SpringJUnit4ClassRunner.class)
public class DocTest extends BaseTest {



    @Test
    public void getDocs() {
        APIResponse response = docAction.getDocs(
                data.offset,
                data.count,
                null,
                null,
                null
        );
        docAction.checkResponseSuccess(response, true);
        docAction.validateResponsePayload(response, Docs.class, false);
    }


    @Test
    public void getDocsByAccount() {
        APIResponse response = docAction.getDocs(
                data.offset,
                data.count,
                "DEPO",
                null,
                null
        );
        docAction.checkResponseSuccess(response, true);
        docAction.validateResponsePayload(response, Docs.class, false);
    }


    @Test
    public void getDocsWithFromTill() {
        APIResponse response = docAction.getDocs(
                data.offset,
                data.count,
                null,
                utils.generateDate("dd.MM.YYYY", -30),
                utils.generateDate("dd.MM.YYYY", 0)
        );
        docAction.checkResponseSuccess(response, true);
        docAction.validateResponsePayload(response, Docs.class, false);
    }


    @Test
    public void getDocsByAccountWithFromTill() {
        APIResponse response = docAction.getDocs(
                data.offset,
                data.count,
                "DEPO",
                utils.generateDate("dd.MM.YYYY", -30),
                utils.generateDate("dd.MM.YYYY", 0)
        );
        docAction.checkResponseSuccess(response, true);
        docAction.validateResponsePayload(response, Docs.class, false);
    }


    @Test
    public void getDocsWithBadOffset() {
        APIResponse response = docAction.getDocs(
                -1,
                data.count,
                null,
                null,
                null
        );
        docAction.checkResponseSuccess(response, false);
        docAction.checkResponseErrorCode(response, 0);
    }


    @Test
    public void getDocsWithBadCount() {
        APIResponse response = docAction.getDocs(
                data.offset,
                0,
                null,
                null,
                null
        );
        docAction.checkResponseSuccess(response, false);
        docAction.checkResponseErrorCode(response, 0);
    }








    @Autowired private DocAction docAction;
}
