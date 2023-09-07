import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import dev.failsafe.internal.util.Assert;

public class BaseClass {

	@Test
	public void SauceDemo() throws InterruptedException {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\sra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		  
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*");
		  WebDriver driver = new ChromeDriver(options);
		 

		/*
		 * System.setProperty("webdriver.edge.driver",
		 * "C:\\Users\\sra\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		 * 
		 * EdgeOptions options = new EdgeOptions();
		 * options.addArguments("--remote-allow-origins=*"); WebDriver driver = new
		 * EdgeDriver(options);
		 */
		
		driver.manage().window().maximize();
		String product = "Sauce Labs Fleece Jacket";
		//Updated on April 12

		Login login = new Login();
		SelectProduct selectPrd = new SelectProduct();
		CartPage cartpage = new CartPage();
		CheckOut checkout = new CheckOut();
		login.loginUser(driver);
		selectPrd.selectHighestPriceProduct(driver);
		selectPrd.selectLowestPriceProduct(driver);
		selectPrd.selectAtoZProduct(driver);
		selectPrd.selectZtoAProduct(driver);

		cartpage.gotoCart(driver);

		System.out.println("Product price is " + cartpage.getPrice(driver, product));

		double productPrice = cartpage.getPrice(driver, product);

		if (productPrice > 5) {

			cartpage.removeProduct(driver, product);

		} else {

			System.out.println(productPrice + " is price");

		}

		driver.findElement(By.cssSelector("#continue-shopping")).click();
		Thread.sleep(2000);

		selectPrd.selectRemainingProducts(driver);
		cartpage.gotoCart(driver);
		cartpage.checkOut(driver);
		checkout.checkOutPage(driver);
		checkout.compareProducts(driver);
		String[] checkoutInfo = checkout.getCheckoutInfo(driver);
		for (String b : checkoutInfo) {
			System.out.println(b);
		}
		checkout.finish(driver);
		String[] confirmText = checkout.ConfirmationText(driver);

		confirmText[0].equalsIgnoreCase("Thank you for your order!");
		confirmText[1]
				.equals("Your order has been dispatched, and will arrive just as fast as the pony can get there!");

	}

	/*
	 * @BeforeMethod public void beforeMethod() {
	 * 
	 * }
	 */

}
