package com.pages.Gmail;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonmethods.commonmethods;
import com.librarypackage.GlobalConfigurations;
import com.librarypackage.configurations;

public class gmailLogin extends commonmethods{

	WebDriver driver;
@FindBy(xpath="//input[@type='email']")
public WebElement loginPageUserName;

@FindBy(xpath="//input[@type='password']")
public WebElement loginPageUserPassword;

@FindBy(xpath="//span[text()='Next']")
public WebElement loginPageNextButton;


public gmailLogin(WebDriver driver){

	 configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());

    this.driver=config.getDriver();

    PageFactory.initElements(driver, this);

}


public void launchPage()
{

	
	driver.navigate().to("http://www.gmail.com");
}
public void gmailLoginPage(String userName,String password) throws IOException
{
	entertext(loginPageUserName,"Username",userName);
	//loginPageUserName.sendKeys(userName);
	//loginPageNextButton.click();
	click(loginPageNextButton,"Next Button");
	entertext(loginPageUserPassword,"password",password);
	//loginPageUserPassword.sendKeys(password);
	click(loginPageNextButton,"Next Button");
}


}