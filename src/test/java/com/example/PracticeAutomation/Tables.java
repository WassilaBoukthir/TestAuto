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

public class Tables {
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
  public void testTables() throws Exception {
	  
    driver.get("https://practice-automation.com/tables/");
    
    try {
    driver.findElement(By.linkText("Tables")).click();
    driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).click();
    
      assertEquals("Tables", driver.findElement(By.xpath("//div[@id='top-wrap']/section/div/h1")).getText());
   
    
      assertEquals("Home", driver.findElement(By.linkText("Home")).getText());
   
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr/td")).click();
    
      assertEquals("Item", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr/td")).getText());
    
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td")).click();
    
      assertEquals("Oranges", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td")).getText());
    
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[3]/td")).click();
    
      assertEquals("Laptop", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[3]/td")).getText());
    
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[4]/td")).click();
    
      assertEquals("Marbles", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[4]/td")).getText());
    
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr/td[2]")).click();
    
      assertEquals("Price", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr/td[2]/strong")).getText());
   
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td[2]")).click();
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td[2]")).click();
    
      assertEquals("$3.99", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[2]/td[2]")).getText());
    
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[3]/td[2]")).click();
   
      assertEquals("$1200.00", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[3]/td[2]")).getText());
    
    driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[4]/td[2]")).click();
    
      assertEquals("$1.25", driver.findElement(By.xpath("//article[@id='post-1076']/div/figure/table/tbody/tr[4]/td[2]")).getText());
    
      
    driver.findElement(By.id("dt-length-0")).click();
    new Select(driver.findElement(By.id("dt-length-0"))).selectByVisibleText("25");
    driver.findElement(By.id("dt-length-0")).click();
    new Select(driver.findElement(By.id("dt-length-0"))).selectByVisibleText("10");
    driver.findElement(By.id("dt-length-0")).click();
    new Select(driver.findElement(By.id("dt-length-0"))).selectByVisibleText("50");
    driver.findElement(By.id("dt-length-0")).click();
    new Select(driver.findElement(By.id("dt-length-0"))).selectByVisibleText("100");
    driver.findElement(By.id("dt-search-0")).click();
    driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]")).click();
    
      assertEquals("India", driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr/td[2]")).getText());
    
    driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr[2]/td[2]")).click();
   
      assertEquals("China", driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr[2]/td[2]")).getText());
    
    driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr[4]/td[2]")).click();
   
      assertEquals("Indonesia", driver.findElement(By.xpath("//table[@id='tablepress-1']/tbody/tr[4]/td[2]")).getText());
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
