package Hello;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

public class Listners extends Core implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("********************indoide ON Test**********");
		rep.startTest(result.getName() + " Test started");
		String url = "http://www.google.com";
		String name = result.getName();
		for (int i = 0; i < 6; i++) {
			if (!url.equals(d.getCurrentUrl())) {
				try {
					Core.Screenshot(name);
					rep.attachScreenshot("I:\\REST API Testing\\Appiumworksapce\\Extent\\screenshot\\" + name + ".jpg");
					System.out.println("screen shot took");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		Core.infoAndReport(result.getName() + " Test Started");
	}

	public void onTestSuccess(ITestResult result) {
		Core.PassAndReport(result.getName() + " Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		String name = result.getName();
		Core.FailAndReport(result.getName() + " Test Falied");
		try {
			Core.Screenshot(name);
			rep.attachScreenshot("I:\\REST API Testing\\Appiumworksapce\\Extent\\screenshot\\" + name + ".jpg");
			log.info("Succesfully Took The ScrenShot");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		Core.SkippedAndReport(result.getName() + " Test Skipped");
		String url = "http://www.google.com";
		String name = result.getName();

		if (!url.equals(d.getCurrentUrl())) {
			try {
				Core.Screenshot(name);
				rep.attachScreenshot("I:\\REST API Testing\\Appiumworksapce\\Extent\\screenshot\\" + name + ".jpg");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		rep.log(LogStatus.SKIP, "hi");

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onStart(ITestContext context) {
		// rep.startTest("Test started" + context.getName());
		System.out.println("name " + context.getName());
		String url = "http://www.google.com";
		String name = context.getName();

		/*
		 * if (!url.equals(d.getCurrentUrl())) { try { Core.Screenshot(name);
		 * rep.attachScreenshot(
		 * "I:\\REST API Testing\\WORKSPACE\\AutomationPractice\\Screenshots\\" + name + "
		 * .jpg"); } catch (Exception e) { e.printStackTrace(); } }
		 */
	}

	public void onFinish(ITestContext context) {
		// rep.endTest();

	}
}