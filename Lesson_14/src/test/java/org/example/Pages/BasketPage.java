package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasketPage {
    private final WebDriver driver;
    private List<String> prices;
    private List<WebElement> productsElements;

    public BasketPage(WebDriver driver, List<WebElement> productsElements) {
        this.driver = driver;
        this.productsElements = productsElements;
    }
    public List<WebElement> getItems(){
        return productsElements;
    }
    public BasketPage basketCost(){
        driver.findElement(By.xpath("//p[@class=\"b-top__total line\"]/span[2]")).getText();
        return this;
    }
    public void calculatePriceProducts(){
        System.out.println(productsElements);
    }
}
