package com.commonmethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.basepackage.Baseclass;
import com.google.common.io.Files;
import com.librarypackage.GlobalConfigurations;
import com.librarypackage.configurations;

public class commonmethods  {

	WebDriver driver;
	WebElement element;
	ExtentTest test1;
	ExtentLink link;
	public void  click(WebElement element,String locator) throws IOException
	{
		 configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
		 this.test1=config.getTest();
		 this.driver=config.getDriver();
		try
		{
			if(element.isDisplayed())
			{
				
				// test1.createNode(locator+ "is displayed");
				 
				 link = new ExtentLink();
				 link.setLinkText(locator+ " is displayed");
				 
				 link.setLinkUrl(takeScreenShot(driver));
				 test1.log(Status.PASS, link);
				// test1.log(Status.PASS,locator+ " is displayed");
				  Assert.assertTrue(true);
				Assert.assertTrue(true, "Element found");
				configurations.loginfo("Valiodate if Element"+locator+"is displayed","Element"+locator+"is displayed","Pass");
				System.out.println("Element is displayed");
				element.click();
				
			}	
		}
		catch (ElementNotInteractableException E)
		{
			 link = new ExtentLink();
			 link.setLinkText(locator+ " is displayed");
			 
			 link.setLinkUrl(takeScreenShot(driver));
			 test1.log(Status.FAIL, link);
			Assert.assertFalse(false,"Element not found");
			System.out.println("Element is not displayed");
			configurations.loginfo("Valiodate if Element"+locator+"is displayed","Element"+locator+"is not displayed","Fail");

		}
		
		
					
		
		
		
		
	}
	
	public void entertext(WebElement element,String locator,String text) throws IOException
	{
		configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
		 this.test1=config.getTest();
		 this.driver=config.getDriver();
		if(element.isDisplayed())
		{
			
			//test1.createNode(locator+ "is displayed");
			 link = new ExtentLink();
			 link.setLinkText(locator+ " is displayed");
			 
			 link.setLinkUrl(takeScreenShot(driver));
			 test1.log(Status.PASS, link);
			// test1.log(Status.PASS,locator+ " is displayed");
			Assert.assertTrue(true, "Element founds");
			configurations.loginfo("Validate if Element"+locator+"is displayed","Element"+locator+"is displayed","Pass");
			System.out.println("Element is displayed");
			element.sendKeys(text);
			Assert.assertEquals("Element is visible","Element is visible");
		}
		else
		{
			
			 link = new ExtentLink();
			 link.setLinkText(locator+ " is displayed");
			 
			 link.setLinkUrl(takeScreenShot(driver));
			 test1.log(Status.FAIL, link);
			System.out.println("Element is not displayed");
			configurations.loginfo("Valiodate if Element"+locator+"is displayed","Element"+locator+"is not displayed","Fail");
			Assert.assertEquals("Element is not visible","Element is not visible");
		}
		
	}
	
	public void wait(WebElement element)
	{
		configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
		this.driver=config.getDriver();
		//PageFactory.initElements(driver, this);
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		
	}
	
	public String takeScreenShot(WebDriver driver) throws IOException
	{
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		String destPath=System.getProperty("user.dir")+"//screenshots//"+System.currentTimeMillis()+".png";
		File DestFile=new File(destPath);
		//Copy file at destination
		Files.copy(SrcFile, DestFile);
		
		
		
		return destPath;
	}
	
}
