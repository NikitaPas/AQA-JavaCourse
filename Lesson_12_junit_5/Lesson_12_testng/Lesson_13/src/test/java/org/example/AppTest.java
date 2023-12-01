package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class AppTest {
    protected static WebDriver driver;
    private String urlMoreAboutService = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
    private String blockName = "Онлайн пополнение\nбез комиссии";
    @BeforeAll
    static public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");

    }

    @AfterAll
    static public void tearDown(){
        driver.quit();
    }

    @Test
    public void checkOnlineReplishment(){
        String text = driver.findElement(By.xpath("//div[@id='pay-section']//h2[1]")).getText();
        Assertions.assertEquals(blockName, text);

        List<WebElement> imagePaymentMethods = driver.findElements(By.xpath("//div[@class=\"pay__partners\"]//ul/li"));
        Assertions.assertEquals(6, imagePaymentMethods.size());

        driver.get(driver.findElement(By.xpath("//section[@class=\"pay\"]//a")).getAttribute("href"));
        Assertions.assertEquals(urlMoreAboutService, driver.getCurrentUrl());
        driver.navigate().back();

        WebElement phoneInputField = driver.findElement(By.xpath("//input[@id=\"connection-phone\"]"));
        phoneInputField.click();
        phoneInputField.sendKeys("297777777");

        WebElement sumInputField = driver.findElement(By.xpath("//input[@id=\"connection-sum\"]"));
        sumInputField.click();
        sumInputField.sendKeys("5");

        WebElement emailInputField = driver.findElement(By.xpath("//input[@id=\"connection-email\"]"));
        emailInputField.click();
        emailInputField.sendKeys("test1@test.com");

        driver.findElement(By.xpath("//button[@class=\"button button__default \"]")).click();
        WebElement payFrame = driver.findElement(By.xpath("//iframe[@class=\"bepaid-iframe\"]"));
        driver.switchTo().frame(payFrame);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//p[@class=\"header__payment-amount\"]"), "5.00 BYN"));
        String textIntoPayFrame = driver.findElement(By.xpath("//p[@class=\"header__payment-amount\"]")).getText();
        Assertions.assertEquals("5.00 BYN", textIntoPayFrame);
    }
}

