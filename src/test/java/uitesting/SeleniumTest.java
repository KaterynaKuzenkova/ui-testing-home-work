package uitesting;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.testng.ScreenShooter;



public class SeleniumTest {
    private String baseUrl = "https://www.bbc.com/";
    int registerEmailAddress = 0;
    int registerPassword = 111;
    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(false)
                .savePageSource(true)
        );
    }
    @BeforeTest
    public void setUp() {
        ScreenShooter.captureSuccessfulTests = true;
    }

    @Test
    public void userUnder16IsNotRegistered() {
        open(baseUrl);
        $(byClassName("id4-cta-register")).should(visible).click();
        $(byXpath("//*[@id=\"container\"]/div/div/div/div[2]/div[2]/div[2]/div/div[3]/fieldset/div[1]/a[1]/span")).should(visible).click();
        $(byXpath("//*[@id=\"container\"]/div/div/div/div[2]/div[2]/div[2]/div/p")).should(appear);
    }

    @Test
    public void userWithYearDateUnder16IsNotRegistered() {
        open(baseUrl);
        $(byClassName("id4-cta-register")).should(visible).click();
        $(byXpath("//*[@id=\"container\"]/div/div/div/div[2]/div[2]/div[2]/div/div[3]/fieldset/div[1]/a[2]/span")).should(visible).click();
        $("#day-input").shouldBe(visible).setValue("01");
        $("#month-input").shouldBe(visible).setValue("01");
        $("#year-input").shouldBe(visible).setValue("2007");
        $("#submit-button").click();

        $("#form-message-dateOfBirth").should(appear);
    }

    @Test
    public void userWithYearDateOver16IsRegistered() {
        open(baseUrl);
        $(byClassName("id4-cta-register")).should(visible).click();
        $(byXpath("//*[@id=\"container\"]/div/div/div/div[2]/div[2]/div[2]/div/div[3]/fieldset/div[1]/a[2]/span")).should(visible).click();
        $("#day-input").shouldBe(visible).setValue("01");
        $("#month-input").shouldBe(visible).setValue("01");
        $("#year-input").shouldBe(visible).setValue("1990");
        $("#submit-button").click();

        registerEmailAddress = registerEmailAddress + 1;
        registerPassword = registerPassword + 1;
        $("#user-identifier-input").should(visible).setValue(registerEmailAddress + "example@gmail.com");
        $("#password-input").setValue(registerPassword + "qwery");
        $("#location-select").selectOptionContainingText("Italy");
        $("#submit-button").click();
        $(byXpath("//*[@id=\"container\"]/div/div/div/div[2]/div[2]/div[2]/div/h1")).should(appear);
    }

//    @Test
//    public void checkIfUserCanSighInWithValidData() {
//        open(baseUrl);
//        $("#idcta-link").should(visible).click();
//        $("#user-identifier-input").should(visible).setValue("");
//    }
}