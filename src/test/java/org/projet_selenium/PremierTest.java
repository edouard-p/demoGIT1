package org.projet_selenium;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

public class PremierTest {

	
	WebDriver driver;
	String b = "firefox";
	String url= "http://localhost:8090/jpetstore-1.0.5-env2/";
	
	@Before
	public void setUp() {
		System.out.println("\n@Before");
		choisirNavigateur(b);
	}
	
	//@After
	public void tearDown(){
		System.out.println("\n@After");
		driver.close();
	}
	
	@Test
	
	public void testPageObject(){
		driver.get(url);	
		PageIndex page_index = PageFactory.initElements(driver, PageIndex.class);
		PageLogin page_login = page_index.clicSignin(driver);
		 
		PageAccueil page_accueil = page_login.connexion(driver, "j2ee", "j2ee");
		page_accueil.verificationMessageBienvenue();
		PageCategorie page_categorie = page_accueil.clickCategorie(driver);
		page_categorie.verification_liste_produit(4);
		PageProduit page_produit=page_categorie.selectionnerUnProduit(1, driver);
		PagePanier page_panier=page_produit.clickaddtocart(driver);
		page_panier.verificationTitreDeLaPage();
		page_panier.modifierQuantite("2");
		page_panier.compare();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Ignore
	public void interactionBasique() throws Exception {	
		
		// ACTION : Accéder à l’application Jpetstore et se connecter en tant que j2ee/j2ee
		driver.get(url);
		WebElement we_button_signin=driver.findElement(By.name("img_signin"));
		we_button_signin.click();
		
		WebElement field_username=driver.findElement(By.name("username"));
		WebElement field_password=driver.findElement(By.name("password"));
		WebElement button_submit=driver.findElement(By.name("update"));
		
		renseignerChamp(field_username,"j2ee");
		renseignerChamp(field_password,"j2ee");
		
		button_submit.click();
		
		// VERIFICATION : L’utilisateur « ABC » est bien connecté (apparition d’un message de bienvenu et du lien « Sign out »)
		try {
		WebElement msg_welcome=driver.findElement(By.xpath("//font"));
		driver.findElement(By.name("img_signout")).isDisplayed();
		assertEquals("[FAIL] le message de bienvenu n'est correctement affiché","Welcome ABC!", msg_welcome.getText());
		}
		catch(Error ae) {
			System.out.println("[FAIL] le message de bienvenu n'est correctement affiché");
		throw ae;
		}
		catch(Exception e) {
			System.out.println("[FAIL] l'utilisateur n'est pas loggué");
		throw e;
		}
		
		
		// ACTION : Sélectionner la  catégorie Fish
		driver.findElement(By.xpath("//img[contains(@src,'fish_icon.gif')]")).click();
		
		// VERIFICATION : Affichage de la liste des produit disponible pour la catégorie Fish
		List<WebElement> listProduit= driver.findElements(By.xpath("//table/tbody/tr[descendant::font[contains(.,'FI')]]"));
		assertFalse(listProduit.isEmpty());
		assertEquals(4,listProduit.size());
		
		for(WebElement e : listProduit) {
			System.out.println(e.getText());
		}
		
		// ACTION : Sélectionner le produit de votre choix
		//listProduit.get(0).click();
		driver.findElement(By.xpath("//table/descendant::*[contains(.,'Product ID')]/descendant::a[1]")).click();
		
		// ACTION : Ajouter un item au panier (« add to cart »)
		driver.findElement(By.xpath("//td/a[contains(@href,'Id=EST-1')]")).click();
		
		// VERIFICATION : Affichage du panier
		assertTrue("[FAIL] le panier ne s'affiche pas", driver.findElement(By.xpath("//h2[.='Shopping Cart']")).isDisplayed());
		
		// ACTION : Passer la quantité commandée à 2 et cliquer sur « update cart »
		WebElement field_quantity=driver.findElement(By.name("EST-1"));
		renseignerChamp(field_quantity, "2");
		driver.findElement(By.name("update")).click();
		
		// VERIFICATION : Le prix total est égal au double du prix à l’unité
		
		String unit_price= driver.findElement(By.xpath("//td[contains(text(),'$')][1]")).getText();	
		String total_price= driver.findElement(By.xpath("//td[contains(text(),'$')][2]")).getText();
		
		unit_price=unit_price.substring(1).replace(",", ".");
		total_price=total_price.substring(1).replace(",", ".");
		
		double d_unit_price=Double.parseDouble(unit_price);
		double d_total_price=Double.parseDouble(total_price);
		
		assertTrue("[Fail] Le double du prix unitaire n'est pas égal au prix total",d_total_price==2*d_unit_price);
		
		
		
	}

	
	public void choisirNavigateur(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/driver/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			System.out.println("browser mal renseigné");
		}
	}
	
	public void renseignerChamp(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}
}