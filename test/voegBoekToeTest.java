import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class voegBoekToeTest {
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
    public void return_formulier_met_3_fout_bootschappen_als_alle_velden_leeg_ingevult_worden(){
        driver.get(url +"voegToe.jsp");
        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("");

        WebElement auteur = driver.findElement(By.id("auteur"));
        auteur.clear();
        auteur.sendKeys("");

        WebElement aantalPaginas = driver.findElement(By.id("aantalPaginas"));
        aantalPaginas.clear();
        aantalPaginas.sendKeys("");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        assertEquals("voeg boek toe", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(arrayListContainsWebelementWithText(lis,"Dit is geen geldige titel."));
        assertTrue(arrayListContainsWebelementWithText(lis,"Dit is geen geldige auteur."));
        assertTrue(arrayListContainsWebelementWithText(lis,"het invoer veld voor 'aantal paginas' kan enkel cijfers bevatten."));
    }

    @Test
    public void return_formulier_met_1_fout_boodschap_als_titel_leeg_ingevuld_word(){
        driver.get(url + "voegToe.jsp");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("");

        WebElement auteur = driver.findElement(By.id("auteur"));
        auteur.clear();
        auteur.sendKeys("Hal Elrod");

        WebElement aantalPaginas = driver.findElement(By.id("aantalPaginas"));
        aantalPaginas.clear();
        aantalPaginas.sendKeys("208");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        assertEquals("voeg boek toe", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(arrayListContainsWebelementWithText(lis,"Dit is geen geldige titel."));
        assertEquals("Hal Elrod", driver.findElement(By.id("auteur")).getAttribute("value"));
        assertEquals("208", driver.findElement(By.id("aantalPaginas")).getAttribute("value"));
    }

    @Test
    public void return_formulier_met_1_fout_boodschap_als_auteur_leeg_ingevuld_word(){
        driver.get(url + "voegToe.jsp");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("Miracle Morning");

        WebElement auteur = driver.findElement(By.id("auteur"));
        auteur.clear();
        auteur.sendKeys("");

        WebElement aantalPaginas = driver.findElement(By.id("aantalPaginas"));
        aantalPaginas.clear();
        aantalPaginas.sendKeys("5");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        assertEquals("voeg boek toe", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(arrayListContainsWebelementWithText(lis,"Dit is geen geldige auteur."));
        assertEquals("Miracle Morning", driver.findElement(By.id("titel")).getAttribute("value"));
        assertEquals("5", driver.findElement(By.id("aantalPaginas")).getAttribute("value"));
    }
    @Test
    public void return_formulier_met_eerste_fout_boodschap_als_aantalPaginas_leeg_ingevuld_word(){
        driver.get(url + "voegToe.jsp");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("Miracle Morning");

        WebElement auteur = driver.findElement(By.id("auteur"));
        auteur.clear();
        auteur.sendKeys("Hal Elrod");

        WebElement aantalPaginas = driver.findElement(By.id("aantalPaginas"));
        aantalPaginas.clear();
        aantalPaginas.sendKeys("");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        assertEquals("voeg boek toe", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(arrayListContainsWebelementWithText(lis,"het invoer veld voor 'aantal paginas' kan enkel cijfers bevatten."));
        assertEquals("Miracle Morning", driver.findElement(By.id("titel")).getAttribute("value"));
        assertEquals("Hal Elrod", driver.findElement(By.id("auteur")).getAttribute("value"));
    }
    @Test
    public void return_formulier_met_tweede_fout_boodschap_als_aantalPaginas_kleiner_is_dan_5(){
        driver.get(url + "voegToe.jsp");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("Miracle Morning");

        WebElement auteur = driver.findElement(By.id("auteur"));
        auteur.clear();
        auteur.sendKeys("Hal Elrod");

        WebElement aantalPaginas = driver.findElement(By.id("aantalPaginas"));
        aantalPaginas.clear();
        aantalPaginas.sendKeys("4");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        assertEquals("voeg boek toe", driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(arrayListContainsWebelementWithText(lis,"Een boek moet minstens 5 pagina's hebben."));
        assertEquals("Miracle Morning", driver.findElement(By.id("titel")).getAttribute("value"));
        assertEquals("Hal Elrod", driver.findElement(By.id("auteur")).getAttribute("value"));
    }

    @Test
    public void return_overzicht_als_alles_correct_is_ingevuld(){
        driver.get(url + "voegToe.jsp");

        WebElement titel = driver.findElement(By.id("titel"));
        titel.clear();
        titel.sendKeys("Miracle Morning");

        WebElement auteur = driver.findElement(By.id("auteur"));
        auteur.clear();
        auteur.sendKeys("Hal Elrod");

        WebElement aantalPaginas = driver.findElement(By.id("aantalPaginas"));
        aantalPaginas.clear();
        aantalPaginas.sendKeys("208");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        assertEquals("boeken overzicht", driver.getTitle());
        ArrayList<WebElement> tds = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(arrayListContainsWebelementWithText(tds,"Miracle Morning"));
        assertTrue(arrayListContainsWebelementWithText(tds,"Hal Elrod"));
        assertTrue(arrayListContainsWebelementWithText(tds,"208"));
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
