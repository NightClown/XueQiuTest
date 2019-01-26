package page;

import driver.Driver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;

import java.io.*;
import java.util.ArrayList;

public class BasePage {

    public ArrayList popup() {
        ArrayList listcsv = new ArrayList();
        File file  = new File(BasePage.class.getResource("/data/tanchuang.csv").getFile());
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line = "";
        while (true){
            try {
                if (!((line = reader.readLine())!= null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            String item[] = line.split(",");
            listcsv.add(item);
        }
        return listcsv;
    }

    static AndroidElement find(By locator){
        try{
            return Driver.getCurrentDriver().findElement(locator);
        }catch (Exception e){
            BasePage basePage = new BasePage();
            ArrayList<String []> listcsv = basePage.popup();
            for(int i=0;i<listcsv.size();i++){
                String message = listcsv.get(i)[0];
                try {
                    Driver.getCurrentDriver().findElement(text(message)).click();
                }catch (Exception e1){
                    if (Driver.getCurrentDriver().findElement(locate("menu_item1")).getText() == "您关注的股票在这里~"){
                        Driver.getCurrentDriver().findElement(locate("iv_close")).click();
                        Driver.getCurrentDriver().findElement(locate("action_create_cube")).click();
                    }else {
                        System.out.println("不存在该弹窗");
                    }
                }
            }
            return Driver.getCurrentDriver().findElement(locator);
            }
    }

    static By locate(String locator){
        if(locator.matches("/.*")){
            return By.xpath(locator);
        }else{
            return By.id(locator);
        }
    }

    static By text(String content){
        return By.xpath("//*[@text='"+ content +"']");
    }

}
