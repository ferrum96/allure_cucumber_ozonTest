package ru.appline.autotests.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import ru.appline.autotests.utils.DriverManager;

public class Hooks {

    @Before
    public static void before() {
        DriverManager.getDriver();
    }

    @After
    public static void after() throws Exception {
        DriverManager.quitDriver();
    }

}
