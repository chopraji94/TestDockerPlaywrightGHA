import Base.testBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestLogin extends testBase {

    @Test(priority = 0)
    public void testLogin(){
        page.navigate("https://practicetestautomation.com/practice-test-login/");
        page.fill("#username", "student");
        page.fill("#password", "Password123");
        page.click("#submit");
    }

    @Test(priority = 1)
    public void testUserLoggedIn() {
        boolean check = page.locator("//h1[text()='Logged In Successfully']").isVisible();
        Assert.assertTrue(check, "User is not logged in successfully");
    }
}
