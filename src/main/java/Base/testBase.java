package Base;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

import java.util.List;

public class testBase {

    public Playwright playwright;
    public Browser browser;
    public BrowserContext context;
    public Page page;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Setting up test environment...");
        // Add any setup code here, such as initializing WebDriver, setting up database connections, etc.
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: Preparing test class...");
        playwright = Playwright.create();
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions().setHeadless(false).setArgs(List.of("--start-maximized"));
        browser = playwright.chromium().launch(launchOptions);
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        page = context.newPage();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Setting up preconditions for test method...");
        // Add any setup code here that needs to run before each test method, such as logging in, resetting test data, etc.
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Cleaning up after test method...");
        // Add any cleanup code here that needs to run after each test method, such as logging out, clearing cookies, etc.
    }

    @AfterClass
    public void afterClass() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
        System.out.println("After Class: Cleaning up after test class...");
        // Add any cleanup code here that needs to run after each test class, such as closing browser windows, etc.
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Tearing down test environment...");
        // Add any teardown code here, such as quitting WebDriver, closing database connections, etc.
    }
}
