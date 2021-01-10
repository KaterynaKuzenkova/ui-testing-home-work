package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NegativeAgeCheckpage {
    public SelenideElement negativeResult = $(byXpath("//span[contains(text(),'Sorry, only 16s and over can register outside the ')]"));

    public void negativeAnswerIsVisible() {
        negativeResult.shouldHave(Condition.text("Sorry, only 16s and over can register outside the UK"));
    }
}
