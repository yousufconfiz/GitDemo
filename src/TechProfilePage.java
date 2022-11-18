import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TechProfilePage {
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/div/main/main/main/div[2]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/span")
	WebElement techCodeLabel;
	
	@FindBy(xpath="/html/body/div[1]/div/main/main/main/div[2]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/div[2]/span")
	WebElement techCode;
	
	public TechProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getTechProfileInfo() {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElements(techCodeLabel));
		return techCode.getText();
	}

}
