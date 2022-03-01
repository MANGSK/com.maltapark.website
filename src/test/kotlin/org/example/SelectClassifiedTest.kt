package org.example

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.Assert
import org.testng.annotations.*/*
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test*/
import java.util.concurrent.TimeUnit

class SelectClassifiedTest {

    private var driver: WebDriver? = null
    private var selectClassified: GetSearchDetails? = null

    @BeforeClass
    fun intiPageObject(){
        selectClassified = GetSearchDetails(driver!!)
    }

    @BeforeTest
    fun setupDriverAndPage(){
        System.setProperty("webdriver.chrome.driver","src/test/kotlin/org/example/drivers/chromedriver.exe")
        driver = ChromeDriver()

        selectClassified = GetSearchDetails(driver!!)
    }
    @AfterTest
    fun closeDriver(){
        driver!!.quit()
    }

    @Test
    fun performSearch()
    {
        val url = "https://www.maltapark.com/"
        val classifiedDropdown: By = By.cssSelector("#searchselector")
        driver!!.get(url)
        Assert.assertEquals(driver!!.currentUrl, url,"Invalid web page")
        driver!!.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        selectClassified!!.selectDrop!!.click()
        selectClassified!!.selectBooks!!.click()
        selectClassified!!.enterText("Computer")
        selectClassified!!.submitRequest!!.click()
        selectClassified!!.firstItemDetails("test");
//        selectClassified!!.getPrice!!.getCssValue("getPrice")
        Thread.sleep(10000L)
    }
}