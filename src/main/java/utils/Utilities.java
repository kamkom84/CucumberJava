package utils;

import java.util.Date;

public class Utilities {
	
	public final static int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_LOAD_TIME=5;
	
	public static String generateEmailWithTimeStamp() {
		
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_");
		return "ivanIvanov" + timestamp + "@gmail.com";
		
	}

}
