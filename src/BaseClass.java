import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		Login login = new Login();
		SelectProduct selectPrd = new SelectProduct();
		login.loginUser(driver);
		selectPrd.selectHighestPriceProduct(driver);
		selectPrd.selectLowestPriceProduct(driver);
		
	}

}
