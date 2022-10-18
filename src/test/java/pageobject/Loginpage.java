package pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	
	// data member/variable
	@FindBy(id="Email")  private WebElement Emailid;
	
	@FindBy(id="Password") private WebElement password;
	
	@FindBy(xpath = "//button[@class='button-1 login-button']" )private WebElement LoginBtn;
	
	@FindBy(linkText = "Logout") private WebElement logout;
	
	//constructor
	
	public Loginpage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	public void enterEmail(String emailAdd)
	{
		Emailid.clear();
		Emailid.sendKeys(emailAdd);
	}
	
	public void enterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickOnLoginButton()
	{
		LoginBtn.click();
	}
	
	public void clickOnLogOutButton()
	{
		logout.click();
	}
	

}
