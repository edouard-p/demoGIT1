package org.projet_selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PageMyAccount {
	@FindBy (name="account.languagePreference")
	private WebElement liste_langue;
	@FindBy (name="account.favouriteCategoryId")
	private WebElement liste_animaux;
	@FindBy (name="account.listOption")
	private WebElement checkbox_enable_my_list;
	@FindBy (name="account.bannerOption")
	private WebElement checkbox_bannerOption;
	@FindBy (xpath="//h3")
	private WebElement titre_account;
	
	public void verifPageMyAccount() {
		Outils.verificationTextWebElement("User Information", titre_account);
	}


	public void choixLangue (String langue) {
	Select select = new Select(liste_langue);
	
	select.selectByVisibleText(langue);
	}
	public void choixAnimal (String animal) {
		Select select = new Select(liste_animaux);
		
		select.selectByVisibleText(animal);
	}
	
	public boolean getCheckbox(int i) {
		return checkboxes.get(i).isSelected();
	
	public void clickEnableMyList() {
		checkbox_enable_my_list.click();
	}
	}
