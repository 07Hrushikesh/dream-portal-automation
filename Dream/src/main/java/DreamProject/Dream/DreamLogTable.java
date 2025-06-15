package DreamProject.Dream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DreamLogTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://arjitnigam.github.io/myDreams/");
		Thread.sleep(4000);

		WebElement Mydream_button = driver.findElement(By.xpath("//button[@id='dreamButton']"));

		Mydream_button.click();

		Set<String> windowIDs = driver.getWindowHandles();

		List<String> windowlist = new ArrayList<String>(windowIDs);

		String ChildID1 = windowlist.get(1);

		// Switch to child1 window
		driver.switchTo().window(ChildID1);
		System.out.println(driver.getTitle());

		List<WebElement> Elements = driver.findElements(By.xpath("//table[@id='dreamsDiary']//tbody/tr"));
		System.out.println(Elements.size());

		int dream_entries = 10;

		if (dream_entries == Elements.size()) {
			System.out.println("There are exactly 10 dream entries.");
		} else {
			System.out.println("There are not exactly 10 dream entries.");
		}

		// Dream types GOOD OR BAD

		String Good = driver.findElement(By.xpath("//table[@id='dreamsDiary']//tbody/tr[1]/td[3]")).getText();
		String Bad = driver.findElement(By.xpath("//table[@id='dreamsDiary']//tbody/tr[2]/td[3]")).getText();

		if (Good.equalsIgnoreCase("Good") && Bad.equalsIgnoreCase("Bad")) {

			System.out.println("The dream types are only “Good” or “Bad”.");

		} else {

			System.out.println("The dream types are not only “Good” or “Bad”.");
		}

		// Each row has all three columns filled: Dream Name, Days Ago, Dream Type.

		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='dreamsDiary']//thead/tr/th"));

		for (WebElement element : columns) {

			String colum = element.getText();

			if (colum.equalsIgnoreCase("Dream Name") || colum.equalsIgnoreCase("Days Ago")
					|| colum.equalsIgnoreCase("Dream Type")) {

				System.out.println("All are fill ed with Dream Name, Days Ago, Dream Type");

			} else {
				System.out.println("All are not fill ed with Dream Name, Days Ago, Dream Type");
			}

		}

	}

}
