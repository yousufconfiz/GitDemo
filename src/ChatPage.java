import java.time.Duration;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChatPage {
	WebDriver driver;
	
	@FindBy(xpath="(//h4[@class='ant-typography mt-2'])[1]")
	WebElement chatHeader;
	@FindBy(xpath="(//div[@class='chat-bubble your-chat'])[1]")
	WebElement chatBubble;
	
	public ChatPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getChatHeader() {
		return chatHeader.getText();
	}
	
	public String getChatMessage() {
		return chatBubble.getText();
	}
}
