package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomer_Page {
	public WebDriver driver;

	//Find web elements on the web page
		@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")	 private
		WebElement Customers_menu;


		@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]")private
		WebElement Customers_menuitem;

		@FindBy(xpath = "//a[@class='btn btn-primary']")	private 
		WebElement bottonAddnew;


		//@FindBy(xpath = "//input[@id='Email']")
		@FindBy(id = "Email")private WebElement Email_Id;


		//@FindBy(xpath = "//input[@id='Password']")
		@FindBy(id = "Password")private
		WebElement PasswordValue;

		@FindBy(xpath = "//div[@class='k-multiselect-wrap k-floatwrap']")private
		WebElement CustomerRoles;


		@FindBy(xpath = "//li[contains(text(),'Administrators')]")private
		WebElement ItemAdministrators;


		@FindBy(xpath = "//li[contains(text(),'Registered')]")private
		WebElement ItemRegistered;

		@FindBy(xpath = "//li[contains(text(),'Guests')]")private
		WebElement ItemGuests;


		@FindBy(xpath = "//li[contains(text(),'Guests')]")private
		WebElement ItemVendors;
		//VendorId

		@FindBy(xpath = "//*[@id='VendorId']")private
		WebElement dropdownVendorMgr;

		@FindBy(id = "Gender_Male")private
		WebElement MaleGender;

		@FindBy(id = "Gender_Female")private
		WebElement FeMaleGender;


		//@FindBy(xpath = "//input[@id='FirstName']")
		@FindBy(id = "FirstName")private
		
		WebElement FirstName;


		//@FindBy(xpath = "//input[@id='LastName']")
		@FindBy(id = "LastName")private
		WebElement LastName;

		//@FindBy(xpath = "//input[@id='DateOfBirth']")
		@FindBy(id = "DateOfBirth")private
		WebElement Dob;

		//@FindBy(xpath = "//input[@id='Company']")
		@FindBy(id = "Company")private
		WebElement CompanyName;

		//@FindBy(xpath = "//textarea[@id='AdminComment']")
		@FindBy(id = "AdminComment")private
		WebElement txtAdminContent;

		//@FindBy(xpath = "//button[@name='save']")
		@FindBy(name = "save")private
		WebElement btnSave;

///constructors
		public AddNewCustomer_Page(WebDriver driver1)
		{
			driver=driver1;
			PageFactory.initElements(driver, this);
		}
		
		//methods
		
		//Actions Methods for web elements

		public String getPageTitle()
		{
			return driver.getTitle();
		}

		public void clickOnCustomersMenu() {
			Customers_menu.click();
		}

		public void clickOnCustomersMenuItem() {
			Customers_menuitem.click();
		}

		public void clickOnAddnew() {
			bottonAddnew.click();
		}

		public void enterEmail(String email)
		{
			Email_Id.sendKeys(email);
		}

		public void enterPassword(String password)
		{
			PasswordValue.sendKeys(password);
		}
		public void enterFirstName(String firstName)
		{
			FirstName.sendKeys(firstName);
		}

		public void enterLastName(String lastName)
		{
			LastName.sendKeys(lastName);
		}

		public void enterDob(String dob)
		{
			Dob.sendKeys(dob);
		}

		public void enterCompanyName(String coName)
		{
			CompanyName.sendKeys(coName);
		}

		public void enterAdminContent(String content)
		{
			txtAdminContent.sendKeys(content);
		}

		/*public void enterCustomerRoles(String role)  
		{
		}*/

		public void enterManagerOfVendor(String value)
		{
			Select drp=new Select(dropdownVendorMgr);
			drp.selectByVisibleText(value);
		}

		public void enterGender(String gender)
		{
			if(gender.equals("Male"))
			{
				MaleGender.click();
			}
			else if(gender.equals("Female"))
			{
				FeMaleGender.click();
			}
			else//default set Male gender
			{
				MaleGender.click();
			}

		}

		

		public void clickOnSave()
		{
			btnSave.click();
		}
		
	}


