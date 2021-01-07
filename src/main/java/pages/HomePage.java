package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public static final String baseUrl = "https://www.bbc.com/";
    public SelenideElement travelSectionButton = $(byXpath("//header/div[@id='orb-header']/div[1]/nav[1]/div[1]/ul[1]/li[6]/a[1]"));

    public void clickTravelSectionButton() {
        travelSectionButton.click();
    }
}
