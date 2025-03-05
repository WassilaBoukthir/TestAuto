package com.example.PracticeAutomation;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class Popups {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testPopups() throws Exception {
    driver.get("https://practice-automation.com/");
    driver.findElement(By.linkText("Popups")).click();
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).click();
    try {
      assertEquals("Popups", driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).getText());
   
    
      assertEquals("Home", driver.findElement(By.linkText("Home")).getText());
   
    driver.findElement(By.xpath("//button[@id='alert']/b")).click();
    acceptNextAlert = true;
    assertEquals("Hi there, pal!", closeAlertAndGetItsText());
    driver.findElement(By.xpath("//button[@id='confirm']/b")).click();
    assertTrue(closeAlertAndGetItsText().matches("^OK or Cancel, which will it be[\\s\\S]$"));
    driver.findElement(By.xpath("//article[@id='post-1055']/div/div[3]")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [answerOnNextPrompt | wassila | ]]
    
      assertEquals("OK it is!", driver.findElement(By.id("confirmResult")).getText());
    
    driver.findElement(By.id("prompt")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [getPrompt |  | ]]
    driver.findElement(By.id("promptResult")).click();
    
      assertEquals("Nice to meet you, wassila!", driver.findElement(By.id("promptResult")).getText());
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
