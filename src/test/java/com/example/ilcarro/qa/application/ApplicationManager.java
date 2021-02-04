package com.example.ilcarro.qa.application;

import com.google.common.io.Files;
import com.sun.javafx.geom.Edge;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    Properties properties;
    static EventFiringWebDriver wd;
    UserHelper userHelper;
    CarHelper carHelper;
    private String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public static class MyListener extends AbstractWebDriverEventListener {

        HelperBase helperBase = new HelperBase(wd);
        public MyListener() {
            super ();
        }
        Logger logger = LoggerFactory.getLogger(MyListener.class);

        @Override
        public void beforeFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println("Start search" + by);
        }

        @Override
        public void afterFindBy(By by, WebElement element, WebDriver driver) {
            System.out.println(by + "found");
        }

        @Override
        public void onException(Throwable throwable, WebDriver wd) {
            logger.error(throwable.toString());

            String pathToScreenshot = "src/test/screenshorts/screen-" + System.currentTimeMillis()+ ".png";
            helperBase.takeScreenShort(pathToScreenshot);
            logger.error(pathToScreenshot);
            }
        }



    public ApplicationManager(String browser) {

        this.browser = browser;
        properties = new Properties();
    }


    public void start() throws IOException {
        String target  = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver ( new ChromeDriver());
            wd.register(new MyListener());
        }

        wd.navigate().to(properties.getProperty("web.baseURL")); //"https://ilcarro-dev-v1.firebaseapp.com/");
        logger.info("Opened site:" + wd.getCurrentUrl());
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);

    }


    public String setEmail(){
        return properties.getProperty("web.email");

    }

    public String setPassword(){
       return properties.getProperty("web.password");
    }



    public WebDriver stop() {
        return wd;
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }
    public CarHelper getCarHelper() {
        return carHelper;
    }
}
