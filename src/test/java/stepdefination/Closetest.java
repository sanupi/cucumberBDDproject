package stepdefination;

import io.cucumber.java.en.Then;

public class Closetest extends Baseclass {

	
	@Then("close browser")
	public void close_browser() {
		driver.close();
		log.info("browser is closed");
}
}
