package ua.org.autotest;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {
   private static WebDriver driver;

@BeforeClass
public static void setup() {
    System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    driver. manage().window().maximize();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    driver.get ("http://www.i.ua/");
}
@Test
public void userLogin() {
    WebElement loginField = driver.findElement(By.name("login"));
    loginField.sendKeys("vitalqa91");
    WebElement passwordField = driver.findElement(By.name("pass"));
    passwordField.sendKeys("0001kmsda");
    WebElement loginButton = driver.findElement(By.cssSelector("input[value=Войти]"));
    loginButton.click();
    WebElement profileUser = driver.findElement(By.cssSelector(".login-button__user"));
    String mailUser = profileUser.getText();
    Assert.assertEquals("S_H_U_T_N_I_K@ukr.net", mailUser);
}
@AfterClass
    public static void tearDown() {
    WebElement MenuUser=driver.findElement(By.cssSelector(".login-button__menu-icon"));
         MenuUser.click();
        WebElement logoutButton = driver.findElement(By.id("login__logout"));
        logoutButton.click();
        driver.quit();
    }
}
