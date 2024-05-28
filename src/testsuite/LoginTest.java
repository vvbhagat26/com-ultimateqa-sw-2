package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    /**
     * 1. Create the package ‘browserfactory’ and create the
     * class with the name ‘BaseTest’ inside the
     * ‘browserfactory’ package. And write the browser setup
     * code inside the class ‘Base Test’.
     * 2. Create the package ‘testsuite’ and create the
     * following class inside the ‘testsuite’ package.
     * <p>
     * 1. LoginTest
     * <p>
     * 3. Write down the following test into ‘LoginTest’ class
     * <p>
     * 1. userShouldNavigateToLoginPageSuccessfully *
     * click on the ‘Sign In’ link
     * Verify the text ‘Welcome Back!’
     * <p>
     * 2. verifyTheErrorMessage
     * <p>
     * click on the ‘Sign In’ link
     * Enter invalid username
     * Enter invalid password
     * Click on Login button
     * Verify the error message ‘Invalid email
     * or password.’
     */

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Click on Sign in link
        driver.findElement(By.linkText("Sign In")).click();

        //Verify 'welcome back' text
        String expectedErrorMsg = "Welcome Back!";
        String actualErrorMsg = driver.findElement(By.xpath("//h2[@class='page__heading']")).getText();
        assertEquals("error msg not displayed", expectedErrorMsg, actualErrorMsg);
    }

    //verify errormsg
    @Test
    public void verifyTheErrorMessage() {
        //Click on Sign in link
        driver.findElement(By.linkText("Sign In")).click();

        //Enter invalid username
        driver.findElement(By.id("user[email]")).sendKeys("prime12@gmail.com");

        //Enter invalid password
        driver.findElement(By.id("user[password]")).sendKeys("prime123");

        //Click on login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        //Verify msg 'Invalid email or password'
        String expectedErrorMsg = "Invalid email or password.";
        String actualErrorMsg = driver.findElement(By.xpath("//li[@class='form-error__list-item']")).getText();
        Assert.assertEquals("error msg not displayed", expectedErrorMsg, actualErrorMsg);

    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
