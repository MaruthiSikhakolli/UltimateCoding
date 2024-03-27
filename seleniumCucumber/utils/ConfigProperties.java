package seleniumCucumber.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    private static String url;
    private static String browser;
    private static String headless;
    private static String localRun;

    static {
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + "/src/seleniumCucumber/config/config.properties")) {
            prop.load(input);
            url = prop.getProperty("url");
            browser = prop.getProperty("browser");
            headless = prop.getProperty("headless");
            localRun = prop.getProperty("localRun");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getUrl() {
        return url;
    }

    public static String getBrowser() {
        return browser;
    }

    public static String getHeadless() {
        return headless;
    }

    public static Boolean getLocalRun() {
        return localRun.equals("true");
    }

}
