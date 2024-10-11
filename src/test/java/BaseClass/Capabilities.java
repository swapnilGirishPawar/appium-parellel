package BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class Capabilities {
    public ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
    public void setDriver(AppiumDriver driver) {
        this.driver.set(driver);
    }
    public AppiumDriver getDriver() {
        return driver.get();
    }
    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
    @BeforeMethod
    @Parameters({"deviceName", "platformName", "portNumber"})
    public void initiateDriver(String deviceName, String platformVersion, String portNumber, String udid) throws MalformedURLException {
        starAppiumService(portNumber);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", ".Calculator");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("systemPort", portNumber);
        setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"), desiredCapabilities));
    }


    @BeforeMethod
    @Parameters({"deviceName", "platformName", "portNumber"})
    public void initiateDriverinAndroid(String deviceName, String platformVersion, String portNumber, String udid) throws MalformedURLException {
        starAppiumService(portNumber);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", ".Calculator");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("systemPort", portNumber);
        setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"), desiredCapabilities));
    }


    @BeforeMethod
    @Parameters({"deviceName", "platformName", "portNumber"})
    public void initiateDriveriniOS(String deviceName, String platformVersion, String portNumber, String udid) throws MalformedURLException {
        starAppiumService(portNumber);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", ".Calculator");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("systemPort", portNumber);
        setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"), desiredCapabilities));
    }


    @BeforeMethod
    @Parameters({"deviceName", "platformName", "portNumber"})
    public void initiateDriverinCloud(String deviceName, String platformVersion, String portNumber, String udid) throws MalformedURLException {
        starAppiumService(portNumber);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", ".Calculator");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("systemPort", portNumber);
        setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"), desiredCapabilities));
    }



    @BeforeMethod
    @Parameters({"deviceName", "platformName", "portNumber"})
    public void initiateDriverinDeviceFarm_PolandRegion(String deviceName, String platformVersion, String portNumber, String udid) throws MalformedURLException {
        starAppiumService(portNumber);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", deviceName);
        desiredCapabilities.setCapability("platformVersion", platformVersion);
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("udid", udid);
        desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
        desiredCapabilities.setCapability("appActivity", ".Calculator");
        desiredCapabilities.setCapability("noReset", "true");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability("systemPort", portNumber);
        setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber+"/wd/hub"), desiredCapabilities));
    }



    @AfterMethod
    public void closeDriver(){
        getDriver().quit();
    }

    public void starAppiumService(String portNumber){
        AppiumDriverLocalService service;
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("http://127.0.0.1");
        builder.usingPort(Integer.parseInt(portNumber));
        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        System.out.println("Service started on port number = "+portNumber);
    }
}
