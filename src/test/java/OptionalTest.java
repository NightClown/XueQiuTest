import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import page.MainPage;
import page.OptionalPage;
import page.SearchPage;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class OptionalTest {
    static MainPage mainPage;
    static OptionalPage optionalPage;


    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
        optionalPage=mainPage.gotoSelect();
        optionalPage.Select();
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/data/select.csv")
    void 添加自选(String keyword, String name){
        SearchPage searchPage = new SearchPage();
        String content=searchPage.search(keyword).getAll().get(0);
        assertThat(content, equalTo(name));
        searchPage.addSelected();
        //searchPage.cancel();
        //searchPage.removeSelected();
    }

}