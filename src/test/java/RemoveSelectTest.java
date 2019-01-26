import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import page.MainPage;
import page.OptionalPage;
import page.SearchPage;

public class RemoveSelectTest {
    static MainPage mainPage;
    static OptionalPage optionalPage;

    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
        optionalPage = mainPage.gotoSelect();
    }

    @Test
    void 删除自选(){
        SearchPage searchPage = new SearchPage();
        searchPage.removeSelected();
    }
}