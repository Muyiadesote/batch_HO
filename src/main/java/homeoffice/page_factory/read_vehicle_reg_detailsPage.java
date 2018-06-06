package homeoffice.page_factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.util.Assert;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by musti on 06/06/2018.
 */
public class read_vehicle_reg_detailsPage {
    WebDriver driver;
    public read_vehicle_reg_detailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy (xpath = "//a[text()='Start now']")
    private WebElement StartNow;

    @FindBy (xpath = "//*[@id='Vrm']")
    private WebElement EnterReg;

    @FindBy (xpath = "//*[@name='Continue']")
    private WebElement ContinueBtn;

    @FindBy (xpath = "//*[@id='pr3']/div/ul/li[1]/span[2]")  //*[@class='reg-mark']
    private WebElement CarReg;

    @FindBy (xpath = "//*[@id='pr3']/div/ul/li[2]/span[2]/strong")  //*[@class='reg-mark']
    private WebElement CarMake;

    @FindBy (xpath = "//*[@id=pr3']/div/ul/li[3]/span[2]/strong")
    private WebElement CarColour;


    public void startSearch(){
        StartNow.click();
    }

    public void enterCarReg(String line)throws IOException {
        File file = new File("D:/data.csv");
        if(file.exists()){
            System.out.println("File Exists");
        }
        BufferedReader bufRdr;
        bufRdr = new BufferedReader(new FileReader(file));
        String line = null;

        while((line = bufRdr.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line, ",");
            int col = 0;
            int row = 0;
            while (st.hasMoreTokens()) {
                //Following stroing the data of csv
                String[][] id = new String[0][];
                id[row][col] = st.nextToken();
                row++;

                EnterReg.clear();
                EnterReg.sendKeys(line);

            }
            bufRdr.close();
        }
    }

    public void continueBtn(){
        ContinueBtn.click();
    }
    public void verifyCarId() {
         System.out.println(CarReg.getText());
         System.out.println(CarReg.isDisplayed());
         System.out.println(CarMake.isDisplayed());
         System.out.println(CarColour.isDisplayed());


    }
}
