package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
    //WebElement element = wd.findElement(By.xpath("//*[@ng-reflect-router-link='login']"));
    //element.click();
        click(By.xpath("//*[@ng-reflect-router-link='login']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }

    public void submitLogin() {
        click(By.xpath("//*[@type='submit']"));
    }

    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[@ng-reflect-router-link='logout']"));
    }


}
