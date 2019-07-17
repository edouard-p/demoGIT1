package org.projet_selenium;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PagePanier {
	@FindBy (xpath="//h2")
	WebElement title;
	
	@FindBy (xpath = "//td[contains(text(),'$')][1]")
	private WebElement unit_price;
	
	@FindBy (xpath = "//td[contains(text(),'$')][2]")
	private WebElement total_price;
	
	@FindBy (xpath = "//input[contains(@name,'EST')]")
	private WebElement field_quantity;
	
	@FindBy (name = "update")
	private WebElement update_button;
	
public void verificationTitreDeLaPage() {
	Outils.verificationTextWebElement("Shopping Cart", title);
}

public void modifierQuantite(String quantite) {
	
	Outils.renseignerChamp(field_quantity, quantite);
	update_button.click();
	
}


public void compare() {
	
	String s_unit_price =  unit_price.getText().substring(1).replace(",", ".");
	String s_total_price = total_price.getText().substring(1).replace(",", ".");
	
	double d_unit_price=Double.parseDouble(s_unit_price);
	double d_total_price=Double.parseDouble(s_total_price);

assertTrue("[Fail] Le double du prix unitaire n'est pas égal au prix total",d_total_price==2*d_unit_price);

}
}

