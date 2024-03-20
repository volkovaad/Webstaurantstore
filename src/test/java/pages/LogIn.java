package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

@Data
public class LogIn {
    public LogIn(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='list-none relative']//span[@class='flex items-center text-sm leading-none']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@data-testid='global-header-sign-in-dropdown']")
    private WebElement signIndrop;

    @FindBy(id = "email")
    private WebElement usernameField;

    @FindBy (id = "password")
    private WebElement passwordField;

    @FindBy (id = "the_login_button")
    private WebElement loginButton;


    @FindBy(xpath = "//div[@class='dashboard__summary-list']")
    private WebElement dashboardName;
    @FindBy(xpath = "//span[@class='max-w-16 capitalize truncate block text-xs font-normal text-left leading-none']")
    private WebElement logoName;

    @FindBy(xpath = "//h1[@class='page-header']")
    private WebElement accountDashboard;

    public String getDashboardName() {
        return dashboardName.getText().substring(0, dashboardName.getText().indexOf(' '));
    }

    public String getLogoName() {
        return logoName.getText().replace("'S", "").trim();
    }


    public void signIn(){
    signInButton.click();
    signIndrop.click();
    }

    public void login(String username, String password){
        usernameField.sendKeys(username, Keys.TAB, password, Keys.TAB);
        loginButton.click();
    }

    public void login() {
        usernameField.sendKeys("candali.alina@gmail.com", Keys.TAB, "696XR3d_fTbf9W!", Keys.ENTER);
    }

}
