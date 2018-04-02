package Portal.Action;

public class Tools {
	public static String redirectUrl = "http://61.135.169.121";
	public static boolean ipCheck(String text) {
        if (text != null && !text.isEmpty()) { 
            // 定义正则表达式
            String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." +
                      "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
                      "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\." +
                      "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$";
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
		}
		else{
			userIp = userIps[userIps.length-1];
			if(Tools.ipCheck(userIp) == false)
			{
				return null;
			}
			return userIp;
		}
	}
}
