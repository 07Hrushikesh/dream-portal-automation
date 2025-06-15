package DreamProject.Dream;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Summary_Page {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://arjitnigam.github.io/myDreams/");
		Thread.sleep(4000);

		WebElement Mydream_button = driver.findElement(By.xpath("//button[@id='dreamButton']"));

		Mydream_button.click();

		Set<String> windowIDs = driver.getWindowHandles();

		List<String> windowlist = new ArrayList<String>(windowIDs);

		String ChildID2 = windowlist.get(2);

		// Switch to child2 window
		driver.switchTo().window(ChildID2);
		System.out.println(driver.getTitle());

		// Good Dreams

		String actgddrms_no = driver.findElement(By.xpath("//table[@id='dreamsTotal']//tbody/tr[1]/td[2]")).getText();
		int expgddrms_no = 6;

		int actgddrms_no_int = Integer.parseInt(actgddrms_no); // convert string to int

		if (actgddrms_no_int == expgddrms_no) {
			System.out.println("Good Dreams: 6");
		} else {
			System.out.println("Mismatch: Expected 6, but found " + actgddrms_no_int);
		}

		// Thread.sleep(5000);

		// Bad Dreams

		String actbddrms_no = driver.findElement(By.xpath("//table[@id='dreamsTotal']//tbody/tr[2]/td[2]")).getText();
		int expbddrms_no = 4;

		int actbddrms_no_int = Integer.parseInt(actbddrms_no);

		if (actbddrms_no_int == expbddrms_no) {
			System.out.println("Bad Dreams: 4");
		} else {
			System.out.println("Mismatch: Expected 4, but found " + actbddrms_no_int);
		}

		// Total Dreams

		String act_total_drms_no = driver.findElement(By.xpath("//table[@id='dreamsTotal']//tbody/tr[3]/td[2]"))
				.getText();
		int exp_total_drms_no = 10;

		int act_total_drms_no_int = Integer.parseInt(act_total_drms_no);

		if (act_total_drms_no_int == exp_total_drms_no) {
			System.out.println("Total Dreams: 10");

		} else {
			System.out.println("Mismatch: Expected 10, but found " + act_total_drms_no_int);
		}

		// Recurring Dreams

		String act_recurr_drms_no = driver.findElement(By.xpath("//table[@id='dreamsTotal']//tbody/tr[5]/td[2]"))
				.getText();
		int exp_recurr_drms_no = 2;

		int act_recurr_drms_no_int = Integer.parseInt(act_recurr_drms_no);

		if (act_recurr_drms_no_int == exp_recurr_drms_no) {
			System.out.println("Recurring Dreams: 2");

		} else {
			System.out.println("Mismatch: Expected 2, but found " + act_recurr_drms_no_int);

		}

	}

}
