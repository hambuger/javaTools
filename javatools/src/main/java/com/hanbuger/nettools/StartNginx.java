package com.hanbuger.nettools;

import java.io.IOException;

public class StartNginx {

	public static String startNginx() {

		if (Ping.checkWinOS()) {
			try {
				return StartWinNginx.startWinNginx();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				return StartLinuxNginx.startLinuxNginx();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "不支持除Win,Linux外系统或者出现未知错误！";
	}

}
