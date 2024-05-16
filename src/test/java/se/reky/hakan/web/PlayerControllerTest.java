package se.reky.hakan.web;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Disabled
class PlayerControllerTest {
    
    // TODO: 2024-05-15 Ändra namn på spelaer
/*
* Spela alltid två rundor!!
* */
    
    private WebDriver driver;
    private String playersUrl = "http://localhost:8080/players";
    
    
    @BeforeAll
//    sätt upp webdriver manager
    public static void init(){
        WebDriverManager.chromedriver().setup();
    
    }
    
//    instansiera webdriver före varje test
    @BeforeEach
    void setDriver(){
        driver = new ChromeDriver();
    }
    
//    metod som stänger WebDriver efter varje test
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
//
//1) Verifiera att rätt antal players visas i listan (exempel: har du spelat två spel bör det finnas
//            två players i listan och detta ska verifieras)
//2) Verifiera att namnet på den första playern i listan visas på sidan (använd metoden
//  isDisplayed() i klassen WebElement).
//3) Testa att sidans titel överensstämmer med förväntat värde
//4) Testa att knappen har texten = Logga in
    
    @Test
    void numOfPlayersShouldBeTwo() {
        driver.get(playersUrl);
        List<WebElement> players = driver.findElements(By.tagName("li"));
        assertEquals(2, players.size());
    }
    
    @Test
    void firstNameOfPlayerListShouldBeVisible(){
        driver.get(playersUrl);
        List<WebElement> players = driver.findElements(By.className("player-name"));
        boolean playerIsDisplayed = players.get(0).isDisplayed();
        assertTrue(playerIsDisplayed);
    }
    
    @Test
    void pageShouldHaveCorrectTitle(){
        driver.get(playersUrl);
        String result = driver.getTitle();
        assertEquals("Players List", result);
    }
    
    @Test
    void buttonShouldHaveTheRightText(){
        driver.get(playersUrl);
        String result = driver.findElement(By.tagName("button")).getText();
        assertEquals("Logga in", result);
    }
    
    
    @Test
    void playerNameShouldExistInPlayerid(){
        driver.get(playersUrl);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        List<WebElement> playerLinks = driver.findElements(By.className("player-details-link"));
        playerLinks.get(0).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("player-div")));
        boolean playerNameIsDisplayed = driver.findElement(By.className("player-name")).isDisplayed();
        assertTrue(playerNameIsDisplayed);
        
        
    }
    
    
    
    
    
}