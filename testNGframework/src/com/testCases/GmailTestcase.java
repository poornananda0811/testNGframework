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
import com.pages.Gmail.gmailEmail;
import com.pages.Gmail.gmailLogin;

public class GmailTestcase extends Baseclass{
	 public static ExtentTest test;
	static Logger logger = LogManager.getLogger(GmailTestcase.class);
  @Test
  public void gmailTc1() throws IOException {
	  logger.info("Request URI:" );
  test=extent.createTest("gmailTc1");
  configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName());
  config.setTest(test);

	
	
	  gmailLogin glogin=new gmailLogin(config.getDriver());
	
	  glogin.launchPage();
	  glogin.gmailLoginPage("","");
	  
	 
	 gmailEmail gMail= new gmailEmail(config.getDriver());
	  gMail.gmailComposeMail();
	  
	  
  }
}
