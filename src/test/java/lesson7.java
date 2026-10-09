package lssn7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class lesson7 {

    @Test
    void TsetMyTest() {
        // Настройка браузера
        Configuration.browser = "chrome";
        //Configuration.browserSize = "900x900";
        Configuration.holdBrowserOpen =true; // чтобы бразуер не закрылся, для поиска Css селекторов итд
        Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, не дожидаемся полной загрузки

//скрыть факт автоматизации
        ChromeOptions options = new ChromeOptions(); // создаем новый объект для обхода ботов
        options.addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browserCapabilities = options;
        open("https://demoqa.com/text-box");

// Разворачиваем окно на весь экран и получаем размер в виде сообщения, нужно ставить после запуска, открытия бразуера иначе будет ошибка
        getWebDriver().manage().window().maximize();
        System.out.println("Real size: " + getWebDriver().manage().window().getSize());

        $("h1").shouldHave(text("Text Box"));

        $("#userName").setValue("Egor");
        $("#userEmail").setValue("Egor@mail.ru");
        $("#currentAddress").setValue("Moscow sity");
        $("#permanentAddress").setValue("Lenina 244 /45");

        $("#submit").shouldHave(text("Submit")).hover().click();








    }
}