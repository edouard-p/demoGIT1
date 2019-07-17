package org.projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageProduit {
@FindBy (xpath="//td/a[contains(@href,'Id=EST')]")
WebElement buttonaddtocart;




public PagePanier clickaddtocart(WebDriver driver) {
	buttonaddtocart.click();
	return PageFactory.initElements(driver, PagePanier.class);
}
}
