package com.basepackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.librarypackage.GlobalConfigurations;
import com.librarypackage.configurations;




public class Baseclass {
  
public static ExtentHtmlReporter htmlReporter;
public static ExtentReports extent;
public static ExtentTest test;
	 @BeforeSuite
	  public void beforeMethod() {

		 
		  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport.html");
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
	  }



	 
	
	
  @BeforeMethod
  public void beforeMethod(Method arg0,ITestContext arg1) {

	 
	 
System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\Desktop\\chromedriver_win32\\chromedriver.exe");
	WebDriver wd=new ChromeDriver();
	wd.manage().window().maximize();
	
	configurations configuration=new configurations();
	configuration.setDriver(wd);
	
	System.out.println(arg0.getName());
	Thread.currentThread().setName(arg0.getName());
	
	GlobalConfigurations.configMap.put(Thread.currentThread().getName(),configuration);
  }

  @AfterMethod
  public void afterMethod(Method arg0,ITestContext arg1,ITestResult result) {
	  
	  
	  
	  configurations config=GlobalConfigurations.configMap.get(Thread.currentThread().getName()); 
	  config.createTestCaseHeader();
	  config.closetestCase();
	  
	  
	  try {
		FileWriter fw=new FileWriter(System.getProperty("user.dir")+"//htmlResults//"+arg0.getName()+".htm");
		
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(config.getHeader()+config.getWriterow()+config.getClosetags());
		bw.flush();
		bw.close();
		fw.close();
		
		/*if(result.getStatus() == ITestResult.FAILURE) {
		    test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
		    test.fail(result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
		    test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
		}
		else {
		    test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
		    test.skip(result.getThrowable());
		}*/
config.getDriver().quit();
	    
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  
  }
  @AfterTest
  public void tearDown() {
  //to write or update test information to reporter
  extent.flush();
  }
}









