package org.example.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BasketPage {
    private final WebDriver driver;
    private List<String> prices;
    private List<String> productNames;
    private List<Integer> productCost;

    public BasketPage(WebDriver driver, List<Integer> productCost, List<String> productNames) {
        this.driver = driver;
        this.productCost = productCost;
        this.productNames = productNames;
    }
    public List<String> getProductName(){
        return this.productNames;
    }
    public List<Integer> getProductCost(){
        return this.productCost;
    }

    public int calculatePriceProducts(){
       return productCost.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    public int getCostOnPage(){
        try {
            Thread.sleep(2000); // Через явное ожидание не получилось дождаться полного подсчёта (при загрузке страницы у цифр есть анимация и выкидывает рандомное число)
            return Integer.parseInt(driver.findElement(By.className("b-right")).getText().replaceAll("[^\\d.]", ""));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public List<String> getListNamesProducts(){
        List<WebElement> names = driver.findElements(By.xpath("//a[@class=\"good-info__title j-product-popup\"]"));
        List <String> namesOnPage = new ArrayList<>();
        for(WebElement element : names){
            String text = element.getText();
            text = text.replace(",", ""); // удаление запятой
            namesOnPage.add(text);
        }
        return namesOnPage;
    }
    public List<Integer> getListCostsPage(){
        List <WebElement> costs = driver.findElements(By.className("list-item__price-new"));
        List <Integer> costsPage = new ArrayList<>();
        for(WebElement element : costs){
            costsPage.add(Integer.parseInt(element.getText().replaceAll("[^\\d.]", "")));
        }
        Collections.reverse(costsPage);
        return costsPage;
    }
}
