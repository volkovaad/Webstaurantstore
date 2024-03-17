package pages;

import com.github.javafaker.Faker;
import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

@Data
public class CreatingAcc {

    Faker faker = new Faker();
    public CreatingAcc(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='list-none relative']//span[@class='flex items-center text-sm leading-none']")
    private WebElement signIn;

    @FindBy(xpath = "//a[@href='/myaccount.html?goto=register']")
    private WebElement createNew;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "billname")
    private WebElement name;

    @FindBy(id = "billaddr")
    private WebElement address;

    @FindBy(id = "billzip")
    private WebElement zip;

    @FindBy(id = "billphone")
    private WebElement phone;

    @FindBy(id = "profileCompanyType")
    private WebElement companyType;

    @FindBy(id = "billcompany")
    private WebElement companyName;

    @FindBy(id = "billnum_employees")
    private WebElement employees;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "complete_registration")
    private WebElement complete;

    public void creatingAcc(){
        signIn.click();
        createNew.click();
    }

    public void generateInfo1() {
        email.sendKeys(faker.internet().emailAddress(), Keys.TAB);
        name.sendKeys(faker.address().firstName(), Keys.TAB);
    }

    public void getAddandZip(String address, String city, String  state, String zip){
     getAddress().sendKeys(address + ", " + city + ", " + state, Keys.TAB);
     getZip().sendKeys(zip, Keys.TAB);

    }
        public void generateInfo2() {
            String phoneNumber = String.format("(%s) %s-%s",
                    faker.number().digits(3),
                    faker.number().digits(3),
                    faker.number().digits(4));
            phone.sendKeys(phoneNumber, Keys.TAB);
            Select dropdownCompany = new Select(companyType);
            dropdownCompany.selectByVisibleText("Food Media");
            companyName.sendKeys(faker.company().name(), Keys.TAB);
            Select dropEmployee = new Select(employees);
            dropEmployee.selectByVisibleText("2-10");
            password.sendKeys(faker.internet().password(), Keys.TAB);
            complete.click();
        }
            public void finish() {
                password.sendKeys(faker.internet().password(), Keys.TAB);
                complete.click();
            }
    }

