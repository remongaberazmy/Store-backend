package com.remon.store.service.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	public static String formatDate(Integer month, Integer year) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date date = cal.getTime();
        String pattern = "MMMM, yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateFormated = simpleDateFormat.format(date);
        return dateFormated;
	}
}
