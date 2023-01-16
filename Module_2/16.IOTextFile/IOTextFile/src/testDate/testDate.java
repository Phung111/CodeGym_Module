package testDate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class testDate {
    public static void main(String[] args) throws ParseException {
        String pattern = "dd-MM-yyyy hh:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

//        String sDate = "2022-12-20 08:30:45";
        String sDate = "20-12-2022 08:30:45";
        Date date = simpleDateFormat.parse(sDate);
        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));
    }
}
