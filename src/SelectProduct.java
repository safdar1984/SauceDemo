import java.util.List;

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
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inventory_item']//button")).click();

	}

	public void selectLowestPriceProduct(WebDriver driver) throws InterruptedException {

		WebElement dropdown = driver.findElement(By.className("product_sort_container"));

		Select select = new Select(dropdown);
		select.selectByVisibleText("Price (low to high)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inventory_item']//button")).click();

	}

	public void selectZtoAProduct(WebDriver driver) throws InterruptedException {
		WebElement dropdown = driver.findElement(By.className("product_sort_container"));

		Select select = new Select(dropdown);
		select.selectByVisibleText("Name (Z to A)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inventory_item']//button")).click();

	}

	public void selectAtoZProduct(WebDriver driver) throws InterruptedException {
		WebElement dropdown = driver.findElement(By.className("product_sort_container"));

		Select select = new Select(dropdown);
		select.selectByVisibleText("Name (A to Z)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='inventory_item']//button")).click();

	}

	public void selectRemainingProducts(WebDriver driver) {
		
		List<WebElement> addToCartButtons = driver
				.findElements(By.xpath("//div[@class='inventory_list']//button[contains(text(), 'Add to cart')]"));

		for (WebElement e : addToCartButtons) {

			e.click();
		}

	}
}
