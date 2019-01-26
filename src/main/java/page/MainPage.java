package page;
import driver.Driver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    By profile=By.id("user_profile_icon");
    private By select = text("自选");

    public static MainPage start(){
        Driver.start();
        return new MainPage();
    }

    public ProfilePage gotoProfile(){
        Driver.getCurrentDriver().findElement(profile).click();
        return new ProfilePage();

    }

    public SearchPage gotoSearch(){
        find(By.id("home_search")).click();
        return new SearchPage();
    }

    public OptionalPage gotoSelect(){
        int X1=find(select).getLocation().getX();
        int Y1=find(select).getLocation().getY();
        int i = 1;
        while (i > 0){
            int X2=find(select).getLocation().getX();
            int Y2=find(select).getLocation().getY();
            if (X2==X1&Y2==Y1){
                break;
            }else {
                X1 = X2;
                Y1 = Y2;
                i++;
            }
        }
        find(select).click();
        return new OptionalPage();
    }


}
