package API;

import org.junit.Assert;

import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	public static void main(String[] args) 
	{

		JsonPath js=new JsonPath(Payload.CoursePrice());

		//Test 1 : Print No of courses returned by API

		int count = js.getInt("courses.size()");

		System.out.println("Number of courses are :" + count);

		System.out.println("=======================================================");

		//Test 2 : Print Purchase Amount

		int amount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Purchase Amount = " + amount);
		System.out.println("=======================================================");

		//Test 3 : Print Course 1 title.

		String title = js.get("courses[0].title");
		System.out.println("Course 1 Title is : " + title);
		System.out.println("=======================================================");

		//Test 4 : Print all courses title and respective prices

		for(int i=0; i<count; i++) 

		{
			String CourseTitle = js.get("courses["+i+"].title");
			System.out.println("The course "+i+" title is : " + CourseTitle);

			int price = js.getInt("courses["+i+"].price");
			System.out.println("The course "+i+" Price is : " + price);

			System.out.println("=======================================================");
		}


		//Test 5 : Print no of copies sold by RPA course
		for(int i=0; i<count; i++) 

		{

			String CourseTitle = js.get("courses["+i+"].title");

			if(CourseTitle.equalsIgnoreCase("RPA")) 
			{
				int copies = js.get("courses["+i+"].copies");

				System.out.println("Test  5 : No of copies sold by "+CourseTitle+" is : " + copies);

				break;
			}


		}

		//Test 6 : Verify if sum of all courses prices matches with purchase amount.

		int sum = 0 ;

		for(int i=0; i<count; i++) 
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");

			int amt = price * copies ;
			System.out.println("The total for course " +i+ " is " + amt);

			sum = sum+amt;
			System.out.println("=======================================================");

		}

		Assert.assertEquals(amount, sum);

		System.out.println("The sum of all courses price matches with purchase amount of " +sum);

	}
}
