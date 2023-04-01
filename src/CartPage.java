import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	public void gotoCart(WebDriver driver) {

		driver.findElement(By.cssSelector("a.shopping_cart_link")).click();

	}

	public int removeProduct(WebDriver driver, String product) throws InterruptedException {

		List<WebElement> cartProducts = driver.findElements(By.cssSelector("div.cart_item" + " div a"));
		int totalCartProducts = cartProducts.size();

		for (int i = 0; i < totalCartProducts; i++) {

			String name = cartProducts.get(i).getText();
			if (name.equals(product)) {

				driver.findElements(By.xpath("//button[text()='Remove']")).get(i).click();

			}
		}

		return totalCartProducts;
	}

	public double getPrice(WebDriver driver, String product) {

		String price = "01";
		List<WebElement> cartProducts = driver.findElements(By.cssSelector("div.cart_item" + " div a"));
		int totalCartProducts = cartProducts.size();

		for (int i = 0; i < totalCartProducts; i++) {

			String name = cartProducts.get(i).getText();

			if (name.equals(product)) {

				price = driver.findElements(By.cssSelector(".cart_item div.inventory_item_price")).get(i).getText();

			}
		}

		String splittedPrice = price.substring(1);
		double productPrice = Double.parseDouble(splittedPrice);

		return productPrice;
	}
		public void checkOut(WebDriver driver) 
		{
			driver.findElement(By.id("checkout")).click();
		}
}
