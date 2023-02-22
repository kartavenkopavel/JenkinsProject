package model.base;

import io.qameta.allure.Step;
import model.base.side_menu.BaseSideMenuWithGenericComponent;
import org.openqa.selenium.WebDriver;

public abstract class MainBasePageWithSideMenu<SideMenu extends BaseSideMenuWithGenericComponent<?>> extends MainBasePage {

    protected abstract SideMenu createSideMenuComponent();

    public MainBasePageWithSideMenu(WebDriver driver) {
        super(driver);
    }
    @Step("Get side menu")
    public SideMenu getSideMenu() {
        return createSideMenuComponent();
    }
}
