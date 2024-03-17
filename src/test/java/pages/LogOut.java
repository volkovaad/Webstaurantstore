package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class LogOut {
    public LogOut(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='list-none relative']//span[@class='flex items-center text-sm leading-none'] ")
    private WebElement accountToSignOut;

    @FindBy(xpath ="//a[@data-testid='log-out']")
    private WebElement signOutButton;


    public void signOut(){
        accountToSignOut.click();
        signOutButton.click();
    }


}
