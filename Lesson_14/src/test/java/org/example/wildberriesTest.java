package org.example;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.Pages.BasketPage;
import org.example.Pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for simple App.
 */
public class wildberriesTest {
    protected static WebDriver driver;
    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.wildberries.ru");
    }

    @AfterAll
    public static void tearDown(){
//        driver.quit();
    }
    @Test
    public void wildberriesTest(){
//        List<WebElement> test1 = driver.findElements(By.xpath("//button[@class=\"btn-main\"]"));
//        System.out.println(test1);
//        test1.get(1).click();

//        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class=\"product-card__wrapper\"]"));
//        List<WebElement> firstThreeElements = allProducts.subList(0, 3);
//        WebElement productTest = allProducts.get(0);
//        productTest.click();
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//caption[@class=\"product-params__caption\"]"), "Дополнительная информация"));
//        List<WebElement> basketButton = driver.findElements(By.xpath("//button[@class=\"btn-main\"]"));
//        basketButton.get(1).click();
//        driver.navigate().back();

//        for(WebElement product : firstThreeElements){
//            product.click();
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//caption[@class=\"product-params__caption\"]"), "Дополнительная информация"));
//        List<WebElement> basketButton = driver.findElements(By.xpath("//button[@class=\"btn-main\"]"));
//        basketButton.get(1).click();
//        driver.navigate().back();
//        }
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.saveSomeProducts();
        mainPage.addElementsToBasket();
        BasketPage basketPage = mainPage.clickBasketButton();
        basketPage.basketCost();
        basketPage.calculatePriceProducts();
    }
}

