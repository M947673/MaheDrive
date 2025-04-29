package SmokeTesting;

import org.apache.poi.sl.usermodel.ObjectMetaData.Application;
import org.testng.annotations.Test;

import Data.DataTypes;
import keyWordDrivernFramework.applicationKeyWords;

public class regressionTesting extends  DataTypes {

	@Test
	public void   validateLoginTest() {
		
		
		applicationKeyWords app = new applicationKeyWords();
		
		app.getbrowser();
		
		app.appLaunch();
		
		app.loginWithDefaultData();
		
		app.verifyTitle("Adactin.com - Search Hotel");
	}
}
