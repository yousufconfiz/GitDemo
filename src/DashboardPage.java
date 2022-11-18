import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//h2[@class='ant-typography']")
	WebElement dashboardAlertHeader;
	@FindBy(xpath="//span[@class = 'ant-modal-close-x']/span")
	WebElement closeAlertButton;
	@FindBy(xpath="//span[contains(text(),'your service requests')]")
	WebElement titleText;
	@FindBy(xpath="//span[contains(text(),'scheduled services and subscriptions')]")
	WebElement customerTitleText;
	
	DashboardPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Page methods
	 */
	
	public String getDashboardAlertHeader() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(dashboardAlertHeader));
		
		return dashboardAlertHeader.getText();
	}
	
	public void dismissDashboardAlert() {
		closeAlertButton.click();
	}
	
	public String getDashboardTitleText() {
		return titleText.getText();
	}
	
	public String getCustomerDashboardTitleText() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfAllElements(customerTitleText));
		return customerTitleText.getText();
	}

	public void viewDashbaord() {
		this.dismissDashboardAlert();
	}
}
