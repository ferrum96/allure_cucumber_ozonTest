package ru.appline.autotests.steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import ru.appline.autotests.pages.ResultPage;

public class ResultSteps extends ResultPage {

    @Когда("^поле \"(.+)\" ограничено до \"(.+)\"$")
    public void заполнениеПоля(String name, String value) throws Exception {
        new ResultPage().fillField(name, value);
    }

    @Когда("^выбраны чекбоксы \"(.+)\" , \"(.+)\"$")
    public void чекбоксы(String name1, String name2) throws Exception {
        new ResultPage().jsClick("Высокий рейтинг");
        new ResultPage().jsClick("NFC");
    }

    @Когда("^выбраны чекбоксы \"(.+)\", \"(.+)\"$")
    public void чекбоксы2(String name1, String name2) throws Exception {
        new ResultPage().jsClick(showAll);
        new ResultPage().jsClick(name1);
        new ResultPage().jsClick(name2);
    }

    @Когда("^в корзину добавлено \"(.+)\" \"(.+)\" товаров$")
    public void добавитьВКорзину(String count, String chetnost) throws Exception {
        new ResultPage().addCart(count, chetnost);
    }

    @Когда("^в корзину добавлены все \"(.+)\" товары$")
    public void добавитьВКорзину2(String chetnost) throws Exception {
        new ResultPage().addCart(chetnost);
    }

    @Тогда("^выполнен переход в корзину$")
    public void переходВКорзину() throws Exception {
        new ResultPage().gotoBasket();
    }
}
