package com.tools;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


public class StringToDateConverter implements Converter<String ,Date>{
	private String DatePattern;

	public String getDatePattern() {
		return DatePattern;
	}

	public void setDatePattern(String datePattern) {
		DatePattern = datePattern;
	}
	
	public Date convert(String date){
		try{
			SimpleDateFormat dateFormat=new SimpleDateFormat(this.DatePattern);
			return dateFormat.parse(date);
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("ÈÕÆÚ×ª»»Ê§°Ü");
			return null;
		}
	}

}
