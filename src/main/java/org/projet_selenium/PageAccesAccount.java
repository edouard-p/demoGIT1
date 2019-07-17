package org.projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageAccesAccount {
@FindBy (name="img_myaccount")
private WebElement Bouton_My_Account;

@FindBy(name="img_signin")
private WebElement signin_button;

@FindBy(name="img_signout")
private WebElement signout_button;


public PageLogin clicSignin(WebDriver driver) {
	signin_button.click();
	return PageFactory.initElements(driver, PageLogin.class);

}

public PageMyAccount clickMyAccount (WebDriver driver, String username, String password) {
	try {
		Bouton_My_Account.click();
		}
	catch(Exception e){
		System.out.println("Le bouton My account n'est pas visible");
		PageLogin pl=clicSignin(driver);
		pl.connexion(driver, username, password);
		assertTrue(signout_button.isDisplayed());
		Bouton_My_Account.click();
	}
	
Bouton_My_Account.click();
return PageFactory.initElements(driver, PageMyAccount.class);
}

}
