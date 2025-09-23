package Tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class LoginTest {

    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterEach
    public void resetState() {
        try {
            // Пытаемся выйти, если вошли
            WebElement userDropdown = driver.findElement(By.xpath("//p[@class='oxd-userdropdown-name']"));
            if (userDropdown.isDisplayed()) {
                userDropdown.click();
                WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[text()='Logout']")));
                logoutButton.click();
                wait.until(ExpectedConditions.urlContains("/auth/login"));
            }
        } catch (Exception e) {
            // Если не вошли — просто перезагружаем страницу логина
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        }

        // Ждём, пока страница логина загрузится
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));

    }

    @Test
    @DisplayName("Позитивный тест: Успешный вход с валидными данными")
    public void testValidLogin() {
        // Открываем страницу логина
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Ждем появления поля ввода имени
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        // Вводим валидные данные
        usernameField.sendKeys("Admin");
        passwordField.sendKeys("admin123");
        loginButton.click();

        // Проверяем, что мы на главной странице
        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
        Assertions.assertTrue(dashboardHeader.isDisplayed(), "Заголовок 'Dashboard' не найден — вход не удался");
    }

    @Test
    @DisplayName("Негативный тест: Пустое поле пароль")
    public void testEmptyPassword() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.sendKeys("Admin");
        passwordField.clear();
        loginButton.click();

        // Ожидаем появления сообщения "Required" под полем пароля
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Required']")));
    }

    @Test
    @DisplayName("Негативный тест: Пустое поле имя пользователя")
    public void testEmptyUsername() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameField.clear();
        passwordField.sendKeys("admin123");
        loginButton.click();

        // Ожидаем появления сообщения "Required" под полем логина
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Required']"))
        );
    }
}
