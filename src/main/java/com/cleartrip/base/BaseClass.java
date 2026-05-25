package com.cleartrip.base;

import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.cleartrip.utils.ConfigReader;

public class BaseClass {
    public static WebDriver driver;
    public ConfigReader config;

    public void setup() {
        config = new ConfigReader();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        String appUrl = config.getProperty("url");
        if (appUrl == null) {
            throw new RuntimeException("URL property fetched from config is null! Check config.properties keys.");
        }
        driver.get(appUrl);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}