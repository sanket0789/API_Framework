package Config;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNG_Listener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("*********Test Started :" + result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("*********Test is successful :" + result.getName());

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*********Test is failed :" + result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*********Test is skipped :" + result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("*********Test completed :" + context.getName());
		
	}

}
