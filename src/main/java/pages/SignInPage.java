package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    public SelenideElement emailInputField = $("#user-identifier-input");
    public SelenideElement passwordInputField = $("#password-input");
    public SelenideElement signInButton = $("#submit-button");

    public void signIn(String email, String password) {
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
    }

    public void clickSihnInButton() {
        signInButton.click();
    }
}
