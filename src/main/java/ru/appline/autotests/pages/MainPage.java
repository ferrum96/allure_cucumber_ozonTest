package ru.appline.autotests.pages;

import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {

    @Override
    public WebElement getField(String name) throws Exception {
        return getField(name, "ru.appline.autotests.pages.MainPage");
    }
}
