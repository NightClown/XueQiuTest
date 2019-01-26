package page;

import driver.Driver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;

public class SearchPage extends BasePage{
    public SearchPage search(String keyword){
        try{
            find(By.className("android.widget.EditText")).sendKeys(keyword);
        }catch (Exception e){
            System.out.println("定位不到搜索框");
        }
        return this;
    }

    public MainPage cancel(){
        find(By.id("action_close")).click();
        return new MainPage();
    }

    public ArrayList<String> getAll(){
        ArrayList<String> array=new ArrayList<String>();
        for(AndroidElement e: Driver.getCurrentDriver().findElements(By.id("stockName"))){
            array.add(e.getText());
        }
        return array;

    }

    public ArrayList<String> addSelected(){
        ArrayList<String> array=new ArrayList<String>();
        AndroidElement select= find(locate("portfolio_stockName"));
        array.add(select.getAttribute("resourceId"));
        find(locate(array.get(0))).click();
        //AndroidElement select2=(AndroidElement)find(By.xpath("//*[contains(@resource-id, 'follow') and contains(@resource-id, '_btn')]"));
        //array.add(select2.getAttribute("resource-id"));
        return array;
    }

    public SearchPage getByStock(){
        return  this;

    }

    public SearchPage removeSelected(){
        ArrayList<String> arrayList = new ArrayList<>();
        AndroidElement stock = find(By.xpath("//*[contains(@resource-id,'portfolio_stockName')]"));
        arrayList.add(stock.getAttribute("text"));
        TouchAction ta = new TouchAction(Driver.getCurrentDriver());
        for (int i= 0;i< arrayList.size();i++){
           String name = arrayList.get(i);
           AndroidElement stockname = find(text(name));
           ta.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(stockname)).withDuration(Duration.ofSeconds(5))).release().perform();
           find(text("删除")).click();
        }
        return this;

    }
}
