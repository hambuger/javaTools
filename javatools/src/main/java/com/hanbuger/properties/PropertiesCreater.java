package com.hanbuger.properties;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesCreater {

	public static Properties createPropertiesByClassLoader(String filePath) throws IOException {
		Properties properties = new Properties();
		InputStream inputStream = PropertiesCreater.class.getClassLoader().getResourceAsStream(filePath);
		properties.load(inputStream);
		return properties;
	}

	public static Properties createPropertiesByInputStream(String filePath) throws IOException {
		Properties properties = new Properties();
		BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
		properties.load(bufferedReader);
		return properties;
	}

	public static String getValueByResourceBundle(String filePath, String keyName) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle(filePath);
		return resourceBundle.getString(keyName);
	}

}
