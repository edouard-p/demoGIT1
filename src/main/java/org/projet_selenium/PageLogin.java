package org.projet_selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLogin {

	  @FindBy(name="username")
	  private WebElement username_field;

	  @FindBy(name="password")
	  private WebElement password_field;
	  
	  @FindBy(name="update")
	  private WebElement button_submit;
	  
	  
	  public PageAccueil connexion(WebDriver driver, String username, String password) {
		  Outils.renseignerChamp(username_field, username);
		  Outils.renseignerChamp(password_field, password);
		  button_submit.click();
		  return PageFactory.initElements(driver, PageAccueil.class);
	  }
	  

//		public PageLogin clicSignin(WebDriver driver) {
//			signin_button.click();
//			return PageFactory.initElements(driver, PageLogin.class);	  
	  
}
