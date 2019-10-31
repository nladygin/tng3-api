package tng3.helper;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;



@Component
@PropertySource({"data.properties"})
public class Utils {




/*
    public Entity toEntity(String jsonString, Class cl){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            Entity entity = null;
            try {
                entity = (Entity) mapper.readValue(jsonString, cl);
            } catch (IOException e) {
                LogManager.getLogger().error(e.getStackTrace().toString());
            }

        return entity;
    }
*/




    public String generateDate(String dateFormat, int dayShift){
        SimpleDateFormat f = new SimpleDateFormat(dateFormat);
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DAY_OF_MONTH, dayShift);
        return f.format( DateUtils.ceiling(cal.getTime(), Calendar.HOUR) );
    }





    public String generateDateMS(int dayShift){
        LocalDateTime localDateTime = LocalDateTime.parse(generateDate("dd.MM.YYYY HH:mm", dayShift),
                DateTimeFormatter.ofPattern("dd.MM.uuuu HH:mm") );
            long millis = localDateTime
                    .atZone(ZoneId.systemDefault())
                    .toInstant().toEpochMilli();
        return String.valueOf(millis);
    }




    public String getMonthFirstDay(String format){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }



    public String getMonthLastDay(String format){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(cal.getTime());
    }





    public String generateString(){
        return generateString(5);
    }

    public String generateString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }






    public long generateDigits() {
        return generateDigits(10);
    }

    public long generateDigits(int length) {
        int m = (int) Math.pow(10, length-1);
        return Math.abs(m + new Random().nextInt(9 * m));
    }





    public int getErrorCode(Object error){
        return ((HashMap<String, Integer>) error).get("code");
    }

    public String getErrorMessage(Object error){
        return ((HashMap<String, String>) error).get("message");
    }






    public Utils(){}


}
