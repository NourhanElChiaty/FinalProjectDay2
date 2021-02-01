package com.UIAutomationFinalProjectV2.UIAutomationFinalProjectV2;

import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.AfterTest;

public class BaseTest {
	protected WebDriver driver;
	  PropertyFile prop = new PropertyFile();
	  
  @BeforeTest
  public void beforeTest() throws IOException {
	  if(prop.getProperty("browserName").equals("chrome")) {
		  System.out.println(prop.getProperty("browserName"));
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		 // String URL =getProperty("baseURL");
		  
		  }
	  else if(prop.getProperty("browserName").equals("firefox")) {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
	  }
	  driver.navigate().to(prop.getProperty("baseURL"));
	  System.out.println(prop.getProperty("baseURL"));
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
