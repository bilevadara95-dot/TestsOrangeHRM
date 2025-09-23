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

    // Job Title Dropdown
    //Локатор выпадающего списка (кликабельная часть)
    private By JobTitleBy() {
        return By.cssSelector(".form div.oxd-grid-item:first-child div.oxd-select-wrapper");
    }
    public WebElement JobTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(JobTitleBy()));
        return driver.findElement(JobTitleBy());
    }
    //Локатор выпадающего списка (после клика)
    private By JobTitleBy1() {
        return By.cssSelector(".div[role='listbox']");
    }
    public WebElement JobTitle1(){
        return driver.findElement(JobTitleBy1());
    }
    //Локатор для выбора элемента
    private By TitleOptionByText() {
        return By.cssSelector(".div[role='listbox']");
    }
    public WebElement TitleOptionText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TitleOptionByText()));
        return driver.findElement(TitleOptionByText());
    }
    // Локатор для отображения после выбора элемента
    private By selectedJobTitleValueBy() {
        return By.cssSelector(".div[role='listbox']");
    }
    public WebElement selectedJobTitleValue(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedJobTitleValueBy()));
        return driver.findElement(selectedJobTitleValueBy());
    }
    // Локатор для кнопки поиска, для применения фильтров
    private By searchButtonBy() {
        return By.cssSelector(".div[role='listbox']");
    }
    public WebElement searchButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButtonBy()));
        return driver.findElement(searchButtonBy());
    }
}
