package Portal.Action;

import Portal.Utils.Write2Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tools {
	public static String redirectUrl = null;

	//
	public static String getRedirectUrl(HttpServletRequest request) throws ServletException, IOException {
		String cfgPath = request.getRealPath("/");// 获取服务器的webroot路径
		FileInputStream fis = null;
		Properties config = new Properties();
		File file = new File(cfgPath + "config.properties");
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		 	Write2Log.Wr2Log("config.properties 配置文件不存在！！");
		}

		try {
			config.load(fis);
			redirectUrl = config.getProperty("redirectUrl");
			// #chap 0 pap 1
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Write2Log.Wr2Log("config.properties 数据库配置文件读取失败！！");
		} finally {
			fis.close();
		}
		return redirectUrl;
	}

	Tools() {
		redirectUrl = "http://61.135.169.121";
	}

	public static boolean ipCheck(String text) {
		if (text != null && !text.isEmpty()) {
			// 定义正则表达式
			String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." + "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\."
					+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
			// 判断ip地址是否与正则表达式匹配
			if (text.matches(regex)) {
				// 返回判断信息
				return true;
			} else {
				// 返回判断信息
				return false;
			}
		}
		return false;
	}

	public static String getUserIpFromUrl(String[] userIps) {
		String userIp = null;
		if (userIps == null) {
			return null;
		} else {
			userIp = userIps[userIps.length - 1];
			if (Tools.ipCheck(userIp) == false) {
				return null;
			}
			return userIp;
		}
	}
}
