package Data;

import java.util.HashMap;

import org.apache.poi.sl.usermodel.ObjectShape;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilKit.Util;

 

public class DataTypingExcel extends DataTypes {

	@Test(description ="To validate login", dataProvider = "Testdata")
	public void getTyping(HashMap<String, String> testinghmap) {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(testinghmap.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(testinghmap.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Assert.assertEquals(driver.getTitle(),  "Adactin.com - Search Hotel");

	}

	@DataProvider

	public Object[][] Testdata() {
		Object[][] hmap = new Object[1][1];

		hmap[0][0] = Util.getTestDataFromExcel("TC-001");

		return hmap;

	}

}
