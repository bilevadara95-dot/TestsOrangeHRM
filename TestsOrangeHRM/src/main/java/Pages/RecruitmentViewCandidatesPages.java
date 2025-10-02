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
        return By.cssSelector("button[type=\"reset\"]");
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
        return By.xpath("//label[text()='Vacancy']//following::div[contains(@class, 'oxd-select-text')][1]");
    }
    public WebElement Vacancy(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(VacancyBy()));
        return driver.findElement(VacancyBy());
    }
    // Локатор для выбора элемента из выпадающего списка
    private By VacancyByText(String text) {
        return By.xpath("//div[@role='listbox']//span[text()='" + text + "']");
    }
    public WebElement VacancyText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(VacancyByText(text)));
        return driver.findElement(VacancyByText(text));
    }

    // Hiring Manager
    // Локатор выпадающего списка
    private By HiringManagerBy() {
        return By.xpath("//label[text()='Hiring Manager']//following::div[contains(@class, 'oxd-select-text')][1]");
    }
    public WebElement HiringManager(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(HiringManagerBy()));
        return driver.findElement(HiringManagerBy());
    }
    // Локатор для выбора элемента из выпадающего списка
    private By HiringManagerByText(String text) {
        return By.xpath("//div[@role='listbox']//span[text()='" + text + "']");
    }
    public WebElement HiringManagerText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(HiringManagerByText(text)));
        return driver.findElement(HiringManagerByText(text));
    }

    // Status
    // Локатор выпадающего списка
    private By StatusBy() {
        return By.xpath("//label[text()='Status']//following::div[contains(@class, 'oxd-select-text')][1]");
    }
    public WebElement Status() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(StatusBy()));
        return driver.findElement(StatusBy());
    }
    // Локатор для выбора элемента из выпадающего списка
    private By StatusByText(String text) {
        return By.xpath("//div[@role='listbox']//span[text()='" + text + "']");
    }
    public WebElement StatusText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(StatusByText(text)));
        return driver.findElement(StatusByText(text));
    }

    // Candidate Name
    // Локатор поля
    private By CandidateNameBy() {
        return By.cssSelector("input[data-v-75e744cd][placeholder='Type for hints...']");
    }
    public WebElement CandidateName() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CandidateNameBy()));
        return driver.findElement(CandidateNameBy());
    }

    //Keywords
    // Локатор поля
    private By KeywordsBy() {
        return By.cssSelector(".oxd-table-filter-area input.oxd-input");
    }
    public WebElement Keywords() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(KeywordsBy()));
        return driver.findElement(KeywordsBy());
    }

    //Date of Application-From
    // Локатор поля
    private By FromBy() {
        return By.cssSelector("input[placeholder='From']");
    }
    public WebElement From() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FromBy()));
        return driver.findElement(FromBy());
    }
    // Локатор кнопки Today
    private By TodayButtonBy() {
        return By.cssSelector("div.oxd-date-input-link.--today");
    }
    public WebElement TodayButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(TodayButtonBy()));
        return driver.findElement(TodayButtonBy());
    }
    // Локатор кнопки Close
    private By CloseButtonBy() {
        return By.cssSelector("div.oxd-date-input-link.--close");
    }
    public WebElement CloseButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseButtonBy()));
        return driver.findElement(CloseButtonBy());
    }
    // Локатор кнопки Clear
    private By ClearButtonBy() {
        return By.cssSelector("div.oxd-date-input-link.--clear");
    }
    public WebElement ClearButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClearButtonBy()));
        return driver.findElement(ClearButtonBy());
    }
    // Локатор по числу
    private By dateCellByNumber(String day) {
        return By.xpath("//div[contains(@class, 'oxd-calendar-date') and text()='15']");
    }
    public WebElement dateCellNumber(String day) {
        By locator = dateCellByNumber(day);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }
    // Локатор по месяцу стрелка вправо
    private By nextMonthButtonBy() {
        return By.cssSelector("button.oxd-icon-button:last-child");
    }
    public WebElement nextMonthButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextMonthButtonBy()));
        return driver.findElement(nextMonthButtonBy());
    }
    // Локатор по месяцу стрелка влево
    private By prevMonthButtonBy() {
        return By.cssSelector("button.oxd-icon-button:first-child");
    }
    public WebElement prevMonthButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(prevMonthButtonBy()));
        return driver.findElement(prevMonthButtonBy());
    }

    //Method of Application
    // Локатор для выпадающего списка
    private By MethodOfApplicationBy(){
        return By.xpath("//label[text()='Method of Application']//following::div[contains(@class, 'oxd-select-text')][1]");
    }
    public WebElement MethodOfApplication(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(MethodOfApplicationBy()));
        return driver.findElement(MethodOfApplicationBy());
    }
    // Локатор для выбора элемента из выпадающего списка
    private By MethodOfApplicationByText(String text) {
        return By.xpath("//div[@role='listbox']//span[text()='" + text + "']");
    }
    public WebElement MethodOfApplicationText(String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(MethodOfApplicationByText(text)));
        return driver.findElement(MethodOfApplicationByText(text));
    }




}
