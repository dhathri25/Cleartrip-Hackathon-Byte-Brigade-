package com.cleartrip.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cleartrip.base.BaseClass;
import com.cleartrip.pages.FlightSearchPage;
import com.cleartrip.utils.Listeners;

public class FlightSearchTest extends BaseClass {
    private FlightSearchPage flight;

    @BeforeMethod
    public void start() {
        setup();
        flight = new FlightSearchPage(driver);
    }

    @Test
    public void searchFlightTest() {
        System.out.println("Step 1 : Opening Cleartrip application");
        Listeners.getTest().info("Navigating to Cleartrip web platform.");
        
        flight.closePopup();
        System.out.println("Step 2 : Sign-in popup handled");
        flight.closeCookieBanner();
        System.out.println("Cookie banner handled");

        flight.selectOneWay();
        System.out.println("Step 3 : One Way journey selected");

        String fromLocation = config.getProperty("fromCity");
        String toLocation = config.getProperty("toCity");

        flight.enterFromCity(fromLocation);
        System.out.println("Step 4 : From city selected (" + fromLocation + ")");
        flight.enterToCity(toLocation);
        System.out.println("Step 4 : To city selected (" + toLocation + ")");

        flight.selectDate();
        
        flight.clickSearch();
        System.out.println("Step 6 : Search Flights button clicked");

        boolean result = flight.validateResults();
        Assert.assertEquals(result, true, "Validation Failure: Flight results matrix page did not populate.");
        
        System.out.println("Test completed successfully");
    }

    @AfterMethod
    public void stop() {
        tearDown();
    }
}