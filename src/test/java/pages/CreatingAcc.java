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

import java.util.ArrayList;
import java.util.List;

@Data
public class CreatingAcc {

    Faker faker = new Faker();

    public CreatingAcc() {
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

    public void creatingAcc() {
        signIn.click();
        createNew.click();
    }

    public void generateInfo1() {
        email.sendKeys(faker.internet().emailAddress(), Keys.TAB);
        name.sendKeys(faker.address().firstName(), Keys.TAB);
    }

    public void getAddandZip(String address, String city, String state, String zip) {
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

    public List<String> getExpectedCompanyTypes() {
        List<String> companyTypes = new ArrayList<>();
        companyTypes.add("Select a Company Type");
        companyTypes.add("Bar, Brewery & Vineyard");
        companyTypes.add("Cafés & Bakery");
        companyTypes.add("Catering, Events & Mobile Food Vendor");
        companyTypes.add("Child Care & Education");
        companyTypes.add("Concession Stand");
        companyTypes.add("Contractors & Construction");
        companyTypes.add("Deli, Butcher & Sandwich Shop");
        companyTypes.add("Entertainment");
        companyTypes.add("Food Media");
        companyTypes.add("Government & Emergency Services");
        companyTypes.add("Healthcare");
        companyTypes.add("Home Use");
        companyTypes.add("Hospitality");
        companyTypes.add("Ice Cream/Frozen Yogurt Shop & Smoothie/Juice Bar");
        companyTypes.add("Janitorial & Cleaning Services");
        companyTypes.add("Logistics");
        companyTypes.add("Manufacturer");
        companyTypes.add("Nonprofit & Charitable Organizations");
        companyTypes.add("Office");
        companyTypes.add("Other");
        companyTypes.add("Plants & Agriculture");
        companyTypes.add("Reseller");
        companyTypes.add("Restaurant");
        companyTypes.add("Stores & Markets");

        return companyTypes;
    }

}