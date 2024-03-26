package pages;

import lombok.Data;
import org.openqa.selenium.By;
import utilities.Driver;
import utilities.SeleniumUtils;

@Data

public class CategoryPage {
    public void clickCategoryLink(String textOfTheLink){
        Driver.getDriver().findElement(By.linkText(textOfTheLink)).click();
    }
    public void hoverOverCategoryLink(String textForHover) {
        SeleniumUtils.hover(Driver.getDriver().findElement(By.linkText(textForHover)));
    }
}
