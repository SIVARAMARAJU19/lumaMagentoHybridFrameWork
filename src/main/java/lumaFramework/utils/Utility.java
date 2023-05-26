package lumaFramework.utils;

import java.util.Date;

public class Utility {

	public static String generateemailwithtimestamp() {

		Date date = new Date();
		String timestamp = date.toString().replace("_", " : ").replace(" : ", "_");
		return "klausmikealson1919"+timestamp+"@gmail.com";

	}

}
