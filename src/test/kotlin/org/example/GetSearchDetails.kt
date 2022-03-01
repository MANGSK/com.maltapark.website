package org.example

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class GetSearchDetails (val driver: WebDriver){
    init{
    PageFactory.initElements(driver,this)
    }


    @FindBy(css = "#searchselector")
    var selectDrop: WebElement? = null

    @FindBy(xpath = "//div[normalize-space()='Books']")
    var selectBooks: WebElement? = null

    @FindBy(css = "#search")
    var inputText: WebElement? = null

    @FindBy(xpath = "//button[@type='submit']")
    var submitRequest: WebElement? = null

    @FindBy(xpath = "//div[contains(@class,'item featured e3 e2')]//div[@class='content']")
    var getDetails: WebElement? = null

    @FindBy(xpath = "//div[contains(@class,'item featured e3 e2')]//span[@class='pricerow']")
    var getPrice: WebElement? = null

    fun enterText(value: String){
        inputText!!.sendKeys(value)
    }
    fun firstItemDetails(value: String) {
        var desc = getDetails!!.text
        print(desc)
    }
}