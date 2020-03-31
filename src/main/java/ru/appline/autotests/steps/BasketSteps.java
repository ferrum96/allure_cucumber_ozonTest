package ru.appline.autotests.steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Attachment;
import ru.appline.autotests.pages.BasketPage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.appline.autotests.utils.WriteReader.WriterReader.write;

public class BasketSteps {

    public BasketPage basketPage = new BasketPage();

    @Когда("^проверено наличие товаров$")
    public void наличие() throws Exception {
        new BasketPage().checkItems();
    }

    @Когда("^проверено, что поле \"(.+)\" имеет \"(.+)\"$")
    public void проверкаКоличестваТоваров(String field, String value) throws Exception {
        new BasketPage().checkValue(field, value);
    }

    @Когда("^выполнено нажатие на кнопку \"(.+)\"$")
    public void удалениеТоваров(String name) throws Exception {
        new BasketPage().removeItems(name);
    }

    @Тогда("^проверено, что поле \"(.+)\" имеет значение \"(.+)\"$")
    public void проверкаПустойКорзины(String field, String value) throws Exception {
        new BasketPage().checkValue(field, value);
    }
}
