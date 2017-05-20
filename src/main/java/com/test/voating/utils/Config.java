package com.test.voating.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	public static final String FILE_NAME = "config.properties";
	public static Properties property = null;

	public static String getValue(String key) {
		String value = getPropertyFile().getProperty(key).trim();
		if (value == null) {
			value = "";
		}
		return value;
	}

	private static Properties getPropertyFile() {
		if (property == null) {
			property = new Properties();
			InputStream input = Config.class.getClassLoader().getResourceAsStream(FILE_NAME);
			try {
				property.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return property;
	}

}