package pageObjects;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver driver;

    /**
     * All WebElements are identified by @FindBy annotation
     */
    
    @FindBy(id="normal_login_email")
    WebElement usernameTM;
    
    @FindBy(id="normal_login_password")
    WebElement passwordTM;
    
    @FindBy(tagName="h1")
    WebElement headerText;
    
    @FindBy(xpath="//*[@id=\"normal_login\"]/div[4]/div[1]/button")
    WebElement loginTM;
	
    public LoginPage(WebDriver driver){

        this.driver = driver;
        
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Set user name in textbox
    public void setUserName(String strUserName){
        usernameTM.sendKeys(strUserName);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
        passwordTM.sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
        loginTM.click();
    }

    //Get the title of Login Page
    public String getLoginHeaderText(){
    	return headerText.getText();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUserName
     * @param strPasword
     * @return
     */

    public DashboardPage navToTechDashboard(String strUserName, String strPasword){

        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();       
        
        return new DashboardPage(driver);
    }
}
