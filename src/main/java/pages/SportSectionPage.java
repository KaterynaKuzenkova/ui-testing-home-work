package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$$;

public class SportSectionPage {
    ElementsCollection collection = $$(byClassName("gel-layout gel-layout--equal gs-u-mt gs-u-mt+@s sp-qa-top-stories"));
    public SelenideElement element;

    public void selectArticleWithExactWord(String wordToFind) {
        element = collection.find(Condition.text(wordToFind));
    }
}
