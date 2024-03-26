package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
@Data
public class WeeklySales {

    public WeeklySales(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(partialLinkText = "Weekly Sales")
    private WebElement WeeklySales;

    @FindBy(xpath = "//button[@aria-label='Switch to Grid view']")
    private WebElement GridView;

    @FindBy(xpath = "//button[@aria-label='Switch to List view']")
    private WebElement ListView;

    @FindBy(xpath = "//select[@class='appearance-none bg-none border-gray-400 rounded border-solid border box-border p-0 pl-2 pr-10 relative inset-0']")
    private WebElement DropDown;

    @FindBy(xpath = "//button[@data-testid='clear-filters']")
    private WebElement ClearFilter;

    @FindBy(css = "button[data-original-title='Compare up to 4 products']")
    private WebElement CompareProducts;

    @FindBy(xpath = "(//button[@data-testid='isCompared'])[1]")
    private WebElement CompareProduct1;

    @FindBy(xpath = "(//button[@data-testid='isCompared'])[2]")
    private WebElement CompareProduct2;

    @FindBy(id = "product-compare-results")
    private WebElement CompareProductsResult;

    public void WeeklySalesPage(){
        WeeklySales.click();
    }


}

