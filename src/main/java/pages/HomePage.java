package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import okio.Timeout;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public static final String baseUrl = "https://www.bbc.com/";
    public SelenideElement sportSectionButton = $(byXpath("//header/div[@id='orb-header']/div[1]/nav[1]/div[1]/ul[1]/li[3]/a[1]"));
    public SelenideElement yourAccountSection = $(("#idcta-link"));

    public void clickSportSectionButton() {
        sportSectionButton.click();
    }

    public void clickYourAccountButton() {
        yourAccountSection.waitUntil(Condition.appear, Timeout.NONE.timeoutNanos()).click();
    }
}
