package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement emailInputField = $("#user-identifier-input");
    public SelenideElement passwordInputField = $("#password-input");
    public SelenideElement locationSelector = $("#location-select");
    public SelenideElement registerButton = $("#submit-button");

    public void registerNewUser(String email, String password, String country) {
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
        locationSelector.selectOptionContainingText(country);

    }

    public void clickRegisterButton() {
        registerButton.click();
    }
}
