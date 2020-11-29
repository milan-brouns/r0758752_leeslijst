import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class updateTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/";

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\milan\\Documents\\1UCLL it\\2020-2021\\web 2\\bestanden\\chromedriver_win32_crome_version87\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void titel_command_en_button_zijn_aangepast(){
        driver.get(url +"Servlet?command=overzicht");
        driver.findElement(By.linkText("update")).click();
        assertEquals("update boek", driver.getTitle());
        assertEquals("http://localhost:8080/Servlet?command=updateBoek",driver.findElement(By.tagName("form")).getAttribute("action"));
        assertEquals("update dit boek", driver.findElement(By.id("submit")).getAttribute("value"));
    }

    @Test
    public void auteur_wijzigt_als_deze_aangepast_word(){
        driver.get(url +"Servlet?command=overzicht");
        driver.findElement(By.linkText("update")).click();

        WebElement auteur = driver.findElement(By.id("auteur"));
        auteur.clear();
        auteur.sendKeys("Garr Keler");
        driver.findElement(By.id("submit")).click();

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(arrayListContainsWebelementWithText(tds,"Garr Keler"));
    }

    @Test
    public void titel_word_niet_aangepast_als_velt_leeg_is_en_foutboodschap_word_gegeven(){
        driver.get(url +"Servlet?command=overzicht");
        driver.findElement(By.linkText("update")).click();

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("");
        driver.findElement(By.id("submit")).click();

        assertEquals("update boek", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(arrayListContainsWebelementWithText(lis,"Dit is geen geldige titel."));

        driver.findElement(By.linkText("overzicht van boeken")).click();

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(arrayListContainsWebelementWithText(tds,"The one thing"));
    }

    @Test
    public void past_aantalPaginas_maar_titel_niet_bij_input_5_en_titel_leeg(){

        driver.get(url +"Servlet?command=update&boekTitel=The one thing");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("");
        WebElement aantalPaginas = driver.findElement(By.id("aantalPaginas"));
        aantalPaginas.clear();
        aantalPaginas.sendKeys("5");
        driver.findElement(By.id("submit")).click();

        assertEquals("update boek", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(arrayListContainsWebelementWithText(lis,"Dit is geen geldige titel."));

        driver.findElement(By.linkText("overzicht van boeken")).click();

        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(arrayListContainsWebelementWithText(tds,"The one thing"));
        assertTrue(arrayListContainsWebelementWithText(tds,"5"));


    }

    private boolean arrayListContainsWebelementWithText(ArrayList<WebElement> list, String value) {
        for( WebElement webElement : list){
            if (value.equals(webElement.getText())){
                return true;
            }
        }
        return false;
    }

}


