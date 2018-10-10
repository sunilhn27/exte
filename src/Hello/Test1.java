package Hello;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Test1 extends Core {

	@Test
	public void tesiong() throws IOException {
		Core.setup();
		WebElement dr = d.findElement(By.xpath(".//*[@id='PageContainer']/main/div/div[2]/div[1]/a/div[1]"));
		dr.click();
		WebElement dr1 = d.findElement(By.xpath(".//*[@id='PageContainer']/main/div/header/ul/li[6]/a"));
		dr1.click();
		WebElement dr3 = d.findElement(By.xpath(".//*[@id='AccessibleNav']/li[5]/a"));
		dr3.click();
		WebElement dr2 = d.findElement(By.xpath(".//*[@id='AccessibleNav']/li[5]/a"));
		dr2.click();
		d.close();
	}
}
