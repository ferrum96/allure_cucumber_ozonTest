package ru.appline.autotests.steps;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.qameta.allure.Attachment;
import ru.appline.autotests.pages.ResultPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static ru.appline.autotests.utils.WriteReader.WriterReader.write;

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
        Thread.sleep(4000);
    }

    @Когда("^в корзину добавлено \"(.+)\" \"(.+)\" товаров$")
    public void добавитьВКорзину(String count, String chetnost) throws Exception {
        new ResultPage().addCart(count, chetnost);
    }

    @Когда("^в корзину добавлены все \"(.+)\" товары и выполнен переход в корзину$")
    public void добавитьВКорзину2(String chetnost) throws Exception {
        new ResultPage().addCart(chetnost);
    }

    @Тогда("^выполнен переход в корзину$")
    public void переходВКорзину() throws Exception {
        new ResultPage().gotoBasket();
    }

    @Тогда("^Купленные товары$")
    public void товары() throws Exception {
        write();
        getBytes("Products.txt");
    }

    @Attachment
    public static byte[] getBytes(String resourceName) throws IOException {
        return Files.readAllBytes(Paths.get("src/main/resources", resourceName));
    }
}
