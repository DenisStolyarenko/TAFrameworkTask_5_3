package com.epam.ta.framework.ui.application.pages.login;

import com.epam.ta.framework.ui.application.pages.AbstractPage;
import com.epam.ta.framework.ui.core.utils.Waiters;
import com.epam.ta.framework.ui.core.utils.decorating.elements.Button;
import com.epam.ta.framework.ui.core.utils.decorating.elements.TextInput;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='username']")
    private TextInput userNameInput;

    @FindBy(xpath = "//input[@name='password']")
    private TextInput passwordInput;

    @FindBy(xpath = "//input[@name='Login']")
    private Button loginButton;

    @FindBy(xpath = "//td[@class='header1']/h1")
    private WebElement loginPageText;

    public void login(String userName, String pwdName){
        Waiters.waitForElementEnabled(userNameInput);
        userNameInput.sendKeys(userName);
        Waiters.waitForElementEnabled(passwordInput);
        passwordInput.sendKeys(pwdName);
        Waiters.waitForElementEnabled(loginButton);
        loginButton.click();
    }

    public String readIntroductionText(){
        Waiters.waitForElementVisible(loginPageText);
        return loginPageText.getText();
    }

}
