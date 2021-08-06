package tng3.tests.med;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.med.action.MedAction;
import tng3.tests.med.entity.EMR;
import tng3.tests.med.entity.EMRRegistry;
import tng3.tests.med.entity.Employee;
import tng3.tests.med.entity.Profile;


@RunWith(SpringJUnit4ClassRunner.class)
public class MedTest extends BaseTest {



    @Test
    public void getProfile() {
        APIResponse response = medAction.getProfile(data.cardID);
        medAction.checkResponseSuccess(response, true);
        medAction.validateResponsePayload(response, Profile.class, false);
    }

    @Test
    public void getNonexistentProfile() {
        APIResponse response = medAction.getProfile(666);
        medAction.checkResponseSuccess(response, false);
        medAction.checkResponseErrorCode(response, 404);
    }


    @Test
    public void getRegistryByDateRange() {
        APIResponse response = medAction.getRegistryByRange("01.01.2020", "31.12.2020");
        medAction.checkResponseSuccess(response, true);
        medAction.validateResponsePayload(response, EMRRegistry.class, true);
        medAction.checkResponseElementsCountIsEqual(response, 1);
    }

    @Test
    public void getRegistryByID() {
        APIResponse response = medAction.getRegistryByID(data.medRegistryId);
        medAction.checkResponseSuccess(response, true);
        medAction.validateResponsePayload(response, EMRRegistry.class, false);
    }

    @Test
    public void getNonexistentRegistryByID() {
        APIResponse response = medAction.getRegistryByID(13);
        medAction.checkResponseSuccess(response, false);
        medAction.checkResponseErrorCode(response, 404);
    }


    @Test
    public void getEMRByID() {
        APIResponse response = medAction.getEMRByID(data.medEMRId);
        medAction.checkResponseSuccess(response, true);
        medAction.validateResponsePayload(response, EMR.class, false);
    }

    @Test
    public void getNonexistentEMRByID() {
        APIResponse response = medAction.getEMRByID(13);
        medAction.checkResponseSuccess(response, false);
        medAction.checkResponseErrorCode(response, 404);
    }

    @Test @Ignore("returned binary instead json")
    public void getEMRPdfByID() {
        APIResponse response = medAction.getEMRPdfByID(data.medEMRId);
//        medAction.checkResponseSuccess(response, true);
//        medAction.validateResponsePayload(response, EMR.class, false);
    }

    @Test
    public void signEMRByEmployee() {
        APIResponse response = medAction.signEMR(data.medEMRId, "doctor", data.medSignEmployee);
        medAction.checkResponseSuccess(response, true);
    }

    @Test
    public void signEMRByOrganization() {
        APIResponse response = medAction.signEMR(data.medEMRId, "organization", data.medSignEmployee);
        medAction.checkResponseSuccess(response, true);
    }

    @Test
    public void signNonexistentEMR() {
        APIResponse response = medAction.signEMR(13, "doctor", data.medSignEmployee);
        medAction.checkResponseSuccess(response, false);
        medAction.checkResponseErrorCode(response, 404);
    }

    @Test
    public void signEMRByNonexistentSignType() {
        APIResponse response = medAction.signEMR(data.medEMRId, "devil", data.medSignEmployee);
        medAction.checkResponseSuccess(response, false);
        medAction.checkResponseErrorMessage(response, "Unknown type");
    }


    @Test
    public void getEmployeeByID() {
        APIResponse response = medAction.getEmployeeByID(data.therapistID);
        medAction.checkResponseSuccess(response, true);
        medAction.validateResponsePayload(response, Employee.class, false);
    }

    @Test
    public void getNonexistentEmployeeByID() {
        APIResponse response = medAction.getEmployeeByID(13);
        medAction.checkResponseSuccess(response, false);
        medAction.checkResponseErrorCode(response, 404);
    }





    @Autowired private MedAction medAction;
}
