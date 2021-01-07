package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class PositiveAgeCheckPage {
    public SelenideElement dateInputField = $("#day-input");
    public SelenideElement monthInputField = $("#month-input");
    public SelenideElement yearInputField = $("#year-input");
    public SelenideElement continueButton = $("#submit-button");
    public SelenideElement negativeAnswer = $(byXpath("//span[contains(text(),'Sorry, you need to be 16 or over.')]"));


    public void enterUserBirthDate(String date, String month, String year) {
        dateInputField.setValue(date);
        monthInputField.setValue(month);
        yearInputField.setValue(year);
    }

    public void clickContinueButton() {
        continueButton.click();
    }
    public void negativeAnswerIsVisible(){
        negativeAnswer.should(Condition.appear);
    }
}
