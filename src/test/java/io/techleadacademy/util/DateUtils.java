package io.techleadacademy.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public String getCurrentFormattedDate () {
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        Date date = new Date();
        return format.format(date);
    }
}
