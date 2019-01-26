package page;

import org.openqa.selenium.By;

public class OptionalPage extends BasePage{

    public OptionalPage Select(){
        By selectbutton=By.id("image");
        find(selectbutton).click();
        return new OptionalPage();
    }
}