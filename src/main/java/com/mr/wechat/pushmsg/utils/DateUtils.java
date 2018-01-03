package com.mr.wechat.pushmsg.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getFormateDate(){
		SimpleDateFormat dateFormat
			=new SimpleDateFormat("yyyy-MM-dd");
		
		return dateFormat.format(new Date());
	}
	

	public static String getFormateDate_02(){
		SimpleDateFormat dateFormat
			=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		return dateFormat.format(new Date());
	}
	
	public static String getFormateDate_03(){
		SimpleDateFormat dateFormat
			=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return dateFormat.format(new Date());
	}
}
