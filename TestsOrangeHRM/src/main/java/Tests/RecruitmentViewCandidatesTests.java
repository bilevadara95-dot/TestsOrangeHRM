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
        // Убедимся, что мы на странице Recruitment
        methods.OpenRecruitment();

        // Открываем выпадающий список Job Title
        methods.openJobTitleDropdown();

        // Выбираем один элемент из выпадающего списка
        methods.selectJobTitleOption();

        // Проверяем верно ли отображается выбранный элемент
        methods.getSelectedJobTitleText();

        // Кликаем на кнопку поиска для проверки фильтрации по таблице
        methods.clickSearchButton();

    }
}
