package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage {
    private List<WebElement> firstThreeElements = new ArrayList<>();
    By basketButtonLocator = By.xpath("//a[@data-wba-header-name='Cart']");
    private final WebDriver driver;
    List<String> productNames = new ArrayList<>();
    List<Integer> productCost = new ArrayList<>();

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public MainPage saveSomeProducts(){
        List<WebElement> allProducts = driver.findElements(By.xpath("//div[@class=\"product-card__wrapper\"]"));
        firstThreeElements = allProducts.subList(0, 3);

        return this;
    }
    public MainPage addElementsToBasket() {
        for(WebElement product : firstThreeElements){
            System.out.println(product.findElement(By.tagName("a")).getAttribute("aria-label"));
            System.out.println(product.findElement(By.tagName("ins")).getText());
            productNames.add(product.findElement(By.tagName("a")).getAttribute("aria-label"));
            productCost.add(Integer.parseInt(product.findElement(By.tagName("ins")).getText().replaceAll("[^\\d.]", "")));
            System.out.println(productNames);
            System.out.println(productCost);
            product.click();
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.textToBe(By.xpath("//caption[@class=\"product-params__caption\"]"), "Дополнительная информация"));
            List<WebElement> basketButton = driver.findElements(By.xpath("//button[@class=\"btn-main\"]"));
            basketButton.get(1).click();

            driver.navigate().back();
        }
        return this;
    }
    public BasketPage clickBasketButton(){
        driver.findElement(basketButtonLocator).click();
        return new BasketPage(driver, productCost, productNames);
    }
}
