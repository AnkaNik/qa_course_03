
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Find {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void search(){
        //open github page
        open("https://github.com");
        //find field for search
        $("[name=q]").setValue("selenide").pressEnter();
        //type Selenide
        //select from result one
        $$("ul.repo-list li").first().$("a").click();
        //check that right page is opened
        $("[itemprop='name']").shouldHave(Condition.text("selenide"));
        //go to Wiki project
        $x("//*[@data-tab-item='i4wiki-tab']").click();
        //check that present SoftAssertation
        $$(".internal.present").get(7).shouldHave(text("Soft assertions"));
        //open this page
        $x("//a[text()='Soft assertions']").click();
        //check that present code
        $(".markdown-body").shouldHave(Condition.text("JUnit5"));
        $$(".highlight.highlight-source-java").get(3).isEnabled();

        sleep(10000);
    }
}
