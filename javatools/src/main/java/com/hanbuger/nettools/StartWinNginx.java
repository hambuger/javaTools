package com.hanbuger.nettools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class StartWinNginx {
	public static Boolean checkWinNginx() {
		Process process = null;
		try {
			process = Runtime.getRuntime().exec("tasklist /fi  \"imagename eq nginx.exe\"");
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
			if ((temp = bufferedReader.readLine()) != null) {
				if (temp.contains("没有运行的任务匹配指定标准")) {
					bufferedReader.close();
					return false;
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
		return true;

	}

	public static String startWinNginx() throws IOException {

		if (!checkWinNginx()) {
			Runtime.getRuntime().exec("net start nginx");
			return "检测到Nginx服务未启动,现已启动";
		} else {
			return "检测到Nginx服务已启动";
		}
	}
}