package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Driver;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataTypes {

	public static WebDriver driver;
	public static FileInputStream fis;
	public static Properties Maheprop;

	public static WebDriver driver1;
	public static FileInputStream fis1;
	public static Properties Locatorprop;

	@BeforeTest
	public void getdata() {

		try {
			fis = new FileInputStream("D:\\New folder\\Mahedrive\\maheJava\\Mahe.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Maheprop = new Properties();
		try {
			Maheprop.load(fis);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void getdata2() {

		try {
			fis1 = new FileInputStream("D:\\New folder\\Mahedrive\\maheJava\\Locators.properties");
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		Locatorprop = new Properties();
		try {
			Locatorprop.load(fis1);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void setdata() {

		String chrome = Maheprop.getProperty("browser");

		switch (chrome) {
		case "chrome":
			driver = new ChromeDriver();

			break;

		case "firefox":
			driver = new FirefoxDriver();

			break;

		case "edge":
			driver = new EdgeDriver();

			break;

		default:
			try {
				throw new InvalidBrowserException();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;

		}

		driver.get(Maheprop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@AfterMethod
	public void ending() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
