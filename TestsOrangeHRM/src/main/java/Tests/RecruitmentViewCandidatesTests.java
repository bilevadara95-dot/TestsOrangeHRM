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
    }

    @Test
    @DisplayName("Проверка выпадающего списка Vacancy")
    public void testDropdownListVacancy() {

        // Открываем выпадающий список Vacancy

        // Выбираем один элемент из выпадающего списка

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Кликаем на кнопку Reset для очистки фильтрации
    }

    @Test
    @DisplayName("Проверка выпадающего списка Hiring Manager")
    public void testDropdownListHiringManager() {

        // Открываем выпадающий список Hiring Manager

        // Выбираем один элемент из выпадающего списка

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Кликаем на кнопку Reset для очистки фильтрации
    }

    @Test
    @DisplayName("Проверка выпадающего списка Status")
    public void testDropdownListStatus() {

        // Открываем выпадающий список Status

        // Выбираем один элемент из выпадающего списка

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Кликаем на кнопку Reset для очистки фильтрации
    }

    @Test
    @DisplayName("Проверка поля Candidate Name")
    public void testListCandidateName() {

        // Вводим в поле любое значение

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Удаляем введенное значение и проверяем что вывод в таблице вернулся к исходному состоянию

    }

    @Test
    @DisplayName("Проверка поля Keywords")
    public void testListKeywords() {

        // Вводим в поле любое значение

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Удаляем введенное значение и проверяем что вывод в таблице вернулся к исходному состоянию

    }

    @Test
    @DisplayName("Проверка поля Date of Application From")
    public void testListFrom() {

        // Проверяем открытие календаря при клике на поле

        // Выбираем текущую дату

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Выбираем дату из прошлого

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Выбираем дату из будущего

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Удаляем введенную дату из поля

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Кликаем на кнопку Reset для очистки фильтрации
    }

    @Test
    @DisplayName("Проверка поля Date of Application To")
    public void testListTo() {

        // Проверяем открытие календаря при клике на поле

        // Выбираем текущую дату

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Выбираем дату из прошлого

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Выбираем дату из будущего

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Удаляем введенную дату из поля

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Кликаем на кнопку Reset для очистки фильтрации
    }

    @Test
    @DisplayName("Проверка выпадающего списка Method of Application")
    public void testDropdownListMethodofApplication() {

        // Открываем выпадающий список Method of Application

        // Выбираем один элемент из выпадающего списка

        // Кликаем на кнопку поиска для проверки фильтрации по таблице

        // Кликаем на кнопку Reset для очистки фильтрации
    }
}
