import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Login {
	
	public String username = "standard_user";
	String password = "secret_sauce";
	String url = "https://www.saucedemo.com/";
	
	public void loginUser(WebDriver driver) {
		
	    
		driver.get(url);
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
	}
 
}
