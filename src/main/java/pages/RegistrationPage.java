package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {
    public SelenideElement emailInputField = $("#user-identifier-input");
    public SelenideElement passwordInputField = $("#password-input");
    public SelenideElement locationSelector = $("#location-select");
    public SelenideElement registerButton = $("#submit-button");
    public SelenideElement registrationSuccessConfirmation = $(By.xpath("//span[contains(text(),'OK you’re signed in. Now, want to keep up to date?')]"));

    public void registerNewUser(String email, String password, String country) {
        emailInputField.setValue(email);
        passwordInputField.setValue(password);
        locationSelector.selectOptionContainingText(country);

    }

    public void clickRegisterButton() {
        registerButton.click();
    }
    public void checkSuccessRegistration(){
        registrationSuccessConfirmation.shouldHave(Condition.text("OK you’re signed in. Now, want to keep up to date?"));
    }
}
