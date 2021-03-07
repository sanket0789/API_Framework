package Payload_API;

import java.sql.Timestamp;

public class API_Payload {

	public static String AUTH()

	{

		return "{\r\n"
				+ "            \"username\": \"sanket.joshi@tracktik.com\",\r\n"
				+ "            \"password\": \"Track1!\"\r\n"
				+ "        }";
	}
	
	public static String Add_Employee()
	{

		return "{\"firstName\": \"Sanket95\",\r\n"
				+ "\r\n"
				+ "\"lastName\": \"Joshi95\" \r\n"
				+ "}";
		
	}

	public static String Terminate_Employee()
	{

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return "{\"date\": \""+timestamp+"\",\r\n"
				+ "\r\n"
				+ "\"reason\": \"1\" \r\n"
				+ "}";

	}
	
	public static String Update()
	{

		
		return "{\"firstName\": \"Sanket9\",\r\n"
				+ "\r\n"
				+ "\"lastName\": \"Joshi9\" \r\n"
				+ "}";

	}

}
