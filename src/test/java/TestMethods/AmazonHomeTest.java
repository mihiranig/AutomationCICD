package TestMethods;

import BasePageClasses.AmazonHome;
import BasePageClasses.BaseClass;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import javax.imageio.ImageIO;

public class AmazonHomeTest extends BaseClass {

	private AmazonHome amazonHome;
	
	
	@Test
	public void testDeliverToCountry() throws InterruptedException, IOException {
//new Comment
		amazonHome = new AmazonHome(driver);
		amazonHome.amazonSelectDeliverTo();
		amazonHome.selectCountry("Sweden");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		amazonHome.closeCountryList();
        driver.navigate().refresh();

		SoftAssert verifyCountryAssert = new SoftAssert();

		String expectedCountry = "Sweden";

		String actualCountry = amazonHome.getCountryText();

		verifyCountryAssert.assertEquals(actualCountry, expectedCountry, "mismatch of selected country and visible country");
		verifyCountryAssert.assertAll();

	}




	public static BufferedImage readImage(String imageName) throws IOException {
		BufferedImage rImage = ImageIO.read(new File(System.getProperty("user.dir") +"\\Images\\"+imageName));
		return rImage;

	}

}
