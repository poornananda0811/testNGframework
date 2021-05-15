package com.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.basepackage.Baseclass;
import com.librarypackage.GlobalConfigurations;
import com.librarypackage.configurations;
import com.pages.Facebook.faceBookLogin;



public class FacebookTestCase extends Baseclass{
	 public static ExtentTest test;
	public static Logger logger= LogManager.getLogger(FacebookTestCase.class.getName());
  @Test
  public void facebookTC1() throws IOException {
	  logger.info("Request URI:" );
	  test=extent.createTest("fbTc1");
	  configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
	  config.setTest(test);
	

	  WebDriver driver=config.getDriver();
	  faceBookLogin flogin=new faceBookLogin(driver);
	
	  flogin.launchPage();
	  flogin.fbLoginPage("pichi","pichi");
	  
	
	  
	  
	  
  }
}
