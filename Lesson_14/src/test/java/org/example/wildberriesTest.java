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
        driver.quit();
    }
    @Test
    public void wildberriesTest(){
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.saveSomeProducts();
        mainPage.addElementsToBasket();
        BasketPage basketPage = mainPage.clickBasketButton();
        try{
            Assertions.assertEquals(basketPage.getCostOnPage(), basketPage.calculatePriceProducts());
        }
        catch (Exception e){
            System.out.println("Проверка стоимости не прошла");
            e.printStackTrace();
        }
        System.out.println(basketPage.getListNamesProducts());
        System.out.println(basketPage.getProductName().get(0));
        try {
            Assertions.assertTrue(basketPage.getListNamesProducts().containsAll(basketPage.getProductName()));
        }
        catch (Exception e){
            System.out.println("Проверка названий не прошла");
            e.printStackTrace();
        }
        System.out.println(basketPage.getListCostsPage());
        try {
            Assertions.assertIterableEquals(basketPage.getListCostsPage(), basketPage.getProductCost());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

