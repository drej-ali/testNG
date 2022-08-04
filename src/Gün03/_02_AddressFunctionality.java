package Gün03;
import Utils.GenelWebDriver;
import Utils.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
/*      Senaryo;
       1- Siteyi açınız.
       2- Adress Ekleyiniz.
       3- En son eklenen adresi edit yaparak ad ve soyadı değiştirip kaydediniz.
       4- En son eklenen adresi siliniz.*/
public class _02_AddressFunctionality extends GenelWebDriver {
    @Test(priority = 3)
    void deleteAdress() {
        WebElement edit = driver.findElement(By.linkText("Delete"));
        edit.click();
        Tools.successMessageValidation();
    }
    @Test(priority = 2)
    void editAddress() {
        WebElement edit = driver.findElement(By.linkText("Edit"));
        edit.click();
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.clear();
        firstName.sendKeys("god");
        WebElement lasstName = driver.findElement(By.id("input-lastname"));
        lasstName.clear();
        lasstName.sendKeys("guest");
        Tools.Bekle(1);
        WebElement conti = driver.findElement(By.cssSelector("input[value='Continue']"));
        conti.click();
        Tools.successMessageValidation();
    }
    @Test(priority = 1)
    void addAdress() {
        WebElement address = driver.findElement(By.linkText("Address Book"));
        address.click();
        WebElement newAdress = driver.findElement(By.linkText("New Address"));
        newAdress.click();
        WebElement firstName = driver.findElement(By.id("input-firstname"));
        firstName.sendKeys("kemal");
        WebElement lasstName = driver.findElement(By.id("input-lastname"));
        lasstName.sendKeys("ileri");
        WebElement company = driver.findElement(By.id("input-company"));
        company.sendKeys("HHM");
        WebElement address1 = driver.findElement(By.id("input-address-1"));
        address1.sendKeys("Doğu");
        WebElement address2 = driver.findElement(By.id("input-address-2"));
        address2.sendKeys("Akdeniz");
        WebElement city = driver.findElement(By.id("input-city"));
        city.sendKeys("Hatay");
        WebElement postCode = driver.findElement(By.id("input-postcode"));
        postCode.sendKeys("12345");
        WebElement country = driver.findElement(By.id("input-country"));
        Select countryS = new Select(country);
        countryS.selectByIndex(10);
        WebElement region = driver.findElement(By.id("input-zone"));
        Select regionS = new Select(region);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
                By.cssSelector("[id='input-zone']>option"), regionS.getOptions().size()));
        regionS.selectByIndex(2);
        WebElement conti = driver.findElement(By.cssSelector("input[value='Continue']"));
        conti.click();
        Tools.successMessageValidation();
        /*WebElement country= driver.findElement(By.id("input-country"));
        Select countryS=new Select(country);
        countryS.selectByVisibleText("Turkey");
        WebElement region=driver.findElement(By.id("input-zone"));
        Select regionS=new Select(region);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(
                By.cssSelector("[id='input-zone']>option"),regionS.getOptions().size()));
        regionS.selectByVisibleText("Hatay");*/
    }
}
