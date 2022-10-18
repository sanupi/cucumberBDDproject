package stepdefination;




import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobject.AddNewCustomer_Page;
import pageobject.Loginpage;
import pageobject.SearchCostomerPage;
import utilites.Readconfig;

public class Stepdemo1 extends Baseclass {
	@Before
	public void setup1() throws IOException
	{
		//initialize readconfig
		readconfig = new Readconfig();
		
		//Initialize logger
		log = LogManager.getLogger("Stepdemo1");

		System.out.println("Setup-Sanity method executed..");

		String browser = readconfig.getBrowser();
		
		
		
			//launch browser
			switch(browser.toLowerCase())
			{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "msedge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			default:
				driver = null;
				break;

			}

		
			log.fatal("Setup1 executed...");
}
	@Before("@regression")
	public void setup2()
	{
		System.out.println("Setup2-Regression method executed..");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		log.info("Setup2 executed...");
	}
	
@Given("User Launch Chrome browser")
public void user_launch_chrome_browser() {
	
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
	log.info("chrome browser launched");

	
	Login = new Loginpage( driver);
	
	addnewcustomer=new AddNewCustomer_Page(driver);
	
	searchcustomer =new SearchCostomerPage(driver);
   
}

@When("User opens URL {string}")
public void user_opens_url(String url) {
driver.get(url);
log.info("url opened");
    
}

@When("User enters Email as {string} and Password as {string}")
public void user_enters_email_as_and_password_as(String Emailadd, String password) {
	Login.enterEmail(Emailadd);
	Login.enterPassword(password);
	log.info("email address and password entered");
   
}

@When("Click on Login")
public void click_on_login() {	
	Login.clickOnLoginButton();
	log.info("Clicked on login button");
}
/////////////////////////////////////////Login features/////////////////////////////////////////////////////

@Then("Page Title should be {string}")
public void page_title_should_be(String ExpectedTitel) {
    String actualTitel=driver.getTitle();
    if(actualTitel.equals(ExpectedTitel))
    {
      System.out.println("test case is match test case is pass");
      log.warn("Test Failed: Login feature- page title is matched.");
  
    }

    else
    
    System.out.println("test case is not match then test case is fail");
    log.warn("Test Failed: Login feature- page title not matched.");
}

@When("User click on Log out link")
public void user_click_on_log_out_link() {
	Login.clickOnLogOutButton();
	log.info("user clicked on logout link.");
	
	

}

//@Then("close browser")
//public void close_browser() {
	//driver.close();
	//log.info("browser is closed");

//}

	/////////*************************** add new customer******************************\\\\\\\\\\\
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
		String actualTitle = addnewcustomer.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			log.info("user can view dashboard test passed.");
			Assert.assertTrue(true);
			
		}
		else
		{
			Assert.assertTrue(false);
			log.warn("user can view dashboard test failed.");

		}
	}
	  
	

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
		addnewcustomer.clickOnCustomersMenu();
		log.info("customer menu clicked");
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
		addnewcustomer.clickOnCustomersMenuItem();
		log.info("customer menu item clicked");
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		addnewcustomer.clickOnAddnew();
		log.info("clicked on add new button.");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		String actualTitle = addnewcustomer.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";

		if(actualTitle.equals(expectedTitle))
		{
			log.info("User can view Add new customer page- passed");

			Assert.assertTrue(true);//pass
		}
		else
		{
			log.info("User can view Add new customer page- failed");

			Assert.assertTrue(false);//fail
		}
	 
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
		//addnewcustomer.enterEmail("samarth_maharaj@gmail.com");
		addnewcustomer.enterEmail(generateEmailId() + "@gmail.com");
		addnewcustomer.enterPassword("test2");
		addnewcustomer.enterFirstName("kanchan");
		addnewcustomer.enterLastName("khandade");
		addnewcustomer.enterGender("Female");
		addnewcustomer.enterDob("6/13/1988");
		addnewcustomer.enterCompanyName("CodeStudio1111");
		addnewcustomer.enterAdminContent("Admin content");
		addnewcustomer.enterManagerOfVendor("Vendor 1");

		log.info("customer information entered");
	  
	}


	

	@When("click on Save button")
	public void click_on_save_button() {
		addnewcustomer.clickOnSave();
		log.info("clicked on save button");
	
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String exptectedConfirmationMsg) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(exptectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
			log.info("User can view confirmation message - passed");

		}
	
	else
		{
			log.warn("User can view confirmation message - failed");

			Assert.assertTrue(false);//fail

		}
	}
////////////Search Customer//////////////////////////
	@When("enter the coustomer email address")
	public void enter_the_coustomer_email_address() throws InterruptedException {
		searchcustomer.enterEmailAdd("victoria_victoria@nopCommerce.com");
		Thread.sleep(2000);
		log.info("enter the email address");
	}

	@When("Click on search button")
	public void click_on_search_button()   {
		searchcustomer.clickOnSearchButton();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("click on serach button successfully.");
	}
	
	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	{
		String expectedEmail = "victoria_victoria@nopCommerce.com";
		
		
		
		//   Assert.assertTrue(SearchCustPg.searchCustomerByEmail(expectedEmail));

		if( searchcustomer.searchCustomerByEmail(expectedEmail) ==true)
		{
			log.info("User should found Email in the Search table - passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			log.info("User should found Email in the Search table - passed");
			Assert.assertTrue(false);

		}
	}

 //search customer by name
	}
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
		searchcustomer.enterFirstName("Victoria ");
		
		log.info("customer firstname enter");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name()  {
		searchcustomer.enterLastName("Terces");
		
		log.info("customer Lastname enter");
	}
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() throws InterruptedException {
		Thread.sleep(1000);
		String expectedName = "Victoria Terces";


		if( searchcustomer.searchCustomerByName(expectedName) ==true)
			
		{
			 log.warn("Test pass: Found name - page title is matched.");
			Assert.assertTrue(true);
		}
		else
		{
			 log.warn("Test Failed:Found name - page title not matched.");
			Assert.assertTrue(false);

	}
	}
	/*@After
	public void teardown(Scenario sc) 
	{
		System.out.println("Tear Down method executed..");
		if(sc.isFailed()==true)
		{
			//Convert web driver object to TakeScreenshot

			String fileWithPath = "C:\\Users\\USER\\eclipse-workspace\\5Th march_selenium_program\\bin\\verificationstudy\\CucumberFramewaork\\Screenshots\\failedScreenshot.png";
			TakesScreenshot scrShot =((TakesScreenshot)driver); 

			//Call getScreenshotAs method to create image file
			File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

			//Move image file to new destination
			File DestFile=new File(fileWithPath);

			//Copy file at destination

	 {
				try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

		//driver.quit();
	}*/
	@AfterStep
		public void addScreenshot(Scenario scenario){

			//if(scenario.isFailed())
			{
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			//attach image file report(data, media type, name of the attachment)
			scenario.attach(screenshot, "image/png", scenario.getName());
			}

	}
}
	

	


