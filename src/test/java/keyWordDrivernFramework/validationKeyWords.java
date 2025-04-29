package keyWordDrivernFramework;

import org.testng.Assert;

public class validationKeyWords extends genericKeywords {

	public void verifyTitle(String expTitle) {
		 Assert.assertEquals(getTitle(), expTitle);
	}
}
