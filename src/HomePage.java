import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div/div/div/div[1]/nav/div/div/div[2]/div/div[2]/div[1]/a[1]")
    WebElement loginBtnTM;
	@FindBy(xpath = "/html/body/div[3]/div/div[2]/div/div[2]/button/span/span")
	WebElement closeNewsletter;

	@FindBy(xpath="//h2[contains(text(),'Save 10% on your')]")
	//(//h2[@class="ant-typography"])[2]
	WebElement newsletterHeader;
	
	//span[@class='ant-input-affix-wrapper']
	@FindBy(id="search_tech")
	WebElement searchTechCode;
	
	@FindBy(xpath="//button[@class='ant-btn ant-btn-primary search-btn']")
	WebElement searchTechCodeButton;
	
	@FindBy(xpath="/html/body/div[1]/div/main/div[1]/div/div[2]/div[1]/div/div[2]/p")
	WebElement landingDiv;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickLoginBtn() {	  
		  System.out.println("click login executed");
		  loginBtnTM.click();
	  }
	  
	  public String getNewsletterHeaderText() {
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.elementToBeClickable(closeNewsletter));
		  
		  return newsletterHeader.getText();
	  }
	  
	  public void dismissNewsletter() {
		  System.out.println("dismiss executed");
		  
		  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		  wait.until(ExpectedConditions.elementToBeClickable(closeNewsletter));
		  
		  closeNewsletter.click();
	  }
	  
	  public void navbacktoHome() {
		  this.dismissNewsletter();
	  }
	  
	  public void searchByTechCode(String techCode) {
		  //Scroll to the search bar
		  WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(landingDiv);
		  new Actions(driver)
          	.scrollFromOrigin(scrollOrigin, 0, 700)
          	.perform();
  
	  	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(7));
		  wait.until(ExpectedConditions.elementToBeClickable(searchTechCode));  
		  
		  searchTechCode.sendKeys(techCode);
		  searchTechCodeButton.click();
	  }
	  
	  //returns object of next page
	  public TechProfilePage navToTechProfilePage(String techCode) {
		  this.searchByTechCode(techCode);
		  return new TechProfilePage(driver);
	  }
	  
	  //returns object of the next page
	  public LoginPage navtoLoginPage() {
		  this.clickLoginBtn();
		  return new LoginPage(driver);
	  }
}
