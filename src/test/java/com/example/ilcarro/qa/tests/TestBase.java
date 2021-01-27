package com.example.ilcarro.qa.tests;

import com.example.ilcarro.qa.application.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.start();
    }

    @BeforeMethod
    public void startLogger (Method m){
       logger.info("Start test" + m.getName() + "\n ==============================================");
    }

    @AfterMethod (alwaysRun = true)
    public void stopLogger (Method m){
        logger.info("Stop test" + m.getName() + "\n +++++++++++++++++++++++++++++++++++++++++++++");
    }

    @AfterSuite
    public void tearDown() {
        app.stop().quit();
    }

}
