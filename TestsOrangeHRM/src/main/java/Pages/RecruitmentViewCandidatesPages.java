package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RecruitmentViewCandidatesPages {

    private WebDriver driver;
    private WebDriverWait wait;

    public RecruitmentViewCandidatesPages(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    // Логин страница
    private By UsernameFieldBy() {
        return By.name("username");
    }
    public WebElement UsernameField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(UsernameFieldBy()));
        return driver.findElement(UsernameFieldBy());
    }
    //Пароль
    private By PasswordFieldBy() {
        return By.name("password");
    }
    public WebElement PasswordField() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PasswordFieldBy()));
        return driver.findElement(PasswordFieldBy());
    }
    //Логин
    private By LoginButtonBy() {
        return By.cssSelector("button[type='submit']");
    }
    public WebElement LoginButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LoginButtonBy()));
        return driver.findElement(LoginButtonBy());
    }

    // Dashboard
    private By DashboardHeaderBy() {
        return By.cssSelector("h6.oxd-text--h6");
    }
    public WebElement DashboardHeader() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DashboardHeaderBy()));
        return driver.findElement(DashboardHeaderBy());
    }

    // Recruitment
    private By RecruitmentBy() {
        return By.cssSelector(".oxd-main-menu-item-wrapper.oxd-main-menu-item");
    }
    public WebElement Recruitment(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(RecruitmentBy()));
        return driver.findElement(RecruitmentBy());
    }

    // Локатор для кнопки поиска, для применения фильтров
    private By searchButtonBy() {
        return By.cssSelector("button.oxd-button--secondary.orangehrm-left-space[type='submit']");
    }
    public WebElement searchButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButtonBy()));
        return driver.findElement(searchButtonBy());
    }
    // Локатор для кнопки Reset для очистки фильтров
    private By resetButtonBy() {
        return By.cssSelector("button.oxd-button oxd-button--medium oxd-button--ghost");
    }
    public WebElement resetButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetButtonBy()));
        return driver.findElement(resetButtonBy());
    }

    // Job Title Dropdown
    //Локатор выпадающего списка (кликабельная часть)
    private By JobTitleBy() {
        return By.cssSelector("form div.oxd-grid-item:first-child div.oxd-select-wrapper");
    }
    public WebElement JobTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(JobTitleBy()));
        return driver.findElement(JobTitleBy());
    }
    //Локатор для выбора элемента
    private By titleOptionByText(String text) {
        return By.xpath("//div[@role='option']//span[text()='" + text + "']");
    }

    public WebElement getTitleOptionByText(String text) {
        By locator = titleOptionByText(text);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    // Vacancy Dropdown
    // Локатор выпадающего списка (кликабельная часть)
    private By VacancyBy() {
        return By.cssSelector("form div.oxd-grid-item .oxd-select-wrapper .oxd-select-text");
    }
    public WebElement Vacancy(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(VacancyBy()));
        return driver.findElement(VacancyBy());
    }
    // Локатор для выбора элемента из выпадающего списка
    private By VacancyByText(String text) {
        return By.xpath("////div[@role='listbox']//span[text()='" + text + "']");
    }
    public WebElement VacancyText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(VacancyByText(text)));
        return driver.findElement(VacancyByText(text));
    }

}
