package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class TravelSectionPage {
    public SelenideElement firstPartArticles = $(byClassName("article-list article-list-group-1 "));
    public SelenideElement secondPartArticles = $(byClassName("article-list article-list-group-2 "));
    public SelenideElement thirdPartArticles = $(byClassName("article-list article-list-group-3"));

    public void selectFirstArticleFromTheListOfGroup3(){
        thirdPartArticles.waitUntil(Condition.visible,60000);


    }
}
