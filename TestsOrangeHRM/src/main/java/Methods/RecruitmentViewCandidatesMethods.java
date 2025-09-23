package Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Pages.RecruitmentViewCandidatesPages;

public class RecruitmentViewCandidatesMethods {

    private WebDriver driver;
    private WebDriverWait wait;
    private RecruitmentViewCandidatesPages pages;

    public RecruitmentViewCandidatesMethods(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.pages = new RecruitmentViewCandidatesPages(driver, wait);
    }

    // --- Методы для логина ---
    public void enterUsername(String username) {
        pages.UsernameField().clear();
        pages.UsernameField().sendKeys(username);
    }
    //
    public void enterPassword(String password) {
        pages.PasswordField().clear();
        pages.PasswordField().sendKeys(password);
    }
    //
    public void clickLoginButton() {
        pages.LoginButton().click();
    }

    //--- Методы для Dashboard
    public void waitForDashboardToLoad(){
        wait.until(ExpectedConditions.visibilityOf(pages.DashboardHeader()));
        if (!pages.DashboardHeader().isDisplayed()) {
            throw new RuntimeException("Dashboard не загрузился");
        }
    }

    // --- Методы для Recruitment ---
    public void OpenRecruitment() {
        pages.Recruitment().click();
    }
    //
    public String GetUrl(){
        return driver.getCurrentUrl();
    }

    // --- Методы для Job Title Dropdown ---
    public void openJobTitleDropdown() {
        pages.JobTitle().click();
    }
    // Выбираем элемент
    public void selectJobTitleOption(){
        pages.TitleOptionText().click();
    }
    // Проверяем правильность выбранного элемента
    public String getSelectedJobTitleText() {
        return pages.selectedJobTitleValue().getText();
    }
    // Кликаем на кнопку поиска для проверки фильтрации по таблице
    public void clickSearchButton() {
        pages.searchButton().click();

    }

}
