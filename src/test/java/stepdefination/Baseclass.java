package stepdefination;

import org.openqa.selenium.WebDriver;



import org.apache.commons.lang.RandomStringUtils;



import pageobject.AddNewCustomer_Page;
import pageobject.Loginpage;
import pageobject.SearchCostomerPage;
import utilites.Readconfig;

import org.apache.logging.log4j.*;

public class Baseclass {
	
public static WebDriver driver;
	
	public Loginpage Login;
	
	public AddNewCustomer_Page addnewcustomer;
	
    public	SearchCostomerPage searchcustomer;
    
    public static Logger log;
	public Readconfig readconfig;
	
	
	//generate unique email id
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}

}
