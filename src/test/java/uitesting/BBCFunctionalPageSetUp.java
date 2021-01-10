package uitesting;

import org.testng.annotations.BeforeTest;
import pages.*;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static pages.HomePage.baseUrl;

public class BBCFunctionalPageSetUp {

    protected HomePage homePage;
    protected ModalWindowPage modalWindowPage;
    protected CheckAgePage checkAgePage;
    protected NegativeAgeCheckpage negativeAgeCheckpage;
    protected PositiveAgeCheckPage positiveAgeCheckPage;
    protected RegistrationPage registrationPage;
    protected SportSectionPage sportSectionPage;
    protected SignInPage signInPage;
    protected YourAccountPage yourAccountPage;

    @BeforeTest
    public void setUp() {
        open(baseUrl);
        homePage = page(HomePage.class);
        modalWindowPage = page(ModalWindowPage.class);
        checkAgePage = page(CheckAgePage.class);
        negativeAgeCheckpage = page(NegativeAgeCheckpage.class);
        positiveAgeCheckPage = page(PositiveAgeCheckPage.class);
        registrationPage = page(RegistrationPage.class);
        sportSectionPage = page(SportSectionPage.class);
        signInPage = page(SignInPage.class);
        yourAccountPage = page(YourAccountPage.class);
    }
}
