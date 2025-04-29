package Data;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import UtilKit.Util;

public class excel2 extends DataTypes{
	
	@Test(description="To validate Invalid" , dataProvider="Testngdata")
	public void excel(HashMap <String, String>   Hashing) {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(Hashing.get("username"));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Hashing.get("password"));
		driver.findElement(By.xpath("//input[@name='login']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		 
			e.printStackTrace();
		}
		
		Assert.assertEquals(driver.getTitle(), "Adactin.com - Hotel Reservation System");
	}
	
	@DataProvider
	public Object[][]  Testngdata(){
		
	Object[][]	hashmap =  new  Object[1][1];
	
	hashmap[0][0] = Util.getTestDataFromExcel("TC-002");
	
		return hashmap ;
		
	}
	

}
