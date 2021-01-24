package API_Payload_Files;

public class Payload {

	public static String Add_Place()
	
	{
		
		return "{\r\n" + 
				"    \"location\": {\r\n" + 
				"        \"lat\": -38.383494,\r\n" + 
				"        \"lng\": 33.427362\r\n" + 
				"    },\r\n" + 
				"    \"accuracy\": 50,\r\n" + 
				"    \"name\": \"Sanket12\",\r\n" + 
				"    \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"    \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"    \"types\": [\r\n" + 
				"        \"shoe park\",\r\n" + 
				"        \"shop\"\r\n" + 
				"    ],\r\n" + 
				"    \"website\": \"http://google.com\",\r\n" + 
				"    \"language\": \"French-IN\"\r\n" + 
				"}";
		
	}
	
public static String CoursePrice()
	
	{
		return "{\r\n" + 
				"  \"dashboard\": {\r\n" + 
				"    \"purchaseAmount\": 910,\r\n" + 
				"    \"website\": \"rahulshettyacademy.com\"\r\n" + 
				"  },\r\n" + 
				"  \"courses\": [\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Selenium Python\",\r\n" + 
				"      \"price\": 50,\r\n" + 
				"      \"copies\": 6\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"Cypress\",\r\n" + 
				"      \"price\": 40,\r\n" + 
				"      \"copies\": 4\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"title\": \"RPA\",\r\n" + 
				"      \"price\": 45,\r\n" + 
				"      \"copies\": 10\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
	}
	
		public static String AddBook(String isbn, String aisle)
		{
			String add_book = "{\r\n"
			+ "\r\n"
			+ "\"name\":\"Learn Appium Automation with Java\",\r\n"
			+ "\"isbn\":\""+isbn+"\",\r\n"
			+ "\"aisle\":\""+aisle+"\",\r\n"
			+ "\"author\":\"Sanket Joshi\"\r\n"
			+ "}\r\n"
			+ "";
			return add_book;

		}
		
		public static String DeleteBook(String ID)
		{
			return "{\r\n"
					+ " \r\n"
					+ "\"ID\" : \""+ID+"\"\r\n"
					+ " \r\n"
					+ "} \r\n"
					+ "";
		}
		
		public static String Jira_Add_Bug()
		{
			
			return "{\r\n"
					+ "    \"fields\" : \r\n"
					+ "    {\r\n"
					+ "       \"project\" :{ \"key\": \"AUT\"},\r\n"
					+ "       \"summary\": \"Credit card transaction failed - REST API\",\r\n"
					+ "       \"description\": \"this bug is created from APIg\",\r\n"
					+ "       \"issuetype\": {\"name\": \"Bug\"}\r\n"
					+ "    }\r\n"
					+ "}";
		}
		
		public static String Add_Issue_Comment() {

			return "{\r\n"
					+ "    \"body\": \"This is my first comment through REST API\",\r\n"
					+ "    \r\n"
					+ "    \"visibility\": \r\n"
					+ "    {\r\n"
					+ "    \"type\" : \"role\",\r\n"
					+ "    \r\n"
					+ "    \"value\": \"Administrators\"\r\n"
					+ "    }\r\n"
					+ "}   ";

		}
	
}
