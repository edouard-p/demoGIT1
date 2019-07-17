package org.projet_selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageCategorie {
	@FindBy(xpath = "//font[@color='BLACK'][not(@size)]")
	private List<WebElement> listProduit;
	
	public void verification_liste_produit(int nb_ref) {
		assertFalse(listProduit.isEmpty());
		assertEquals(nb_ref,listProduit.size());
		
		for(WebElement e : listProduit) {
			System.out.println(e.getText());
		}
		
	}
	public PageProduit selectionnerUnProduit(int index, WebDriver toto) {
		listProduit.get(index).click();
		return PageFactory.initElements(toto, PageProduit.class);
	}
	
}
