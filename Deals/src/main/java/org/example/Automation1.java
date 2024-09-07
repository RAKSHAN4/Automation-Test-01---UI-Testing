package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Automation1 {

    public void setChromeDriver() throws IOException {
        WebDriver driverFirefox = new FirefoxDriver();

        try{
            driverFirefox.get("https://www.getcalley.com/");
            driverFirefox.manage().window().maximize();
            Map<String, Dimension> resolutionMap = new HashMap<>();
            resolutionMap.put("FullHD", new Dimension(1920, 1080));
            resolutionMap.put("QuadHD", new Dimension(1366, 768));
            resolutionMap.put("4K", new Dimension(1536, 864));
            Dimension selectedResolution = resolutionMap.get("4K");

            driverFirefox.manage().window().setSize(new Dimension(selectedResolution.width,selectedResolution.height));
            takeScreenshot(driverFirefox);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        finally {
            driverFirefox.quit();
        }

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
        File destinstion = new File("S:\\Screenshort\\WEBSITE 1(firefox)\\Firefox 1536x864 "+currentDate+time+".png");
        FileUtils.copyFile(source,destinstion);
    }

    public long getTime(){
        Date date = new Date();
        return date.getTime();

    }

}
