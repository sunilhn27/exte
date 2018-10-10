package Hello;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Core {

	public static WebDriver d = null;
	public static Logger log = Logger.getLogger(Core.class);
	public static ExtentReports rep = ExtentReports.get(Core.class);
	public static Properties p = null;
	public static FileInputStream fs = null;
	// public static ExcelReader e = new ExcelReader(
	// System.getProperty("user.dir") + "\\src\\main\\java\\Utilities\\Data.xlsx");;

	@BeforeSuite
	public static void setup() throws IOException {
		if (d == null) {

			rep.init(System.getProperty("user.dir") + "\\Reports\\Result.html", true);
			System.setProperty("webdriver.chrome.driver", "D:\\MS OFFICE\\Chromedriver.exe");
			d = new ChromeDriver();
			d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			d.manage().deleteAllCookies();
			d.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			d.manage().window().maximize();

			d.get("https://www.gcssantaana.com/");
		}

	}

	public static void Screenshot(String name) throws Exception {
		File scr = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scr,
				new File("I:\\REST API Testing\\Appiumworksapce\\Extent\\screenshot\\" + name + ".jpg"));
		log.info("succesfully took the screen shot");
	}

	public static void infoAndReport(String message) {
		log.info("Message: " + message);
		rep.log(LogStatus.INFO, message);
	}

	public static void FailAndReport(String message) {
		log.error("Message: " + message);
		rep.log(LogStatus.FAIL, message);
	}

	public static void PassAndReport(String message) {
		log.info("Message: " + message);
		rep.log(LogStatus.PASS, message);
	}

	public static void SkippedAndReport(String message) {
		log.info("Message: " + message);
		rep.log(LogStatus.SKIP, message);
	}

	@AfterSuite
	public static void teardown() throws InterruptedException {
		Thread.sleep(5000);
		// d.close();
	}
	public static void clicking (String url) {
		url=d.getCurrentUrl();

	}
}