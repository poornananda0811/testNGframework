package com.pages.Gmail;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.commonmethods.commonmethods;
import com.librarypackage.GlobalConfigurations;
import com.librarypackage.configurations;

public class gmailEmail extends commonmethods{

	
	WebDriver driver;
	@FindBy(xpath="//a[@title='Sent Mail']")
	public WebElement mailSentMail;

	@FindBy(xpath="//a[@title='Sent Mail']")
	public commonmethods mailSentMails;
	
	WebElement element;
	
	public gmailEmail(WebDriver driver){

		
		 configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());

	    this.driver=config.getDriver();

	    PageFactory.initElements(driver, this);

	}
	
	public void gmailComposeMail() throws IOException
	{
		
		
		click(mailSentMail,"Sent  Email");
		
	}
	
	

	
}
