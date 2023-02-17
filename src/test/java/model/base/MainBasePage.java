package model.base;

import io.qameta.allure.Step;
import model.base.base_components.BreadcrumbsComponent;
import model.base.base_components.FooterComponent;
import model.base.base_components.HeaderComponent;
import org.openqa.selenium.WebDriver;

public abstract class MainBasePage extends BasePage {

    public MainBasePage(WebDriver driver) {
        super(driver);
    }

    public FooterComponent getFooter() {
        return new FooterComponent(getDriver());
    }

    public HeaderComponent getHeader() {
        return new HeaderComponent(getDriver());
    }

    @Step("Switch to Breadcrumbs panel")
    public BreadcrumbsComponent getBreadcrumbs() {
        return new BreadcrumbsComponent(getDriver());
    }
}
