package keyWordDrivernFramework;

import java.io.ObjectInputFilter.Config;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Data.DataTypes;
import Data.InvalidBrowserException;

public class genericKeywords extends DataTypes {

	public void getbrowser() {

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
	}

	public void appLaunch() {

		driver.get(Maheprop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void type(String locatorKey, String Text) {
//		 driver.findElement(By.xpath(Maheprop.getProperty(locatorKey))).sendKeys(Text);

		getElement(locatorKey);
	}

	public void click(String locatorKey) {
		getElement(locatorKey).click();
	}

	public void DropDown(String locatorKey, String option) {

		new Select(getElement(option));

	}

	public String getTitle() {
		return driver.getTitle();

	}

	private WebElement getElement(String locatorKey) {
		WebElement element = null;

		WebDriverWait Mywaits = new WebDriverWait(driver,
				Duration.ofSeconds(Long.parseLong(Maheprop.getProperty("explicit"))));
		Mywaits.until(ExpectedConditions.presenceOfElementLocated(getlocator(locatorKey)));

		driver.findElement(getlocator(locatorKey));

		return element;

	}

	private By getlocator(String locatorKey) {

		By by = null;

		if (locatorKey.endsWith("_id")) {
			by = By.id(Locatorprop.getProperty(locatorKey));
		}

		else if (locatorKey.endsWith("_LinkText")) {
			by = By.linkText(Locatorprop.getProperty(locatorKey));
		}

		else if (locatorKey.endsWith("_name")) {
			by = By.name(Locatorprop.getProperty(locatorKey));
		}

		else if (locatorKey.endsWith("_xpath")) {
			by = By.xpath(Locatorprop.getProperty(locatorKey));
		}

		else {
			by = By.xpath(Locatorprop.getProperty(locatorKey));
		}

		return by;

	}
}
