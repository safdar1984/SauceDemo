import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOut {
	
	Login login = new Login();
	String name = login.username;
	
	public void checkOutPage(WebDriver driver) throws InterruptedException {
				
		driver.findElement(By.name("firstName")).sendKeys(login.username);
		driver.findElement(By.id("last-name")).sendKeys("Last Name");
		driver.findElement(By.id("postal-code")).sendKeys("44000");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[type='submit']")).click();
	}
	
	public void compareProducts(WebDriver driver) {
		String productsCount = driver.findElement(By.cssSelector("a.shopping_cart_link")).getText();
		int prdCount = Integer.parseInt(productsCount);

		int prdinList = driver.findElements(By.cssSelector(".cart_item")).size();
	
		if(prdCount == prdinList) {
			
			System.out.println("Products are equal");
		}else {
			
			System.out.println("Products are not equal");
		}
	}

}
