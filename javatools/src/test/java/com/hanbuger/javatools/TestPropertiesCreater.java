package com.hanbuger.javatools;

import java.io.IOException;
import java.util.Properties;

import org.junit.Test;

import com.hanbuger.properties.PropertiesCreater;

public class TestPropertiesCreater {

	@Test
	public void testGetByClassLoader() throws IOException {
		Properties properties = PropertiesCreater.createPropertiesByClassLoader("test.properties");
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("password"));
	}

	@Test
	public void testGetByBufferedReader() throws IOException {
		Properties properties = PropertiesCreater
				.createPropertiesByInputStream("C:/Users/Administrator/Desktop/test.properties");
		System.out.println(properties.getProperty("user"));
		System.out.println(properties.getProperty("password"));
	}

	@Test
	public void testGetByResourceBundle() {
		System.out.println(PropertiesCreater.getValueByResourceBundle("test", "user"));
		System.out.println(PropertiesCreater.getValueByResourceBundle("test", "password"));

	}
}
