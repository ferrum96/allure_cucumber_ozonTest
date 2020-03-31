package ru.appline.autotests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.autotests.annotation.FieldName;
import java.util.List;

public class ResultPage extends BasePage {

    @FindBy(xpath = "//div[contains(text(),'Бренды')]/..//span[contains(text(),'Посмотреть все')]")
    @FieldName(name = "Посмотреть все")
    public static WebElement showAll;

    @FindBy(xpath = "//div[contains(text(),'Цена')]/following-sibling::div//input[contains(@id,'to')]")
    @FieldName(name = "максимальная цена")
    public WebElement maxValue;

    @FindBy(xpath = "//div[@data-widget='searchResultsFilters']//div[contains(@value,'Высокий рейтинг')]//input")
    @FieldName(name = "Высокий рейтинг")
    public WebElement rate;

    @FindBy(xpath = "//span[contains(text(),'Beats')]/../parent::label/div/input")
    @FieldName(name = "Beats")
    public WebElement beats;

    @FindBy(xpath = "//span[contains(text(),'Samsung')]/../parent::label/div/input")
    @FieldName(name = "Samsung")
    public WebElement samsung;

    @FindBy(xpath = "//span[contains(text(), 'NFC')]/../parent::label/div/input")
    @FieldName(name = "NFC")
    public WebElement NFC;

    @FindBy(xpath = "//div[@data-widget='searchResultsFiltersActive']/div/button/div/span")
    List<WebElement> filters;

    @FindBy(xpath = "//div[contains(@class,'widget-search-result-container')]/div/div/div/div")
    List<WebElement> items;

    public void addCart(String count, String chetnost) {
        waitClickableOfElement(items.get(0).findElement(By.xpath(".//div/button//div[text() = 'В корзину']")));
        switch (chetnost) {
            case "четных":
                for (int i = 1; i < 2 * Integer.parseInt(count); i += 2) {
                    getItem(i);
                }
                break;
            case "нечетных":
                for (int i = 0; i < 2 * Integer.parseInt(count); i += 2) {
                    i += 2;
                    getItem(i);
                }
                break;
        }
        for (Product product : products)
            System.out.println(product);
    }

    public void addCart(String chetnost) {
        waitClickableOfElement(items.get(0).findElement(By.xpath(".//div/button//div[text() = 'В корзину']")));
        switch (chetnost) {
            case "четные":
                for (int i = 1; i <= items.size(); i += 2) {
                    getItem(i);
                }
                break;
            case "нечетные":
                for (int i = 0; i < items.size(); i += 2) {
                    i += 2;
                    getItem(i);
                }
                break;
        }
        for (Product product : products)
            System.out.println(product);
    }

    private int getItem(int i) {

        try {
            scrollToElement(items.get(i).findElement(By.xpath("./div/div/a")));
            products.add(new Product(items.get(i).findElement(By.xpath("./div/div/a")).getText(), items.get(i).findElement(By.xpath("./div/a/div/span")).getText()));
            jsClick(items.get(i).findElement(By.xpath(".//div/button//div[text() = 'В корзину']")));
        } catch (NoSuchElementException e) {
            if (items.get(i).findElement(By.xpath(".//div[text() = 'Похожие']")).isDisplayed()) gotoBasket();
            else {
                i += 2;
                scrollToElement(items.get(i).findElement(By.xpath("./div/div/a")));
                products.add(new Product(items.get(i).findElement(By.xpath("./div/div/a")).getText(), items.get(i).findElement(By.xpath("./div/a/div/span")).getText()));
                jsClick(items.get(i).findElement(By.xpath(".//div/button//div[text() = 'В корзину']")));
            }
        }
        return i;
    }

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "ru.appline.autotests.pages.ResultPage");
    }
}