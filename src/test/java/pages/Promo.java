package pages;

import lombok.Data;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import static utilities.SeleniumUtils.jsClick;

@Data
public class Promo {
    public Promo(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath ="//a[@data-testid='logo'][@class='hidden lt:block w-full xxl:w-auto']")
    private WebElement homepage;

    @FindBy(xpath ="//div[@class='gtm-promo mini-advertisements group']//a[@href='https://www.webstaurantstore.com/specializedpage.cfm?index=29929']")
    private WebElement promoClick;

    @FindBy(xpath ="//div[@class='h-full m-0 relative border-solid border-white border-2 rounded-md']")
    private WebElement promoElement;

    @FindBy(xpath ="//input[@gtm-id='AddToCartATC']")
    private WebElement addToCart;

    @FindBy(xpath = "//button[@class='border-solid border box-border cursor-pointer inline-block text-center no-underline antialiased focus-visible:outline focus-visible:outline-offset-2 focus-visible:outline-2 ml-3 rounded-normal text-base leading-normal px-7 py-2-1/2 text-white text-shadow-black-60 border-black-10 btn btn-info align-middle font-semibold']")
    private WebElement agree;

    @FindBy(xpath = "//button[@data-testid='cancel-button']")
    private WebElement cancel;

    @FindBy(xpath = "//a[@href='/viewcart.cfm']")
    private WebElement viewCart;

    @FindBy(xpath = "//button[@class='standardCheckoutButton btn btn-checkout btn-jumbo btn-large btn-checkout__disabled-state']")
    private WebElement checkout;

    @FindBy(xpath = "//div[@data-testid='coupon-code']//b")
    private WebElement promoToUse;

    //no placeholder
    @FindBy(xpath = "//input[@placeholder='promo']")
    private WebElement promoPlaceHolder;

    String promoWord;
    public void promotion(){

        homepage.click();
        promoClick.click();

        promoWord = getPromoToUse().getText();

        promoElement.click();
        addToCart.click();

//        jsClick(agree);
//        jsClick(cancel);
        jsClick(viewCart);
    }

    public void usingCode(){
        checkout.click();
        promoPlaceHolder.sendKeys(promoWord, Keys.ENTER);
    }


}
