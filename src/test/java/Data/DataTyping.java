package Data;

import org.apache.poi.sl.usermodel.ObjectShape;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTyping extends DataTypes {

	@Test(description = "To validate login",dataProvider="Testdata")
	public void getTyping(String username , String password , String expTitle) {

		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		Assert.assertEquals(driver.getTitle(), expTitle);

	}

//	@Test(description = "To validate login")
//	public void getTyping2() {
//
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0806");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz143");
//		driver.findElement(By.xpath("//input[@name='login']")).click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//
//		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
//
//}
//	@Test(description = "To validate login")
//	public void getTyping3() {
//
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0606");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz123");
//		driver.findElement(By.xpath("//input[@name='login']")).click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//
//		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
//
//}
//	@Test(description = "To validate login")
//	public void getTyping4() {
//
//		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("reyaz0606");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("reyaz143");
//		driver.findElement(By.xpath("//input[@name='login']")).click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//
//			e.printStackTrace();
//		}
//
//		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
//
//	}
	
	@DataProvider
	
	public Object[][] Testdata()
	{
		Object[][] obj = new Object[4][3];
		
		obj[0][0]="reyaz0806";
		obj[0][1]="reyaz123";
		obj[0][2]="Adactin.com - Search Hotel";
		
		obj[1][0]="reyaz0306";
		obj[1][1]="reyaz123";
		obj[1][2]="Adactin.com - Hotel Reservation System";
		
		obj[2][0]="reyaz0806";
		obj[2][1]="reyaz143";
		obj[2][2]="Adactin.com - Hotel Reservation System";
         
		obj[3][0]="reyaz0306";
		obj[3][1]="reyaz143";
		obj[3][2]="Adactin.com - Hotel Reservation System";
		
		return obj;
		
	}
	
	  
	 

}
