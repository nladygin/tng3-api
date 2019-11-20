package tng3.guestapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.guestapi.action.ProfileAction;
import tng3.guestapi.entity.CreditCard;
import tng3.guestapi.entity.PrivacyOptions;
import tng3.guestapi.entity.Profile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


@RunWith(SpringJUnit4ClassRunner.class)
public class ProfileTest extends BaseTest {



    @Test
    public void createProfile() throws IOException {
        Profile profile = new Profile(
                0,
                "API " + utils.generateString(),
                "auto",
                "test",
                "M",
                utils.generateDate("YYYY-MM-dd", -20*365),
                "RU",
                "620000",
                "Lenina str 1-1",
                "Ekb",
                "1" + utils.generateDigits(10),
                "1" + utils.generateDigits(10),
                utils.generateString() + "@autotest.test",
                "profile notes " + utils.generateString(),
                "HRS",
                "auto tester",
                "ru_RU",
                utils.generateString(10),
                utils.generateDate("YYYY-MM-dd", 365),
                data.cardType,
                "Active",
                utils.generateString(10),
                "udfs 1 value",
                new PrivacyOptions(),
                null,
                "123"
        );
        APIResponse response = profileAction.createProfile(profile);
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);
        profileAction.equalData(utils.toEntity(response, Profile.class), profile);
    }



    @Test
    public void createProfileWithExistedEmail() throws IOException {
        String email = utils.generateString() + "@autotest.test";
        Profile profile = new Profile(
                0,
                "API " + utils.generateString(),
                "auto",
                "test",
                "M",
                utils.generateDate("YYYY-MM-dd", -20*365),
                "RU",
                "620000",
                "Lenina str 1-1",
                "Ekb",
                "1" + utils.generateDigits(10),
                "1" + utils.generateDigits(10),
                email,
                "profile notes " + utils.generateString(),
                "HRS",
                "auto tester",
                "ru_RU",
                utils.generateString(10),
                utils.generateDate("YYYY-MM-dd", 365),
                data.cardType,
                "Active",
                utils.generateString(10),
                "udfs 1 value",
                new PrivacyOptions(),
                null,
                "123"
        );

        APIResponse response = profileAction.createProfile(profile);
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);
        profileAction.equalData(utils.toEntity(response, Profile.class), profile);

            Profile doubleProfile = new Profile(
                    0,
                    "API " + utils.generateString(),
                    "auto",
                    "test",
                    "M",
                    utils.generateDate("YYYY-MM-dd", -20*365),
                    "RU",
                    "620000",
                    "Lenina str 1-1",
                    "Ekb",
                    "1" + utils.generateDigits(10),
                    "1" + utils.generateDigits(10),
                    email,
                    "profile notes " + utils.generateString(),
                    "HRS",
                    "auto tester",
                    "ru_RU",
                    utils.generateString(10),
                    utils.generateDate("YYYY-MM-dd", 365),
                    data.cardType,
                    "Active",
                    utils.generateString(10),
                    "udfs 1 value",
                    new PrivacyOptions(),
                    null,
                    "123"
            );

            response = profileAction.createProfile(doubleProfile);
            profileAction.checkResponseSuccess(response, false);
            profileAction.checkResponseErrorCode(response, 121);
    }


    @Test
    public void createProfileWithExistedCellPhone() throws IOException {
        String cellPhone = "1" + utils.generateDigits(10);
        Profile profile = new Profile(
                0,
                "API " + utils.generateString(),
                "auto",
                "test",
                "M",
                utils.generateDate("YYYY-MM-dd", -20*365),
                "RU",
                "620000",
                "Lenina str 1-1",
                "Ekb",
                "1" + utils.generateDigits(10),
                cellPhone,
                utils.generateString(10) + "@autotest.test",
                "profile notes " + utils.generateString(),
                "HRS",
                "auto tester",
                "ru_RU",
                utils.generateString(10),
                utils.generateDate("YYYY-MM-dd", 365),
                data.cardType,
                "Active",
                utils.generateString(10),
                "udfs 1 value",
                new PrivacyOptions(),
                null,
                "123"
        );

        APIResponse response = profileAction.createProfile(profile);
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);
        profileAction.equalData(utils.toEntity(response, Profile.class), profile);

        Profile doubleProfile = new Profile(
                0,
                "API " + utils.generateString(),
                "auto",
                "test",
                "M",
                utils.generateDate("YYYY-MM-dd", -20*365),
                "RU",
                "620000",
                "Lenina str 1-1",
                "Ekb",
                "1" + utils.generateDigits(10),
                cellPhone,
                utils.generateString(11) + "@autotest.test",
                "profile notes " + utils.generateString(),
                "HRS",
                "auto tester",
                "ru_RU",
                utils.generateString(10),
                utils.generateDate("YYYY-MM-dd", 365),
                data.cardType,
                "Active",
                utils.generateString(10),
                "udfs 1 value",
                new PrivacyOptions(),
                null,
                "123"
        );

        response = profileAction.createProfile(doubleProfile);
        profileAction.checkResponseSuccess(response, false);
        profileAction.checkResponseErrorCode(response, 122);
    }


    @Test
    public void getProfile() {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);
    }


    @Test
    public void editProfile() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));

            profileAction.editProfile(profile);
            profileAction.checkResponseSuccess(response, true);
            profileAction.validateResponsePayload(response, Profile.class, false);
            profileAction.equalData(utils.toEntity(response, Profile.class), profile);
    }


    @Test
    public void postProfileWithBadFirstName() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.firstName=utils.generateString(41);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 102);
    }


    @Test
    public void postProfileWithBadSecondName() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.secondName = utils.generateString(41);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 103);
    }


    @Test
    public void postProfileWithBadLastName() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.lastName=utils.generateString(41);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 101);
    }


    @Test
    public void postProfileWithBadGender() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.gender = "Q";

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 104);
    }


    @Test
    public void postProfileWithBadCountry() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.country=utils.generateString(21);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 106);
    }


    @Test
    public void postProfileWithBadZipCode() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.zipCode=utils.generateString(11);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 107);
    }


    @Test
    public void postProfileWithBadStreetAddress() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.streetAddress=utils.generateString(101);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 108);
    }


    @Test
    public void postProfileWithBadCity() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.city=utils.generateString(51);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 109);
    }


    @Test
    public void postProfileWithBadPhone() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.phone=utils.generateString(51);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 110);
    }


    @Test
    public void postProfileWithBadCellPhone() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.cellPhone=utils.generateString(51);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 111);
    }


    @Test
    public void postProfileWithBadEmail() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.email=utils.generateString(51);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 112);
    }


    @Test
    public void postProfileWithBadNotes() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.notes=utils.generateString(1001);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 113);
    }


    @Test
    public void postProfileWithBadCompany() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.company=utils.generateString(101);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 114);
    }


    @Test
    public void postProfileWithBadJobTitle() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.jobTitle=utils.generateString(31);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 115);
    }


    @Test
    public void postProfileWithBadPassport() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.passport=utils.generateString(101);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 116);
    }


    @Test
    public void postProfileWithBadUDFS1() throws IOException {
        APIResponse response = profileAction.getProfile();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, Profile.class, false);

            Profile profile = new Profile((Profile) utils.toEntity(response, Profile.class));
            profile.udfs1=utils.generateString(1001);

                response = profileAction.editProfile(profile);
                profileAction.checkResponseSuccess(response, false);
                profileAction.checkResponseErrorCode(response, 118);
    }


    @Test
    public void getCreditCards() {
        APIResponse response = profileAction.getCreditCards();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, CreditCard.class, true);
    }


    @Test
    public void deleteCreditCards() throws IOException {
        APIResponse response = profileAction.getCreditCards();
        profileAction.checkResponseSuccess(response, true);
        profileAction.validateResponsePayload(response, CreditCard.class, true);

            APIResponse card = new APIResponse();
                card.setPayload(((ArrayList) response.getPayload()).get(0));
            CreditCard creditCard = (CreditCard) utils.toEntity(card, CreditCard.class);

        response = profileAction.deleteCreditCards(creditCard.id);
        profileAction.checkResponseSuccess(response, true);
        profileAction.checkResponsePayloadIsEmpty(response);
    }










    @Autowired private ProfileAction profileAction;
}
