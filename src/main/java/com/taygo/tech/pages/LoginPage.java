package com.taygo.tech.pages;

import com.taygo.tech.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.taygo.tech.constants.AppConstants;

public class LoginPage {

  private WebDriver driver;
  private ElementUtil eleUtil;

  // By locators: OR
  private By userName = By.name("email");
  private By password = By.name("password");
  private By loginBtn = By.cssSelector("[type*='submit']");
  private By forgotPwdLink = By.linkText("Forgot Password?");
  private By logo = By.cssSelector("img[alt*='Logo']");
  private By registerLink = By.linkText("Sign up");

  // page const...
  public LoginPage(WebDriver driver) {
    this.driver = driver;
    eleUtil = new ElementUtil(this.driver);
  }

  // page actions/methods:
  public String getLoginPageTitle() {
    String title =
        eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_DEFAUTT_WAIT);
    System.out.println("login page title:" + title);
    return title;
  }

  public String getLoginPageURL() {
    String url =
        eleUtil.waitForURLContains(
            AppConstants.LOGIN_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAUTT_WAIT);
    System.out.println("login page url:" + url);
    return url;
  }

  public boolean isForgotPwdLinkExist() {
    return eleUtil
        .waitForVisibilityOfElement(forgotPwdLink, AppConstants.SHORT_DEFAUTT_WAIT)
        .isDisplayed();
  }

  public boolean isLogoExist() {
    return eleUtil.waitForVisibilityOfElement(logo, AppConstants.SHORT_DEFAUTT_WAIT).isDisplayed();
  }

  public AccountsPage doLogin(String username, String pwd) {
    System.out.println("creds are: " + username + " : " + pwd);
    eleUtil
        .waitForVisibilityOfElement(userName, AppConstants.MEDIUM_DEFAUTT_WAIT)
        .sendKeys(username);
    eleUtil.doSendKeys(password, pwd);
    eleUtil.doClick(loginBtn);
    return new AccountsPage(driver);
  }
}
