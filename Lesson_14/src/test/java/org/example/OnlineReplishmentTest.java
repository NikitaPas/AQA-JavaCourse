package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OnlineReplishmentTest {
    private final String emailInputFieldPlaceHolder = "E-mail для отправки чека";
    private final String testPhone = "297777777";
    private final String testSum = "5";
    private final String testEmail = "test1@test.com";
    protected static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.mts.by/");

    }

    @AfterAll
    public static void tearDown(){
        driver.quit();
    }
    @Test
    @Order(1)
    public void testPlaceHoldersOnlineReplishment(){
        Assertions.assertEquals("Номер телефона", driver.findElement(By.id("connection-phone")).getAttribute("placeholder"));
        Assertions.assertEquals("Сумма", driver.findElement(By.id("connection-sum")).getAttribute("placeholder"));
        Assertions.assertEquals(emailInputFieldPlaceHolder, driver.findElement(By.id("connection-email")).getAttribute("placeholder"));

        Assertions.assertEquals("Номер абонента", driver.findElement(By.id("internet-phone")).getAttribute("placeholder"));
        Assertions.assertEquals("Сумма", driver.findElement(By.id("internet-sum")).getAttribute("placeholder"));
        Assertions.assertEquals(emailInputFieldPlaceHolder, driver.findElement(By.id("internet-email")).getAttribute("placeholder"));

        Assertions.assertEquals("Номер счета на 44", driver.findElement(By.id("score-instalment")).getAttribute("placeholder"));
        Assertions.assertEquals("Сумма", driver.findElement(By.id("instalment-sum")).getAttribute("placeholder"));
        Assertions.assertEquals(emailInputFieldPlaceHolder, driver.findElement(By.id("instalment-email")).getAttribute("placeholder"));

        Assertions.assertEquals("Номер счета на 2073", driver.findElement(By.id("score-arrears")).getAttribute("placeholder"));
        Assertions.assertEquals("Сумма", driver.findElement(By.id("arrears-sum")).getAttribute("placeholder"));
        Assertions.assertEquals(emailInputFieldPlaceHolder, driver.findElement(By.id("arrears-email")).getAttribute("placeholder"));
    }
    @Test
    @Order(2)
    public void testBePaidFrame(){
        WebElement phoneInputField = driver.findElement(By.xpath("//input[@id=\"connection-phone\"]"));
        WebElement sumInputField = driver.findElement(By.xpath("//input[@id=\"connection-sum\"]"));
        WebElement emailInputField = driver.findElement(By.xpath("//input[@id=\"connection-email\"]"));

        Actions builder = new Actions(driver);
        builder
                .click(phoneInputField)
                .sendKeys(testPhone)
                .click(sumInputField)
                .sendKeys(testSum)
                .click(emailInputField)
                .sendKeys(testEmail)
                .build().perform();

        driver.findElement(By.xpath("//button[@class=\"button button__default \"]")).click();
//        frameTest();
        WebElement payFrame = driver.findElement(By.xpath("//iframe[@class=\"bepaid-iframe\"]"));
        driver.switchTo().frame(payFrame);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//p[@class=\"header__payment-amount\"]"), "5.00 BYN"));
        String textIntoPayFrame = driver.findElement(By.xpath("//p[@class=\"header__payment-amount\"]")).getText();
        Assertions.assertTrue(textIntoPayFrame.contains(testSum));
        Assertions.assertTrue(driver.findElement(By.xpath("//button[@class=\"colored disabled ng-star-inserted\"]")).getText().contains(testSum));
        Assertions.assertTrue(driver.findElement(By.xpath("//p[@class=\"header__payment-info\"]")).getText().contains(testPhone));
    }
    @Test
    @Order(3)
    public void testBePaidFramePlaceHolders() {
        Assertions.assertEquals("Номер карты", driver.findElement(By.xpath("//label[@class=\"ng-tns-c47-1 ng-star-inserted\"]")).getText());
        Assertions.assertEquals("Срок действия", driver.findElement(By.xpath("//label[@class=\"ng-tns-c47-4 ng-star-inserted\"]")).getText());
        Assertions.assertEquals("CVC", driver.findElement(By.xpath("//label[@class=\"ng-tns-c47-5 ng-star-inserted\"]")).getText());
        Assertions.assertEquals("Имя держателя (как на карте)", driver.findElement(By.xpath("//label[@class=\"ng-tns-c47-3 ng-star-inserted\"]")).getText());
        List<WebElement> images = driver.findElements(By.xpath("//div[@class=\"cards-brands cards-brands__container ng-tns-c53-0 ng-trigger ng-trigger-brandsState ng-star-inserted\"]//img"));
        Assertions.assertEquals(5, images.size());
    }
}

