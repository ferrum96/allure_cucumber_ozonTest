package ru.appline.autotests.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.appline.autotests.annotation.FieldName;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static ru.appline.autotests.utils.DriverManager.getDriver;

public abstract class BasePage {

    public static WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @FindBy(xpath = "//a[@data-widget=\"cart\"]")
    @FieldName(name = "корзина")
    public WebElement cartButton;

    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void jsClick(WebElement element) {
        Actions actions = new Actions(getDriver());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        actions.moveToElement(element).build().perform();
        js.executeScript("arguments[0].click();", element);
        wait.until(driver1 -> ((JavascriptExecutor) driver1)).executeScript("return document.readyState").equals("complete");
    }

    public void jsClick(String name) throws Exception {
        //не смог сделать ожидание по фильтру
        Thread.sleep(2000);
        WebElement element = getField(name);
        jsClick(element);
    }

    public void scrollToElement(WebElement element) {
        waitVisibilityOfElement(element);
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(false);", element);
    }

    public void fillField(WebElement field, String value) {
        waitClickableOfElement(field);
        Actions actions = new Actions(getDriver());
        scrollToElement(field);
        actions.moveToElement(field).click().build().perform();
        field.sendKeys(Keys.CONTROL + "a");
        field.sendKeys(Keys.DELETE);
        field.sendKeys(value);
        field.sendKeys(Keys.ENTER);
    }

    public void fillField(String name, String value) throws Exception {
        WebElement element = getField(name);
        waitClickableOfElement(element);
        fillField(element, value);
        wait.until(driver1 -> ((JavascriptExecutor) driver1)).executeScript("return document.readyState").equals("complete");
    }

    public void searhItems(String name) {
        WebElement search = getDriver().findElement(By.xpath("//input[@name='search']"));
        waitClickableOfElement(search);
        search.clear();
        search.sendKeys(name);
        search.sendKeys(Keys.ENTER);
    }

    public WebElement getField(String name, String className) throws Exception {
        Class aClass = Class.forName(className);
        List<Field> fields = Arrays.asList(aClass.getDeclaredFields());
        for (Field field : fields) {
            if (field.getAnnotation(FieldName.class).name().equalsIgnoreCase(name)) {
                return getDriver().findElement(By.xpath(field.getAnnotation(FindBy.class).xpath()));
            }
        }
        Assert.fail("Нет такого элемента \"" + name + " \"");
        return null;
    }

    public abstract WebElement getField(String name) throws Exception;

    public void gotoBasket() {
        waitClickableOfElement(cartButton).click();
        wait.until(driver1 -> ((JavascriptExecutor) driver1)).executeScript("return document.readyState").equals("complete");
    }

    public static WebElement waitVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitClickableOfElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
