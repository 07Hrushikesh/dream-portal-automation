package DreamProject.Dream;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mydream {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://arjitnigam.github.io/myDreams/");

		WebElement loading = driver.findElement(By.xpath("//div[@id='loadingAnimation']"));

		if (loading.isDisplayed()) {
			System.out.println("loading animation appears");
		} else {
			System.out.println("loading animation not appears");
		}

		Thread.sleep(4000);

		WebElement Main_content = driver.findElement(By.xpath("//div[@id='mainContent']"));
		WebElement Mydream_button = driver.findElement(By.xpath("//button[@id='dreamButton']"));

		if (Main_content.isDisplayed() && Mydream_button.isDisplayed()) {
			System.out.println("Main content & Dream button is visible");

		} else {
			System.out.println("Not Visible");
		}

		Mydream_button.click();

		boolean totalFound = false;
		boolean portalFound = false;

		Set<String> windowIDs = driver.getWindowHandles();

		for (String winid : windowIDs) {
			driver.switchTo().window(winid);
			String title = driver.getTitle();

			if (title.equalsIgnoreCase("Dreams Total")) {
				totalFound = true;
			}

			if (title.equalsIgnoreCase("Dream Portal")) {
				portalFound = true;
			}
		}

		if (totalFound && portalFound) {
			System.out.println("Verified: Both 'Dreams Total' and 'Dream Portal' windows are displayed.");
		} else {
			System.out.println("One or both windows are missing.");
		}

	}

}
