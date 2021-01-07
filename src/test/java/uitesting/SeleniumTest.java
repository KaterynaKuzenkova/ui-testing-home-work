package uitesting;

import com.codeborne.selenide.logevents.SelenideLogger;
import com.codeborne.selenide.testng.ScreenShooter;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import static com.codeborne.selenide.Selenide.open;
import static pages.HomePage.baseUrl;


public class SeleniumTest {
    HomePage homePage = new HomePage();
    ModalWindowPage modalWindowPage = new ModalWindowPage();
    CheckAgePage checkAgePage = new CheckAgePage();
    NegativeAgeCheckpage negativeAgeCheckpage = new NegativeAgeCheckpage();
    PositiveAgeCheckPage positiveAgeCheckPage = new PositiveAgeCheckPage();
    RegistrationPage registrationPage = new RegistrationPage();
    TravelSectionPage travelSectionPage = new TravelSectionPage();
    SignInPage signInPage = new SignInPage();

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
    public void checkIfUserUnder16IsNotRegistered() {
        open(baseUrl);
        modalWindowPage.clickRegisterButton();
        checkAgePage.clickUnder16Button();
        negativeAgeCheckpage.negativeAnswerIsVisible();
    }

    @Test
    public void checkIfUserWithYearDateUnder16IsNotRegistered() {
        open(baseUrl);
        modalWindowPage.clickRegisterButton();
        checkAgePage.clickOver16Button();
        positiveAgeCheckPage.enterUserBirthDate("01", "12", "2006");
        positiveAgeCheckPage.clickContinueButton();
        positiveAgeCheckPage.negativeAnswerIsVisible();
    }

    @Test
    public void checkIfUserWithYearDateOver16IsRegistered() {
        open(baseUrl);
        modalWindowPage.clickRegisterButton();
        checkAgePage.clickOver16Button();
        positiveAgeCheckPage.enterUserBirthDate("20", "01", "1996");
        positiveAgeCheckPage.clickContinueButton();
        registrationPage.registerNewUser("111test@mailforspam.com", "qwery12345", "Ukraine");
        registrationPage.clickRegisterButton();
    }

    @Test
    public void checkIfUserCanSignInWithCorrectCredentials() {
        open(baseUrl);
        modalWindowPage.clickSignInButton();
        signInPage.signIn("111test@mailforspam.com", "qwery12345");
        signInPage.clickSihnInButton();

    }

    @Test
    public void selectFirstArticleFromGroup3ListTravelSection() {
        open(baseUrl);
        modalWindowPage.clickMaybeLaterButton();
        homePage.clickTravelSectionButton();

    }


}