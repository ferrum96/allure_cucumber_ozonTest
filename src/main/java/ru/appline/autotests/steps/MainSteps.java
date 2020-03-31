package ru.appline.autotests.steps;

import cucumber.api.java.ru.Когда;
import ru.appline.autotests.pages.MainPage;

public class MainSteps {

    public MainPage mainPage = new MainPage();

    @Когда("^выполнен поиск по наименованию \"(.+)\"$")
    public void поиск(String name) throws InterruptedException {
        mainPage.searhItems(name);
    }
}
