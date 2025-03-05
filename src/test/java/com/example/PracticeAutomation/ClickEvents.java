package com.example.PracticeAutomation;

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.example.practiceautomation.po.ClickEventsPage;

import java.time.Duration;

public class ClickEvents {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  ClickEventsPage ClickEventsPage;
  
  
  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("start-maximized");
	  options.addArguments("--remote-allow-origins=*");
	  driver = new ChromeDriver(options);
	  baseUrl = "https://practice-automation.com/";
	  ClickEventsPage = new ClickEventsPage(driver);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  js = (JavascriptExecutor) driver;
	  }

  
  
	@Test
	public void testClickEvent2() throws Exception {
		driver.get("https://practice-automation.com/Click Events/");
		try {
		ClickEventsPage.getCat().click();
		assertEquals("Meow!", ClickEventsPage.getTextDemo().getText());
		ClickEventsPage.getDog().click();
		assertEquals("Woof!", ClickEventsPage.getTextDemo().getText());
		ClickEventsPage.getPig().click();
		assertEquals("Oink!", ClickEventsPage.getTextDemo().getText());
		ClickEventsPage.getCow().click();
		assertEquals("Moo!", ClickEventsPage.getTextDemo().getText());
		ClickEventsPage.takeScreenShot("clickevents.jpg");
		
		ClickEventsPage.takeScreenShot("getClickEventsHeadLine.jpg",ClickEventsPage.getCat());







		
		
	} catch (Error e) {
		verificationErrors.append(e.toString());
		
	}
		
	}


  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
