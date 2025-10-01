package Tests;
import Methods.RecruitmentViewCandidatesMethods;
import Pages.RecruitmentViewCandidatesPages;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.chrome.ChromeOptions;

public class RecruitmentViewCandidatesTests {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static RecruitmentViewCandidatesMethods methods;
    private static RecruitmentViewCandidatesPages pages;

    private static final String LOGIN_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    private static final String CANDIDATES_URL = "https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewCandidates";

    @BeforeEach
    public void refreshPage() {
        if (driver != null) {
            driver.navigate().refresh();
        }
    }

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        methods = new RecruitmentViewCandidatesMethods(driver, wait);

        // Логинимся
        driver.get(LOGIN_URL);
        methods.enterUsername("Admin");
        methods.enterPassword("admin123");
        methods.clickLoginButton();

        // Ждём загрузки Dashboard
        methods.waitForDashboardToLoad();

        // Переходим в Recruitment → Candidates
        driver.get(CANDIDATES_URL);
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Написать тесты на проверку таблицы по фильтрам, на каждый фильтр проверка таблицы по выводу

    @Test
    @DisplayName("Проверка URL страницы Candidates")
    public void testOpenRecruitment() {
        // Уже находимся на странице Candidates после @BeforeAll
        String actualUrl = driver.getCurrentUrl();
        assertEquals(CANDIDATES_URL, actualUrl, "Неверный URL — не страница Candidates");
    }

    @Test
    @DisplayName("Проверка выпадающего списка Job Title")
    public void testDropdownListJobTitle() {

        // Открываем выпадающий список Job Title
        methods.openJobTitleDropdown();

        // Выбираем один элемент из выпадающего списка
        methods.selectJobTitleOption();

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Reset для очистки фильтрации
        methods.clickResetButton();
    }

    @Test
    @DisplayName("Проверка выпадающего списка Vacancy")
    public void testDropdownListVacancy() {

        // Открываем выпадающий список Vacancy
        methods.openVacancyDropdown();

        // Выбираем один элемент из выпадающего списка
        methods.selectVacancyOption();
        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Reset для очистки фильтрации
        methods.clickResetButton();
    }

    @Test
    @DisplayName("Проверка выпадающего списка Hiring Manager")
    public void testDropdownListHiringManager() {

        // Открываем выпадающий список Hiring Manager
        methods.openHiringManagerDropdown();

        // Выбираем один элемент из выпадающего списка
        methods.selectHiringManagerOption();

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Reset для очистки фильтрации
        methods.clickResetButton();
    }

    @Test
    @DisplayName("Проверка выпадающего списка Status")
    public void testDropdownListStatus() {

        // Открываем выпадающий список Status
        methods.openStatusDropdown();

        // Выбираем один элемент из выпадающего списка
        methods.selectStatusOption();

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Reset для очистки фильтрации
        methods.clickResetButton();
    }

    @Test
    @DisplayName("Проверка поля Candidate Name")
    public void testListCandidateName() {

        // Вводим в поле любое значение
        methods.enterCandidateName("Rahul Sharma");

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Reset для очистки фильтрации
        methods.clickResetButton();
    }

    @Test
    @DisplayName("Проверка поля Keywords")
    public void testListKeywords() {

        // Вводим в поле любое значение
        methods.enterKeywords("QA");

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Reset для очистки фильтрации
        methods.clickResetButton();

    }

    @Test
    @DisplayName("Проверка поля Date of Application From")
    public void testListFrom() {

        // Проверяем открытие календаря при клике на поле
        methods.clickFrom();

        // Выбираем текущую дату
        methods.clickTodayButton();

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Close для выхода из календаря
        methods.clickCloseButton();

        //Кликаем на кнопку Clear в календаре
        methods.clickClearButton();

        // Выбираем дату из прошлого (например 15 число предыдущего месяца)
        methods.goToPrevMonth();
        methods.selectDate("15");

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Выбираем дату из будущего (например 1 число следующего месяца)
        // Выбираем следующий месяц
        methods.goToNextMonth();
        methods.selectDate("1");

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Удаляем введенную дату из поля
        methods.clickClearButton();

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();
    }

    @Test
    @DisplayName("Проверка поля Date of Application To")
    public void testListTo() {

        // Проверяем открытие календаря при клике на поле
        methods.clickTo();

        // Выбираем текущую дату
        methods.clickTodayButton();

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Close для выхода из календаря
        methods.clickCloseButton();

        //Кликаем на кнопку Clear в календаре
        methods.clickClearButton();

        // Выбираем дату из прошлого (например 15 число предыдущего месяца)
        methods.goToPrevMonth();
        methods.selectDate("15");

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Выбираем дату из будущего (например 1 число следующего месяца)
        // Выбираем следующий месяц
        methods.goToNextMonth();
        methods.selectDate("1");

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Удаляем введенную дату из поля
        methods.clickClearButton();

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();
    }

    @Test
    @DisplayName("Проверка выпадающего списка Method of Application")
    public void testDropdownListMethodOfApplication() {

        // Открываем выпадающий список Method of Application

        // Выбираем один элемент из выпадающего списка

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

        // Кликаем на кнопку Reset для очистки фильтрации
        methods.clickResetButton();
    }
}
