package Library;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static String captureScreenshot(WebDriver driver,String screenshot) throws Exception
	{
		
			TakesScreenshot ts=(TakesScreenshot)driver;
			File src=ts.getScreenshotAs(OutputType.FILE);
			String dest="E:\\Screenshot\\Screenshots\\"+screenshot+".png";
			File destination=new File(dest);
			FileUtils.copyFile(src,destination);
			System.out.println("Screenshot Captured");
			return dest; 
	}
	

}
