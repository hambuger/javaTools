package com.hanbuger.javatools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class StartLinuxNginx {
	public static Boolean checkLinuxNginx() {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("netstat -p | grep nginx");
		} catch (IOException e) {
			e.printStackTrace();
		}
		String temp = "";
		InputStream inputStream = process.getInputStream();
		BufferedReader bufferedReader = null;
		bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		try {
			temp = bufferedReader.readLine();
			if (StringUtils.isEmpty(temp)) {
				bufferedReader.close();
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;

	}

	public static String startLinuxNginx() throws IOException {

		if (!checkLinuxNginx()) {
			Runtime.getRuntime().exec("service nginx start");
			return "检测到Nginx服务未启动,现已启动";
		} else {
			return "检测到Nginx服务已启动";
		}
	}
}
