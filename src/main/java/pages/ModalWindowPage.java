package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class ModalWindowPage {
    public SelenideElement registerButton = $(byClassName("id4-cta-register"));
    public SelenideElement signInButton = $(byClassName("id4-cta-signin id4-cta-button"));
    public SelenideElement maybeLaterButton = $(byClassName("sign_in-exit"));

    public void clickRegisterButton(){
        registerButton.click();
    }
    public void clickSignInButton(){
        signInButton.click();
    }
    public void clickMaybeLaterButton(){
        maybeLaterButton.click();
    }
}
