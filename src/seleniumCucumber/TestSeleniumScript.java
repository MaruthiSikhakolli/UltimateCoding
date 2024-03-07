package seleniumCucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.time.Duration;
import java.util.*;
import java.util.logging.Logger;

public class TestSeleniumScript {
    static WebDriver driver;
    WebElement element;
    WebDriverWait wait;
    JavascriptExecutor javascriptExecutor;
    Select select;
    Actions actions;
    String strErrorInfo;
    Logger log = Logger.getLogger(getClass().getName());

    public static void main(String[] Args) throws InterruptedException{
        TestSeleniumScript testSeleniumScript = new TestSeleniumScript();
        testSeleniumScript.BrowserActions("Chrome");
        testSeleniumScript.testCode();
    }

    public void testCode() throws InterruptedException {
        //Launch sampleSiteForSelenium
        String URL = "file:///Users/maruthisikhakolli/Downloads/DateTime.html";
        driver.get(URL);

        //Insert test code here
        WebElement dateBox = driver.findElement(By.xpath("//div[label[text()='Start Date and Time ']]//input[@type='datetime-local']"));

        Thread.sleep(3000);
        //Fill date as dd/mm/yyyy as 25/09/2024
        dateBox.sendKeys("25092026");

        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);

        //Fill time as 14:45
        dateBox.sendKeys("1445");

        //Press tab to shift focus to next fields
        dateBox.sendKeys(Keys.TAB);
        Thread.sleep(5000);

        //Close the browser
        driver.close();
    }

    public void BrowserActions(String browserName) {
        try {
            initializeDriver(browserName);
        } catch (SessionNotCreatedException e) {
            log.info("Caught Session not created exception, closing existing session and creating new");
            close();
            initializeDriver(browserName);
        }
        driver.manage().window().maximize();
        setImplicitWait(60);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(300), Duration.ofSeconds(500));
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    private void initializeDriver(String browserName) {
        switch (browserName.toLowerCase()) {
            case "safari":
                log.info("Instantiating Safari Driver");
                if (isSafariWebDriverSupportedPlatform()) {
                    driver = new SafariDriver();
                } else
                    log.warning("The current platform is not supported to start the safari webdriver");
                break;
            case "chrome":
                log.info("Instantiating Chrome Driver");
                WebDriverManager.chromedriver().setup();
                Map<String, Object> prefs = setPreferences();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                options.setExperimentalOption("prefs", prefs);
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                log.info("Instantiating Firefox Driver");
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ie":
                log.info("Instantiating Internet Explorer Driver");
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            default:
                driver = new SafariDriver();
        }
    }

    public boolean close() {
        boolean status = true;
        try {
            driver.quit();
        } catch (Exception e) {
            log.severe("Selenium Error occurred while closing the browser");
        }
        // assertTrue(status, "Error performing close action");
        return status;
    }

    private void setImplicitWait(int time) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    private boolean isSafariWebDriverSupportedPlatform() {
        Platform current = Platform.getCurrent();
        boolean status = Platform.MAC.is(current) || Platform.WINDOWS.is(current);
        log.info("isSafariWebDriverSupportedPlatform:" + status);
        return status;
    }

    private Map<String, Object> setPreferences() {
        Map<String, Object> prefs = new HashMap<>();
        String path = System.getProperty("user.dir") + File.separator + "downloadedFiles";
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.mkdir();
            } catch (SecurityException e) {
                log.warning("Could not create directory");
            }
        }
        log.info(path);
        prefs.put("download.default_directory", path);
        prefs.put("download.prompt_for_download", false);
        prefs.put("download.directory_upgrade", true);
        return prefs;
    }
}
