package model.component.base;

import io.qameta.allure.Step;
import model.component.menu.IMenu;
import model.page.DeletePage;
import model.page.HomePage;
import model.page.MovePage;
import model.page.base.BaseConfigPage;
import model.page.base.BasePage;
import model.page.base.BaseStatusPage;
import model.page.status.FolderStatusPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class BaseStatusSideMenuComponent<StatusPage extends BaseStatusPage<?, ?>, ConfigPage extends BaseConfigPage<?, ?>> extends BaseSideMenuWithGenericComponent<StatusPage> implements IMenu<StatusPage> {

    @FindBy(xpath = "//div[@id='tasks']//span[contains(., 'Delete')]")
    private WebElement delete;

    @FindBy(linkText = "Move")
    private WebElement move;

    @FindBy(linkText = "Configure")
    private WebElement configure;

    protected abstract ConfigPage createConfigPage();

    public BaseStatusSideMenuComponent(WebDriver driver, StatusPage statusPage) {
        super(driver, statusPage);
    }

    public StatusPage getStatusPage() {
        return page;
    }

    private <T extends BasePage> T clickDelete(T toPage) {
        delete.click();

        return toPage;
    }

    @Step ("Click 'Delete' on the side menu")
    public StatusPage clickDeleteToMyStatusPage() {
        return clickDelete(page);
    }

    @Step("Click 'Delete' on the side menu")
    public DeletePage<HomePage> clickDeleteToHomePage() {
        return clickDelete(new DeletePage<>(getDriver(), new HomePage(getDriver())));
    }

    @Step("Click on 'Delete Project' button")
    public DeletePage<FolderStatusPage> clickDeleteToFolder() {
        return clickDelete(new DeletePage<>(getDriver(), new FolderStatusPage(getDriver())));
    }

    @Step("Click on the 'Move' on the side menu")
    public MovePage<StatusPage> clickMove() {
        move.click();

        return new MovePage<>(getDriver(), page);
    }

    @Step("Click 'Configure' on side menu")
    public ConfigPage clickConfigure() {
        configure.click();

        return createConfigPage();
    }
}