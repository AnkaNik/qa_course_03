import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.Condition.focused;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class dragAndDrop {
    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void move(){
        open("https://the-internet.herokuapp.com/drag_and_drop");
        //work only when mouse on focus near columns.should be add focus on the code, but dont know where
        actions().moveToElement($("#column-a"))
                .clickAndHold()
                .moveToElement($("#column-b"),300,200).release().build().perform();

        $("#column-b").shouldHave(text("A"));
        $("#column-a").shouldHave(text("B"));
    }
}
