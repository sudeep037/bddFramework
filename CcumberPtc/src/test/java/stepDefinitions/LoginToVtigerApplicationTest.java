package stepDefinitions;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginToVtigerApplicationTest {
	WebDriver driver;
	Random randnum = new Random();
	int ran = randnum.nextInt(1000);
	public String orgName;
	
//	//Hooks
//	@Before("@sanityTest")
//	public void launchBrowser_And_EnterURL()
//	{
//		driver=new ChromeDriver();
//	    driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	    driver.get("http://localhost:8888"); 
//	}
//	
//	@After("@sanityTest,@regTest")
//	public void closeBrowser()
//	{
//		driver.quit();
//	}
//	
//	@Before("@regTest")
//	public void lunchBrowser()
//	{
//		driver=new FirefoxDriver();
//	    driver.manage().window().maximize();
//	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	    driver.get("http://localhost:8888"); 
//	}
	//Background
	
	@Given("open the browser")
	public void open_the_browser() {
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@When("enter the url")
	public void enter_the_url() {
		 driver.get("http://localhost:8888");  
	}
	
	@Then("Login page should be displayed")
	public void login_page_should_be_displayed() {
	    System.out.println("login page is displaying");
	}
	
	
	
	@Given("when user launch the browser and enters the vtiger url")
	public void when_user_launch_the_browser_and_enters_the_vtiger_url() {
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("http://localhost:8888");
	}
	
	@When("user logining to application with valid username {string} and valid password {string} and click on login button")
	public void user_logining_to_application_with_valid_username_and_valid_password_and_click_on_login_button(String username, String password) {
	   driver.findElement(By.name("user_name")).sendKeys(username);
	   driver.findElement(By.name("user_password")).sendKeys(password);
	   driver.findElement(By.id("submitButton")).click();
	}
	
	@When("^user logining to application with valid username (.+) and valid password (.+) and click on login button$")
	public void user_logining_to_application_with_valid_username_admin_and_valid_password_manager_and_click_on_login_button(String username,String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		   driver.findElement(By.name("user_password")).sendKeys(password);
		   driver.findElement(By.id("submitButton")).click();
	}
	
	@Then("homePage should be displayed")
	public void home_page_should_be_displayed() {
	   String url = driver.getCurrentUrl();
	   if(url.contains("Home"))
	   {
		   System.out.println("homepage is displaying");
	   }else {
		   System.out.println("homepage is not displaying");
	   }
	}
	
	@Then("organisations, contacts, products links should be displayed")
	public void organisations_contacts_products_links_should_be_displayed() {
	   WebElement text = driver.findElement(By.xpath("//a[.='Organizations']"));
	   String actualText = text.getText();
	   if(actualText.contains("Organizations"))
	   {
		   System.out.println("organisations link is displaying");
	   }else {
		   System.out.println("Organisations link is not displaying");
	   }
	}
	
	@When("user logining to application with valid {string} username and valid {string} password and click on login button")
	public void user_logining_to_application_with_valid_username_and_valid_password_and_click_on_login_button1(String username, String password) {
		driver.findElement(By.name("user_name")).sendKeys(username);
		   driver.findElement(By.name("user_password")).sendKeys(password);
		   driver.findElement(By.id("submitButton")).click();
	}
	@When("user click on Organisations link")
	public void user_click_on_organisations_link() {
	   driver.findElement(By.xpath("//a[.='Organizations']")).click();
	}
	@When("user click on create organisation lookup image")
	public void user_click_on_create_organisation_lookup_image() {
	   driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	}
	
	@When("user enters the organisation name, enter the website name, enter the other email and click on saveBtn")
	public void user_enters_the_organisation_name_enter_the_website_name_enter_the_other_email_and_click_on_save_btn(io.cucumber.datatable.DataTable dataTable) {
		List<List<String>> data = dataTable.asLists();
		String organisationName = data.get(0).get(0);
		String websitename = data.get(0).get(1);
		String otherWebsiteName = data.get(0).get(2);
		orgName=organisationName+ran;
	
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(websitename);
		driver.findElement(By.xpath("//input[@id='email2']")).sendKeys(otherWebsiteName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}
	
	@When("organisation should be created")
	public void organisation_should_be_created() {
	   WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	   String text = ele.getText();
	  if(text.contains(orgName))
	  {
		  System.out.println("organisation is created");
	  }else {
		  System.out.println("organisation is not created");
	  }
	}
}
