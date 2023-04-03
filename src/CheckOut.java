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
	public String[] getCheckoutInfo(WebDriver driver) {
		
		String paymentInfo = driver.findElement(By.xpath("//div[@class='summary_value_label'][1]")).getText();
		String shippingInfo = driver.findElement(By.xpath("//div[@class='summary_value_label'][2]")).getText();
		String totalPrice = driver.findElement(By.cssSelector("div.summary_info_label.summary_total_label")).getText();
		
		String[] checkoutInfo = new String[3];
		
		checkoutInfo[0] = paymentInfo;
		checkoutInfo[1] = shippingInfo;
		checkoutInfo[2] = totalPrice;
		return checkoutInfo;
		
	}
	public void finish(WebDriver driver) {
		
		driver.findElement(By.cssSelector("button#finish")).click();
	}
	public String[] ConfirmationText(WebDriver driver) {
		
		String[] confirmationText = new String[2];
		confirmationText[0] = driver.findElement(By.cssSelector("h2.complete-header")).getText();
		confirmationText[1] = driver.findElement(By.cssSelector("div.complete-text")).getText();
		return confirmationText;
	}

}
