package tng3.tests.staffapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tng3.base.APIResponse;
import tng3.tests.staffapi.action.ScheduleAction;
import tng3.tests.staffapi.entity.Schedule;

@RunWith(SpringJUnit4ClassRunner.class)
public class ScheduleTest extends BaseTest {


    @Test
    public void getSchedule(){
        APIResponse response = scheduleAction.getSchedule(
                utils.getMonthFirstDay("ddMMyyyy"),
                utils.getMonthLastDay("ddMMyyyy")
        );
        scheduleAction.checkResponseSuccess(response, true);
        scheduleAction.validateResponsePayload(response, Schedule.class, true);
    }



    @Autowired private ScheduleAction scheduleAction;
}
