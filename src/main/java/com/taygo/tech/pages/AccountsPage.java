package com.taygo.tech.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.taygo.tech.constants.AppConstants;
import com.taygo.tech.utils.ElementUtil;

public class AccountsPage {

  private WebDriver driver;
  private ElementUtil eleUtil;
  private  By basicInfo = By.id("basic-button");
  private By logoutLink = By.cssSelector("[class*='MuiTypography-body2 css-cinyfy']");
  private By search = By.name("search");
  private By searchIcon = By.cssSelector("div#search button");
  private By accHeaders = By.cssSelector("div#content > h2");

  // page const...
  public AccountsPage(WebDriver driver) {
    this.driver = driver;
    eleUtil = new ElementUtil(this.driver);
  }

  // page actions:

  public String getAccPageTitle() {
    String title =
        eleUtil.waitForTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.SHORT_DEFAUTT_WAIT);
    System.out.println("Acc page title:" + title);
    return title;
  }

  public String getAccPageURL() {
    String url =
        eleUtil.waitForURLContains(
            AppConstants.ACC_PAGE_URL_FRACTION, AppConstants.SHORT_DEFAUTT_WAIT);
    System.out.println("acc page url:" + url);
    return url;
  }

  public boolean isLogutLinkExist() {
    return eleUtil
        .waitForVisibilityOfElement(basicInfo, AppConstants.LONG_DEFAUTT_WAIT)
        .isDisplayed();
  }

  public void logout()  {
    if (isLogutLinkExist()) {
      eleUtil.doClick(basicInfo);
      eleUtil.waitForVisibilityOfElement(logoutLink,10);
      eleUtil.doClick(logoutLink);
    }
  }

  public boolean isSearchFieldExist() {
    return eleUtil
        .waitForVisibilityOfElement(search, AppConstants.SHORT_DEFAUTT_WAIT)
        .isDisplayed();
  }

  public List<String> getAccountsHeaders() {
    List<WebElement> headersList =
        eleUtil.waitForVisibilityOfElements(accHeaders, AppConstants.MEDIUM_DEFAUTT_WAIT);
    List<String> headersValList = new ArrayList<String>();
    for (WebElement e : headersList) {
      String text = e.getText();
      headersValList.add(text);
    }
    return headersValList;
  }

}
