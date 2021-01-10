package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class YourAccountPage {
    public SelenideElement mainAccountInformation = $(By.xpath("\"//body/div[@id='orb-modules']/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/p[1]"));

    public void checkUserAccountPageInformation() {
        mainAccountInformation.shouldHave(Condition.text("Welcome to your BBC. You can"));
    }
}

