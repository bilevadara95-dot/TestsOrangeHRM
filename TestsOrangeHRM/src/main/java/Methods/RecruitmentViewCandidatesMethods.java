package Methods;
import StaticData.ItemsInDropDownListCandidateFlter;
import org.openqa.selenium.WebDriver;
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
    public void selectJobTitleOption() {
        String jobTitleToSelect = ItemsInDropDownListCandidateFlter.jobTitlesMap.get(18); // "QA Engineer"
        pages.getTitleOptionByText(jobTitleToSelect).click();
    }
    // Кликаем на кнопку поиска для проверки фильтрации по таблице
    public void clickSearchButton() {
        pages.searchButton().click();
    }
    //Кликаем на кнопку очистки фильтрации
    public void clickResetButton() {
        pages.resetButton().click();
    }
    //--- Методы для Vacancy ---
    public void openVacancyDropdown() {
        pages.Vacancy().click();
    }
    // Выбираем элемент
    public void selectVacancyOption() {
         String VacancyToSelect = ItemsInDropDownListCandidateFlter.VacancyMap.get(5); // Senior QA Lead
        pages.VacancyText(VacancyToSelect).click();}

    //  Методы для HiringManager
    public void openHiringManagerDropdown() {
        pages.HiringManager().click();
    }
    // Выбираем элемент
    public void selectHiringManagerOption() {
        String HiringManagerSelect = ItemsInDropDownListCandidateFlter.HiringManagerMap.get(2); // Senior QA Lead
        pages.HiringManagerText(HiringManagerSelect).click();}

    // Методы для Status
    public void openStatusDropdown() {
        pages.Status().click();
    }
    // Выбираем элемент
    public void selectStatusOption() {
        String StatusSelect = ItemsInDropDownListCandidateFlter.StatusMap.get(5); // Senior QA Lead
        pages.StatusText(StatusSelect).click();
    }

    // Методы для поля Candidate Name
    public void enterCandidateName(String CandidateName) {
        pages.CandidateName().clear();
        pages.CandidateName().sendKeys(CandidateName);
    }

    // Методы для поля Keywords
    public void enterKeywords(String Keywords) {
        pages.Keywords().clear();
        pages.Keywords().sendKeys(Keywords);
    }

    // Методы для Date of Application-From
    public void clickFrom() {
        pages.From().click();
    }
    public void clickTodayButton() {
        pages.TodayButton().click();
    }
    public void clickClearButton() {
        pages.ClearButton().click();
    }
    public void clickCloseButton(){
        pages.CloseButton().click();
    }
    public void selectDate(String day) {
        pages.dateCellNumber(day).click();
    }
    public void goToNextMonth() {
        pages.nextMonthButton().click();
    }

    public void goToPrevMonth() {
        pages.prevMonthButton().click();
    }

    // Методы для Date of Application-To
    public void clickTo(){
        pages.To().click();
    }




}
