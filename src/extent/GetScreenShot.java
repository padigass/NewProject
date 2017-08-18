package extent;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class GetScreenShot extends MainTest {

	public static String takeScreenShot(WebDriver driver, String screenShotName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String imageName = System.currentTimeMillis() + ".png";
		File source = ts.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir") + "\\screenshot\\" + imageName;
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		return dest;
	}

}