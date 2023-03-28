import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		String product = "Sauce Labs Backpack";

		Login login = new Login();
		SelectProduct selectPrd = new SelectProduct();
		CartPage cartpage = new CartPage();
		login.loginUser(driver);
		selectPrd.selectHighestPriceProduct(driver);
		selectPrd.selectLowestPriceProduct(driver);
		selectPrd.selectAtoZProduct(driver);
		selectPrd.selectZtoAProduct(driver);

		cartpage.gotoCart(driver);

		String foundProduct = cartpage.FindProduct(driver);

		if (product.equals(foundProduct)) {

			double productPrice = cartpage.getPrice(driver);

			if (productPrice > 25) {
				
				cartpage.removeProduct(driver);
				
			} else {
				
				System.out.println(productPrice + " is price");
				
			}

		} else {

			System.out.println("Product doesn't match");
		}
	}

}
