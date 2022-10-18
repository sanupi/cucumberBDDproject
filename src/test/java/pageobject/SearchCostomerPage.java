package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCostomerPage {
	
	WebDriver driver;
	
	@FindBy(id="SearchEmail")private
	WebElement emailAdd;

	@FindBy(id="search-customers")private
	WebElement searchBotton;
	
	@FindBy(xpath="//table[@role='grid']")private
	WebElement searchResult;

	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	List<WebElement> tableColumns;
	
	
	@FindBy(id="SearchFirstName")private
	WebElement firstName;

	@FindBy(id="SearchLastName")private
	WebElement lastName;

	
	/////constructors
	public SearchCostomerPage(WebDriver driver1)
	{
		driver=driver1;
		PageFactory.initElements(driver, this);
	}
	
//methods
	
	public void enterEmailAdd(String email)
	{
		emailAdd.sendKeys(email);
	}

	//action method to perform click action on search button
	public void clickOnSearchButton()
	{
		searchBotton.click();
		
	}
	public boolean searchCustomerByEmail(String email)
	{
		boolean found = false;

		//total no. of rows in a grid
		int TotalRows = tableRows.size();//to get size


		//total no. of columns
		//int TotalColumns = tableColumns.size();

		for(int i=1;i<=TotalRows;i++)//to iterate all the rows of the grid
		{
			
			WebElement webElementEmail = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[2]"));
			String actualEmailAdd = webElementEmail.getText();
			System.out.println(actualEmailAdd);

			if(actualEmailAdd.equals(email))
			{
				found=true;
				break;
			}
			


		}

		return found;
}
///////////////////////search customer by name///////////////////////////////
//action method to enter first name
public void enterFirstName(String firstNameText)
{
firstName.sendKeys(firstNameText);
}

//action method to enter last name
public void enterLastName(String LastNameText)
{
lastName.sendKeys(LastNameText);
}

public boolean searchCustomerByName(String name1)
{
boolean found = false;

//total no. of rows in a grid
int totalRows = tableRows.size();


for(int i=1;i<=totalRows;i++)//to iterate all the rows of the grid
{
WebElement webElementName = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr[" + i  + "]/td[3]"));
String actualName = webElementName.getText();
System.out.println(actualName);

if(actualName.equals(name1))
{
found=true;

}


}

return found;

}
}
