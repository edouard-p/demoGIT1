package org.projet_selenium;

import static org.junit.Assert.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Outils {

	public static void renseignerChamp(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}
	
	public static void verificationTextWebElement(String expected, WebElement we) {
		try{
			assertEquals(expected, we.getText());
		}
		catch(Error e) {
			System.out.println("[FAIL] verificationTextWebElement \n expected : "+expected+"\n real="+ we.getText());
			throw e;
		}
	}
	
	public static void clickMyAccount() {
		
	}
	
	
	
	
	
}
