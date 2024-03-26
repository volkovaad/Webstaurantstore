package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class Lockers {
    public Lockers(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Storage & Transport")
    private WebElement StorageAndTransport;

    @FindBy(partialLinkText = "Lockers")
    private WebElement Lockers;

    @FindBy(xpath = "//button[@aria-label='Switch to Grid view']")
    private WebElement GridView;

    @FindBy(xpath = "//button[@aria-label='Switch to List view']")
    private WebElement ListView;

    @FindBy(partialLinkText = "Eligible")
    private WebElement PlusEligible;



    public void NavigateLockersPage(){
        StorageAndTransport.click();
        Lockers.click();
    }
}
