package com.product.sale.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
	
private static final DateFormat dst = new SimpleDateFormat("yyyyMMdd");
	
	public static String getCurrentDate(){
		Date date = new Date();
		return dst.format(date).toString();
	}
	
	public static String formatStringtoDate(String str){
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {

            Date date = formatter.parse(str);
            return formatter.format(date).toString();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
	}

}
