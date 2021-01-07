package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class CheckAgePage {
    public SelenideElement under16Button = $(byXpath("//span[contains(text(),'Under 16')]"));
    public SelenideElement over16Button = $(byXpath("//span[contains(text(),'16 or over')]"));

    public void clickUnder16Button() {
        under16Button.click();
    }

    public void clickOver16Button() {
        over16Button.click();
    }
}
