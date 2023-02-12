package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage searchUser(String user) {
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys(user);
        driver.findElement(By.cssSelector("#jump-to-suggestion-search-global > a > div.jump-to-suggestion-name.js-jump-to-suggestion-name.flex-auto.overflow-hidden.text-left.no-wrap.css-truncate.css-truncate-target")).click();
        return this;
    }

    public String getText() {
        //this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElement(By.cssSelector("body > div.logged-out.env-production.page-responsive > div.application-main > main > div > div.col-12.col-md-9.float-left.px-2.pt-3.pt-md-0.codesearch-results > div > div > h3")).getText();
    }

    public HomePage findUser() {
        driver.findElement(By.cssSelector("body > div.logged-out.env-production.page-responsive > div.application-main > main > div > div.col-12.col-md-3.float-left.px-md-2 > nav.menu.border.d-none.d-md-block > a:nth-child(10)")).click();
        driver.findElement(By.cssSelector("#user_search_results > div > div > div.flex-auto > div:nth-child(1) > div.f4.text-normal > a.color-fg-muted > em")).click();
        return this;
    }

    public String getUsername() {
        return driver.findElement(By.cssSelector("body > div.logged-out.env-production.page-responsive.page-profile > div.application-main > main > div.container-xl.px-3.px-md-4.px-lg-5 > div > div.Layout-sidebar > div > div.js-profile-editable-replace > div.clearfix.d-flex.d-md-block.flex-items-center.mb-4.mb-md-0 > div.vcard-names-container.float-left.js-profile-editable-names.col-12.py-3.js-sticky.js-user-profile-sticky-fields > h1 > span.p-nickname.vcard-username.d-block")).getText();
    }





}
