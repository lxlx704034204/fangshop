package com.fang.fangshop.core.common;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.Converter;

public class DateConverter implements Converter {
	public Object convert(Class arg0, Object arg1) {
		String p = (String) arg1;
		if (p == null || p.trim().length() == 0) {
			return null;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.parse(p.trim());
		} catch (Exception e) {
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				return df.parse(p.trim());
			} catch (Exception ex) {
				return null;
			}
		}
	}
	protected Object convertToString(Class type, Object value) {
		if (value instanceof Date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			if (value instanceof Timestamp) {
				sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			}

			try {
				return sdf.format(value);
			} catch (Exception e) {
				throw new ConversionException("日期转换为字符串时出错！");
			}
		} else {
			return value.toString();
		}
	}
}