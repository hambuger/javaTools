package com.hanbuger.javatools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ping {

	public static String ping(String ipAddress, int pingTimes, int timeOut) {
		BufferedReader in = null;
		Runtime r = Runtime.getRuntime();
		// 将要执行的ping命令,此命令是windows格式的命令
		String pingCommand = "";
		// 判断系统为Windows还是Linux
		if (checkWinOS()) {
			pingCommand = "ping " + ipAddress + " -n " + pingTimes + " -w " + timeOut;
		} else {
			pingCommand = "ping " + ipAddress + " -c " + pingTimes + " -W " + timeOut;
		}
		try {
			// 执行命令并获取输出
			Process p = r.exec(pingCommand);
			if (p == null) {
				return "Ping:网络异常";
			}
			in = new BufferedReader(new InputStreamReader(p.getInputStream(), "GBK"));
			// 逐行检查输出,计算类似出现=23ms字样的次数
			int connectedCount = 0;
			String result = "";
			String line = null;
			while ((line = in.readLine()) != null) {
				connectedCount += getCheckResult(line);
				result = result + line;
			}
			// 如果出现类似=23ms 这样的字样,出现的次数=测试次数则返回真
			if (connectedCount == pingTimes) {
				return "Ping:前置机网络畅通";

			}
			return "Ping:" + result;
		} catch (Exception ex) {
			ex.printStackTrace();
			// 出现异常则返回网络异常
			return "Ping:网络异常";
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 若line含有=18ms TTL=16字样,说明已经ping通,返回1,否則返回0.
	private static int getCheckResult(String line) {
		// System.out.println("控制台输出的结果为:"+line);
		Pattern pattern = null;
		if (checkWinOS()) {
			pattern = Pattern.compile("(\\d+ms)(\\s+)(TTL=\\d+)", Pattern.CASE_INSENSITIVE);
		} else {
			pattern = Pattern.compile("(TTL=\\d+)(\\s+)(\\d+ms)", Pattern.CASE_INSENSITIVE);
		}
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			return 1;
		}
		return 0;
	}

	public static Boolean checkWinOS() {

		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().startsWith("win")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		String status = "Ping:";
		try {
			status = status + ping("hosp.baipaas.com", 1, 3000);
			System.out.println(status);
			System.out.println(System.getProperty("os.name"));
		} catch (Exception e) {
			System.out.println("异常信息：" + e.getMessage());
		}

	}
}