package com.hanbuger.javatools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class RestartNginx {

	public static Boolean checkNginxStart() {

		Process process = null;
		try {
			process = Runtime.getRuntime().exec("net start");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String temp = "";
		InputStream inputStream = process.getInputStream();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "GBK"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			while ((temp = bufferedReader.readLine()) != null) {
				if (temp.contains("nginx")) {
					bufferedReader.close();
					return true;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static String startNginx() throws IOException {

		if (!checkNginxStart()) {
			Runtime.getRuntime().exec("net start nginx");
			return "检测到Nginx服务未启动,现已启动";
		} else {
			return "检测到Nginx服务已启动";
		}
	}

}
