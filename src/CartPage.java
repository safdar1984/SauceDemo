import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	
	public void gotoCart(WebDriver driver) {
		
		driver.findElement(By.cssSelector("a.shopping_cart_link")).click();
		
	}
	
	public String FindProduct(WebDriver driver) {
		
		String text = driver.findElement(By.xpath("//div[@class='cart_item']//a")).getText();
		return text;
	}

	public double getPrice(WebDriver driver) {
		
		String price = driver.findElement(By.xpath("//div[@class='cart_item']//div[@class='inventory_item_price']")).getText();
		
		String splittedPrice = price.substring(1);
		double productPrice = Double.parseDouble(splittedPrice);
	
		return productPrice;
	}
	public void removeProduct(WebDriver driver) {
		
		driver.findElement(By.xpath("//div[@class='cart_item']//button")).click();
	}
}
