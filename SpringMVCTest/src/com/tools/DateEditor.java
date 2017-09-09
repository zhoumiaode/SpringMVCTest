package com.tools;

import java.beans.PropertyEditorSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.taglibs.standard.extra.spath.ParseException;

public class DateEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try{
			Date date=(Date) dateFormat.parse(text);
			setValue(date);
		}catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
  }
}
