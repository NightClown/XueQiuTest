import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import page.MainPage;
import page.SearchPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    static MainPage mainPage;
    static SearchPage searchPage;

    @BeforeAll
    static void beforeAll(){
        mainPage=MainPage.start();
        searchPage=mainPage.gotoSearch();
    }
    @ParameterizedTest
    @CsvSource({
            "jd, 京东",
            "alibaba, 阿里巴巴",
            "gldq, 格力电器"
    })

    void 搜索测试(String keyword, String name){
        String content=searchPage.search(keyword).getAll().get(0);
        assertThat(content, equalTo(name));
    }

    @Test
    void 选择(){
        ArrayList<String> array=searchPage.search("mi").addSelected();
        assertThat(array, hasItems("followed_btn", "follow_btn"));

    }
}
