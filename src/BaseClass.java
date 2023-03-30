import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		String product = "Test.allTheThings() T-Shirt (Red)";

		Login login = new Login();
		SelectProduct selectPrd = new SelectProduct();
		CartPage cartpage = new CartPage();
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

	}

}
