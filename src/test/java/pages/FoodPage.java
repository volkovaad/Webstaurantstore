package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;

import java.util.List;

import static utilities.SeleniumUtils.jsClick;

@Data
public class FoodPage {

    public FoodPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-type='Food & Beverage']")
    private WebElement foodBevHeader;

    @FindBy(xpath = "//a[@class='flex flex-col items-center self-center pb-2 w-full']//img[@alt='Desserts']")
    private WebElement desserts;

    ////div[@class='btn btn-large btn--transparent img-container__btn'][contains(text(), 'Shop Macarons')]

    @FindBy(xpath = "//div[@class='btn btn-large btn--transparent img-container__btn'][contains(text(), 'Shop Macarons')]")
    private WebElement macaroons;

    @FindBy(xpath = "//img[@class='w-20 h-20 shrink-0 group-hover:opacity-75 group-active:opacity-75']")
    private WebElement chocomacaroon;

    @FindBy(xpath = "//input[@name='addToCartButton']")
    private WebElement addToCard;

    @FindBy(xpath = "//a[@class='btn btn-small btn-primary']")
    private WebElement popUpViewCard;

    @FindBy(xpath = "//button[@class='standardCheckoutButton btn btn-checkout btn-block btn-large clears btn-checkout__disabled-state']")
    private WebElement checkoutButton;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "BillingAddress.Name")
    private WebElement name;

    @FindBy(id = "BillingAddress.Company")
    private WebElement company;

    @FindBy(id = "BillingAddress.AddressLine1")
    private WebElement address;

    @FindBy(id = "BillingAddress.City")
    private WebElement city;

    @FindBy(id = "BillingAddress.PostalCode")
    private WebElement zip;

    @FindBy(id = "BillingAddress.PhoneNumber")
    private WebElement phone;

    @FindBy(id = "BillingAddress.StateProvince")
    private WebElement state;

    @FindBy(id = "continue_to_payment")
    private WebElement continueToPayment;

    @FindBy(id = "useSelectedAdressAndContinueLink")
    private WebElement useSelected;

    @FindBy(xpath = "//span[@data-testid='itemDescription']")
    private WebElement firstElement;

    @FindBy(xpath = "//a[@class='btn btn-mini btn-light dropdown-toggle list-menu__btn']")
    private WebElement addToWish;

    @FindBy(xpath = "//div[@class='account-nav__itemlist']//span[contains(text (), \"Wish Lists\")]")
    private WebElement wishListLeft;

    @FindBy(xpath = "//a[@href='/wishlist.html?addNewList=true']")
    private WebElement createNewList;

    @FindBy(xpath = "//input[@value='Go']")
    private WebElement go;

    @FindBy(id = "btnAddAllItemsToCart")
    private WebElement AddAllItemsToCart;

    @FindBy(xpath = "//a[@data-testid='add-to-wish-list-My Wish List']")
    private WebElement addToMyList;

    @FindBy(xpath = "//a[@class='btn btn-small btn-primary']")
    private WebElement popUpWishList;

    @FindBy(xpath ="//button[@aria-controls='wish_list_dropdown_container']")
    private WebElement AddToWishNew;

    //sorting
   @FindBy(id = "searchval")
   private WebElement searchLine;

    @FindBy(xpath ="//span[@class='text-sm-3/4 lt:text-sm-1/2 flex items-center'][contains(text (), \"Macaron Centrale\")]")
    private WebElement filter;

    @FindBy(xpath ="//span[@class='zest-chip-value']")
    private WebElement filterOnTop;

    @FindBy(xpath ="//span[@data-testid='itemDescription']")
    private List<WebElement> extractedText;

    @FindBy(id = "sort_options")
    private WebElement sortPrice;

    @FindBy(xpath = "//td[@class='whitespace-nowrap border-gray-200 rounded-none last:rounded-br border-solid border-0 border-t border-l text-xs leading-none p-1/2 text-center first:rounded-tr first:border-t-0 block']")
    private List<WebElement> extractedPrice;

    @FindBy(xpath ="//button[@data-original-title='Compare up to 4 products']")
    private WebElement compareItems;

    @FindBy(xpath = "//div[@data-testid='product-listing-container']//span[@class='icon-check']")
    private WebElement firstCompare;

    @FindBy(xpath = "(//div[@data-testid='product-listing-container']//span[@class='icon-check'])[2]")
    private WebElement secondCompare;

    @FindBy(id = "product-compare-results")
    private WebElement compareResults;
    public void navigatingtoProduct() {
        foodBevHeader.click();
        desserts.click();
        jsClick(macaroons);
        jsClick(chocomacaroon);
    }

    public void addingtoCard() {

        jsClick(addToCard);
        jsClick(popUpViewCard);
        jsClick(checkoutButton);
    }


    public void checkoutForm(String email,
                             String name,
                             String company,
                             String address,
                             String state,
                             String city,
                             String zip,
                             String phone) {
        getEmail().sendKeys(email,Keys.TAB);
        getName().sendKeys(name, Keys.TAB);
        getCompany().sendKeys(company, Keys.TAB);
        getAddress().sendKeys(address + ", " + state + Keys.TAB);
        getCity().sendKeys(city, Keys.TAB);
        getZip().sendKeys(zip, Keys.TAB);
        getPhone().sendKeys(phone, Keys.TAB);

    }

    public void state(){
        Select dropdownState = new Select(getState());
        dropdownState.selectByVisibleText("Florida");
    }

    public void sortMacaroons(){
        Select dropSort = new Select(getSortPrice());
        dropSort.selectByVisibleText("Price: Low to High");
    }

    public void compareItem(){
        Select dropSorting = new Select(getSortPrice());
        dropSorting.selectByVisibleText("Date Added: Newest first");
        jsClick(compareItems);
        jsClick(firstCompare);
        jsClick(secondCompare);
        jsClick(compareResults);

    }


}