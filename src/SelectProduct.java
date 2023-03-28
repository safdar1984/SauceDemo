import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectProduct {

	public void selectHighestPriceProduct(WebDriver driver) throws InterruptedException {
		WebElement dropdown = driver.findElement(By.className("product_sort_container"));

		Select select = new Select(dropdown);
		select.selectByVisibleText("Price (high to low)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='inventory_item']//button")).click();

	}

	public void selectLowestPriceProduct(WebDriver driver) throws InterruptedException {

		WebElement dropdown = driver.findElement(By.className("product_sort_container"));

		Select select = new Select(dropdown);
		select.selectByVisibleText("Price (low to high)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='inventory_item']//button")).click();

	}
}
