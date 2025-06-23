package JUnit.AddressBook810;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddressBookRemoveGroupTest {

	private  WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));


	public void setUp(WebDriver driver) {
		this.driver.quit();
		this.driver=driver;
		js = (JavascriptExecutor) driver;
	}

	@Test
	public void addressBookRemoveGroup() throws Exception {

		driver.get("http://localhost:3000/index.php");
		//driver.findElement(By.name("user")).sendKeys("admin");
		//driver.findElement(By.name("pass")).sendKeys("secret");
		//driver.findElement(By.xpath(".//*[@id='content']/form/input[3]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("gruppi")));
		driver.findElement(By.linkText("gruppi")).click();
		driver.findElement(By.name("selected[]")).click();
		driver.findElement(By.name("delete")).click();
		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/div")).getText()
				.matches("^Group has been removed\\.[\\s\\S]*$"));
	}

	public void tearDown() throws Exception {
		driver.quit();
	}

}
