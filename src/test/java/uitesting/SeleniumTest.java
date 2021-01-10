package uitesting;

import com.codeborne.selenide.Condition;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static pages.HomePage.baseUrl;


@Slf4j
public class SeleniumTest extends BBCFunctionalPageSetUp {


    @Test
    public void checkIfUserUnder16IsNotRegistered() {

        modalWindowPage.clickRegisterButton();
        checkAgePage.clickUnder16Button();
        negativeAgeCheckpage.negativeAnswerIsVisible();
    }

    @Test
    public void checkIfUserWithYearDateUnder16IsNotRegistered() {
        open(baseUrl);
        log.debug("Going to open url: " + baseUrl);
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
        registrationPage.registerNewUser("1886test@mailforspam.com", "qwero612345", "Ukraine");
        registrationPage.clickRegisterButton();
        registrationPage.checkSuccessRegistration();
    }

    @Test
    public void checkIfUserCanSignInWithCorrectCredentials() {
        open(baseUrl);
        modalWindowPage.clickSignInButton();
        signInPage.signIn("1886test@mailforspam.com", "qwero612345");
        signInPage.clickSignInButton();
        homePage.clickYourAccountButton();
        yourAccountPage.checkUserAccountPageInformation();
    }

    @Test
    public void selectFirstArticleFromGroup3ListTravelSection() {
        open(baseUrl);
        modalWindowPage.clickMaybeLaterButton();
        homePage.clickSportSectionButton();
        sportSectionPage.selectArticleWithExactWord("Inter");
        sportSectionPage.element.shouldHave(Condition.text("Inter"));
    }
}