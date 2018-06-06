package homeoffice;

import cucumber.api.java.en.*;
import homeoffice.page_factory.read_vehicle_reg_detailsPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.util.Assert;

import java.io.File;

/**
 * Created by musti on 06/06/2018.
 */
public class MyStepdefs extends DriverInstance{

    read_vehicle_reg_detailsPage rvp = new read_vehicle_reg_detailsPage(driver);

    @Given("^I am on the Get vehicle information from DVLA page$")
    public void iAmOnTheGetVehicleInformationFromDVLAPage() throws Throwable {
        System.out.println("Hooks and DriverInstance class would navigate user to the get vehicle info DVLA page");
    }
    @When("^I click on Start Now$")
    public void i_click_on_Start_Now() throws Throwable {

        rvp.startSearch();
    }

    @When("^I Enter a vehicle Registration$")
    public void i_Enter_a_vehicle_Registration() throws Throwable {

        Thread.sleep(2000);
        rvp.enterCarReg("line");
    }

    @When("^I click on continue$")
    public void i_click_on_continue() throws Throwable {

        System.out.println("Continue button has been clicked in the previous method");
    }

    @Then("^the details of the vehicle should be correctly displayed$")
    public void the_details_of_the_vehicle_should_be_correctly_displayed() throws Throwable {
        rvp.verifyCarId();

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("src\\main\\java\\screenshots\\dvla.jpg"));
        driver.close();

    }
}
