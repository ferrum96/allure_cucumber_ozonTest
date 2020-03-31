package ru.appline.autotests.steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import ru.appline.autotests.pages.BasketPage;
import ru.appline.autotests.pages.ResultPage;

public class BasketSteps {

    public BasketPage basketPage = new BasketPage();

    @Когда("^проверено наличие товаров$")
    public void наличие() throws Exception {
        basketPage.checkItems();
    }

    @Когда("^проверено, что поле \"(.+)\" имеет \"(.+)\"$")
    public void проверка(String field, String value) throws Exception {
        basketPage.checkValue(field, value);
    }

    @Когда("^выполнено нажатие на кнопку \"(.+)\"$")
    public void удалениеТоваров(String name) throws Exception {
        basketPage.removeItems(name);
    }

    @Тогда("^проверено, что поле \"(.+)\" имеет значение \"(.+)\"$")
    public void проверка2(String field, String value) throws Exception {
        basketPage.checkValue(field, value);
    }

    @Тогда("^выполнен переход в корзину$")
    public void переходВКорзину() throws Exception {
        new ResultPage().gotoBasket();
    }
}
