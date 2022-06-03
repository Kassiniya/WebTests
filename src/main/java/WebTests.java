import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class WebTests {
    //Тест кейс:
    //1. Открыть страницу http://www.99-bottles-of-beer.net/
    //2. Нажать пункт меню Browse Languages
    //3. Нажать пункт меню Start
    //4. Подтвердить, что пользователь видит заголовок "Welcome to 99 Bottles of Beer"
    //5. Закрыть браузер
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String DRIVER_PATH = "C:\\Program Files\\Chromedriver\\Chromedriver.exe";
    private static final String URL = "http://www.99-bottles-of-beer.net/";

    @Test
    public void testMenuStartTitle() throws InterruptedException {

        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "C:\\Program Files\\Chromedriver\\Chromedriver.exe";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(
                By.xpath(
                        "//body/div[@id='wrap']/div[@id='navigation']" +
                                "/ul[@id='menu']/li/a[@href='/abc.html']"
                )
        );
        menuBrowseLanguages.click();

        WebElement menuStart = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );
        menuStart.click();

        WebElement h2 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='main']/h2")
        );
        String actualResult = h2.getText();
        //sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
    //Тест кейс:
    // Подтвердите, что на странице по базовой ссылке в правом верхнем углу пользователь
    // видит заголовок 99 Bottles of Beer
    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Считать заголовок в правом верхнем углу
    // 3. Подтвердить, что текст заголовка соответствует ожидаемому
    // 4. Закрыть браузер


    @Test
    public void testFindTitleName() throws InterruptedException {
        String expectedResult = "99 Bottles of Beer";
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        WebElement menuStartReturn = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );

        WebElement h1 = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='header']/h1")
        );
        String actualResult = h1.getText();
        //sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);
        //sleep(2000);

        driver.quit();
    }
    //TC_11_03 Подтвердите, что на странице по базовой ссылке последний пункт меню имеет подзаголовок Submit new Language

    //Шаги:
    //1. Открыть вебсайт на базовой странице
    //2. Нажать на пункт меню Submit new Language
    //3. Считать название подзаголовка последнего пункта меню
    //4. Подтвердить, что название подзаголовка последнего пункта меню соответствует ожидаемому
    //5. Закрыть браузер

    @Test
    public void testFindMenuTitleName() throws InterruptedException {
        String expectedResult = "Submit New Language";
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(URL);

        WebElement menuStartReturn = driver.findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/ul[@id='menu']/li/a[@href='/']")
        );

        WebElement menuSubmitNewLanguage = driver.findElement(
                By.xpath(
                        "//div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );
        menuSubmitNewLanguage.click();
        WebElement h1 = driver.findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li")
        );

        String actualResult = h1.getText();
        sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);
        sleep(2000);

        driver.quit();
    }
//    TC_11_02 Подтвердите, что на странице по базовой ссылке последний пункт меню называется Submit new Language
//
//    Шаги:
//   1. Открыть вебсайт на базовой странице
//   2. Считать название последнего пункта меню
//   3. Подтвердить, что название последнего пункта меню соответствует ожидаемому
//   4. Закрыть браузер

    @Test
    public void testFindTitle() throws InterruptedException {
        String expectedResult = "Submit New Language";
        System.setProperty(CHROME_DRIVER, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.get(URL);


        WebElement menuSubmitNewLanguage = driver.findElement(
                By.xpath(
                        "//div[@id='navigation']/ul[@id='menu']/li/a[@href='/submitnewlanguage.html']")
        );


        String actualResult = menuSubmitNewLanguage.getText();
        sleep(2000);

        Assert.assertEquals(actualResult, expectedResult.toUpperCase());
        sleep(2000);

        driver.quit();
    }
}
