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

public class AddressBookAddGroupTest {

	private  WebDriver driver = new ChromeDriver();
	JavascriptExecutor js = (JavascriptExecutor) driver;

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));


	public void setUp(WebDriver driver) {
		this.driver.quit();
		this.driver=driver;
		js = (JavascriptExecutor) driver;
	}


	@Test
	public void addressBookAddGroup() throws Exception {
		driver.get("http://localhost:3000/index.php");
		//driver.findElement(By.name("user")).sendKeys("admin");
		//driver.findElement(By.name("pass")).sendKeys("secret");
		//driver.findElement(By.xpath(".//*[@id='content']/form/input[3]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("gruppi")));
		driver.findElement(By.linkText("gruppi")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("new")));
		driver.findElement(By.name("new")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("group_name")));
		driver.findElement(By.name("group_name")).clear();
		driver.findElement(By.name("group_name")).sendKeys("Group");
		driver.findElement(By.name("group_header")).clear();
		driver.findElement(By.name("group_header")).sendKeys("Header");
		driver.findElement(By.name("group_footer")).clear();
		driver.findElement(By.name("group_footer")).sendKeys("Footer");
		driver.findElement(By.name("submit")).click();
		assertTrue(driver.findElement(By.xpath(".//*[@id='content']/div")).getText()
				.contains("A new group has been entered into the address book"));
		driver.findElement(By.linkText("group page")).click();
	}

	public void tearDown() throws Exception {
		driver.quit();
	}
}
