package extent;

import java.util.Locale;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class MainTest {
	
	String className = "report";
    static WebDriver driver;
    ExtentReports reporter;
    
    public void on(String a,String b){
    	if(a=="report"){
    		reporter = new ExtentReports("build/"+b+".html", true, DisplayOrder.NEWEST_FIRST, NetworkMode.ONLINE,
    				Locale.ENGLISH);
    		className = b;
    	}
    }

}
