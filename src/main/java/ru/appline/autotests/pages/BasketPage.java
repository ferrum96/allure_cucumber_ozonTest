package ru.appline.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.appline.autotests.annotation.FieldName;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class BasketPage extends BasePage {

    @FindBy(xpath = "//div[@data-widget=\"split\"]/div/div/parent::div")
    List<WebElement> boughtItems;

    @FindBy(xpath = "//div[@data-widget=\"stickyContainer\"]/div/div/div/span/following-sibling::span")
    @FieldName(name = "Ваша корзина")
    public WebElement countItems;

    @FindBy(xpath = "//div[@delete_button_name=\"Удалить выбранные\"]/span")
    @FieldName(name = "удалить выбранные")
    public WebElement removeItems;

    @FindBy(xpath = "//div[text() = 'Удалить']")
    @FieldName(name = "удалить")
    public WebElement remove;

    @FindBy(xpath = "//div[@data-widget=\"emptyCart\"]/h1")
    @FieldName(name = "Корзина")
    public WebElement emptyBasket;

    public void checkItems() {
        boolean isEquals;
        for (int i = 0; i < products.size(); i++) {
            isEquals = products.get(i).getName().equals(boughtItems.get(products.size() - (i + 1)).findElement(By.xpath("./div/a/span")).getText());
            if (!isEquals) {
                assertTrue(String.format("Товар [%s] не находится в корзине вместо него [%s]", products.get(i).getName(), boughtItems.get(products.size() - (i + 1)).findElement(By.xpath("./div/a/span")).getText()), isEquals);
            }
        }
    }

    public void checkValue(String field, String value) throws Exception {
        try {
            String actual = getField(field).getText();
            assertTrue(String.format("%s имеет значение %s. Ожидалось - %s", field, actual, value), actual.contains(value));
        } catch (Exception e) {
            Assert.fail("В корзине имеются товары(кнопка удаление не сработала)");
        }
    }

    public void removeItems(String name) throws Exception {
        jsClick(name);
        jsClick(remove);
    }

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "ru.appline.autotests.pages.BasketPage");
    }
}