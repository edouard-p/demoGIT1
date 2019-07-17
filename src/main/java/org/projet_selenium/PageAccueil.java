package org.projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;


public class PageAccueil extends PageAccesAccount {
	@FindBy(xpath = "//font")
	private WebElement message_bienvenue;
	
	@FindBy(xpath = "//img[contains(@src,'fish_icon.gif')]")
	private WebElement icon_fish;

	public PageMyAccount clickMyAccount;
	
	public void verificationMessageBienvenue() {
		Outils.verificationTextWebElement("Welcome ABC!", message_bienvenue);;
	}
	public PageCategorie clickCategorie(WebDriver driver) {
		  icon_fish.click();
		  return PageFactory.initElements(driver, PageCategorie.class);
	  }
	
	}

