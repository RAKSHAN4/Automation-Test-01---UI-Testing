package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Automation2 {

        public void setChromeDriver() throws IOException {
            WebDriver driverChrome = new ChromeDriver();

            try{
                driverChrome.get("https://demo.dealsdray.com/mis/dashboard");
                driverChrome.manage().window().maximize();

                WebElement orders = driverChrome.findElement(By.xpath("//input[@id='mui-1']"));
                orders.click();
                orders.sendKeys("prexo.mis@dealsdray.com");
                WebElement order = driverChrome.findElement(By.xpath("//input[@id='mui-2']"));
                order.click();
                order.sendKeys("prexo.mis@dealsdray.com");
                WebElement login = driverChrome.findElement(By.xpath("//button[@type='submit']"));
                login.click();
                WebElement menu = driverChrome.findElement(By.xpath("//button[@class='MuiButtonBase-root has-submenu compactNavItem open css-46up3a']"));
                menu.click();


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            /*finally {
                driverChrome.quit();
            }*/

        }

        public String getDate() {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();

            return formatter.format(date);
        }

        public void takeScreenshot(WebDriver driver) throws IOException {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            String currentDate = getDate();
            long time = getTime();
            File destinstion = new File("S:\\rail\\Firefox 1536x864 "+currentDate+time+".png");
            FileUtils.copyFile(source,destinstion);
        }

        public long getTime(){
            Date date = new Date();
            return date.getTime();

        }

    }


