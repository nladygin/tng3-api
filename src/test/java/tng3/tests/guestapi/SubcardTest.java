package tng3.tests.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.guestapi.action.SubcardAction;
import tng3.tests.guestapi.entity.Subcard;

import java.io.IOException;


@RunWith(SpringJUnit4ClassRunner.class)
public class SubcardTest extends BaseTest {



    @Test
    public void getSubcards() {
        APIResponse response = subcardAction.getSubcards();
        subcardAction.checkResponseSuccess(response, true);
        subcardAction.validateResponsePayload(response, Subcard.class, true);
    }



    @Test
    public void addEditAndDeleteSubcard() throws IOException {
        Subcard subcard = new Subcard(
                "card " + utils.generateString(10),
                data.cardType,
                utils.generateString(10),
                utils.generateDate("YYYY-MM-dd", 0),
                utils.generateDate("YYYY-MM-dd", 365),
                utils.generateString(6) + "@mail.mail"
        );
        APIResponse response = subcardAction.addSubcard(subcard);
        subcardAction.checkResponseSuccess(response, true);
        subcardAction.validateResponsePayload(response, Subcard.class, false);

            int id = (int) ((Subcard) utils.toEntity(response, Subcard.class)).id;

            subcard.name = "new card:" + utils.generateString(10);
            subcard.cardType = data.cardType;
            subcard.magstripe = "Qq" + utils.generateString(8);
            subcard.birthDate = utils.generateDate("YYYY-MM-dd", 1);
            subcard.validTill = utils.generateDate("YYYY-MM-dd", 30);

            response = subcardAction.editSubcard(id, subcard);
            subcardAction.checkResponseSuccess(response, true);
            subcardAction.validateResponsePayload(response, Subcard.class, false);

                response = subcardAction.deleteSubcard(id);
                subcardAction.checkResponseSuccess(response, true);
                subcardAction.checkResponsePayloadIsEmpty(response);
    }



    @Test
    public void editWrongSubcard() {
        APIResponse response = subcardAction.editSubcard(666, new Subcard());
        subcardAction.checkResponseSuccess(response, false);
        subcardAction.checkResponseErrorCode(response, 152);
    }



    @Test
    public void deleteWrongSubcard() {
        APIResponse response = subcardAction.deleteSubcard(666);
        subcardAction.checkResponseSuccess(response, false);
        subcardAction.checkResponseErrorCode(response, 152);
    }





    @Autowired private SubcardAction subcardAction;
}
