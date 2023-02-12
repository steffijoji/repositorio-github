package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RepositorioTest {
    private static WebDriver driver;
    private static String urlInicial = "https://github.com";

    @BeforeAll
    public static void setUp() {
        // Abrir o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver_win32_110\\chromedriver.exe");
        driver = new ChromeDriver();

        // Maximizar a tela
        driver.manage().window().maximize();

        // Definir um tempo de espera padrão de 5 segundos
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Navegar para a página do GitHub
        driver.get(urlInicial);
    }

    @Test
    @Order(1)
    @DisplayName("Buscar usuário existente")
    public void buscarUsuarioExistente() {
        String textoApresentado = new HomePage(driver)
                .searchUser("steffijoji")
                .getText();

        Assertions.assertFalse(this.urlInicial.equals(driver.getCurrentUrl()));
        Assertions.assertEquals("We couldn’t find any repositories matching 'steffijoji'", textoApresentado);
    }

    @Test
    @Order(2)
    @DisplayName("Acessar perfil do usuário")
    public void acessarUserProfile() {
        String username = new HomePage(driver)
                .findUser()
                .getUsername();

        Assertions.assertEquals("steffijoji", username);
    }

    @Test
    @Order(3)
    @DisplayName("Acessar repositórios")
    public void acessarRepositorio() {

    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }


    // buscar repositorio
    // acessar read-me

}
