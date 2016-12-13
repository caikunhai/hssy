package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class DateConverter implements Converter {
	public static final String[] FORMATS = { "yyyy-MM-dd HH:mm:ss",
			"yyyy-M-d HH:mm:ss", "yyyy-MM-dd H:m:s", "yyyy-M-d H:m:s",
			"yyyy/MM/dd HH:mm:ss", "yyyy-M-d HH:mm:ss", "yyyy/MM/dd H:m:s",
			"yyyy/M/d H:m:s", "HH:mm:ss", "H:m:s", "yyyy-MM-dd", "yyyy-M-d",
			"yyyy/MM/dd", "yyyy/M/d" };
	private static SimpleDateFormat sdf = new SimpleDateFormat();

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Class c, Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof String && value.toString().trim().equals("")) {
			return null;
		}
		if (c == java.util.Date.class) {
			Date v = getDate(value);
			if (v != null) {
				return v;
			}
		} else if (c == java.sql.Date.class) {
			Date v = getDate(value);
			if (v != null) {
				return new java.sql.Date(v.getTime());
			}
		} else if (c == java.sql.Time.class) {
			Date v = getDate(value);
			if (v != null) {
				return new java.sql.Time(v.getTime());
			}
		} else if (c == java.sql.Timestamp.class) {
			Date v = getDate(value);
			if (v != null) {
				return new java.sql.Timestamp(v.getTime());
			}
		}
		return value;
	}

	private Date getDate(Object value) {
		for (int i = 0; i < FORMATS.length; i++) {
			Date v = tryConvert(value, FORMATS[i]);
			if (v != null) {
				return v;
			}
		}
		return null;
	}

	public static Date tryConvert(Object value, String format) {
		try {
			sdf.applyPattern(format);
			Date date = sdf.parse(String.valueOf(value));
			return date;
		} catch (Exception e) {
			return null;
		}
	}
}
