package keyWordDrivernFramework;

 
public class applicationKeyWords extends validationKeyWords {

	public void loginWithDefaultData() 
	{
        type("username_textbox", Maheprop.getProperty("username"));
        type("password_textbox", Maheprop.getProperty("password"));
        
        click(getTitle());
         
        
        
        
	}
}
