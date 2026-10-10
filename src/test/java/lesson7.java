package lssn7;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class lesson7 {

   @BeforeAll
   static void SetUpBrowser() {
// Настройка браузера
            Configuration.browser = "chrome";
            Configuration.browserSize = "1900x1200";
            Configuration.timeout = 10000;
            Configuration.holdBrowserOpen = true; // чтобы бразуер не закрылся, для отладки
            Configuration.pageLoadStrategy = "eager"; //стратегия загрузки, не дожидаемся полной загрузки
            Configuration.baseUrl = "https://demoqa.com";


// Настройки бразуера для стабильной работы тестов, только не помогает все равно, из за обновления хрома, селенид не поддерживает эту версию хрома и работает через раз
            ChromeOptions options = new ChromeOptions(); // создаем новый объект для обхода ботов
            options.addArguments("--disable-blink-features=AutomationControlled"); //скрывает факт автоматизации
/*
            options.addArguments("--disable-gpu"); // отключает GPU-рендеринг (частая причина таймаутов)
            options.addArguments("--no-sandbox"); // упрощает запуск
            options.addArguments("--disable-dev-shm-usage"); // обходит проблемы с shared memory
            options.setCapability("webSocketUrl", false); // отключает BiDi
            options.addArguments("--dns-prefetch-disable"); // отключает предзагрузку DNS — частая причина зависаний
            options.addArguments("--enable-cdp-events");    // принудительно включает CDP-события, стабилизирует связь
            options.addArguments("--user-data-dir=C:\\temp\\chrome-profile-" + System.currentTimeMillis()); // чистый запуск браузера
      */
            Configuration.browserCapabilities = options;
   }

    @Test
    void TsetMyTest() {
        open("/text-box");

// Разворачиваем окно на весь экран и получаем размер в виде сообщения, нужно ставить после запуска, открытия бразуера иначе будет ошибка, работает не стабильно иногад из за драйвера селениума и нового хрома
 /*       getWebDriver().manage().window().maximize();
        System.out.println("Real size: " + getWebDriver().manage().window().getSize());

 */
        String userName = "Egor Ivanov"; // добавлена перменная имя

        $("h1").shouldHave(text("Text Box"));

        $("#userName").setValue(userName);
        $("#userEmail").setValue("Egor@mail.ru");
        $("#currentAddress").setValue("Moscow sity");
        $("#permanentAddress").setValue("Lenina 244 /45");

        $("#submit").shouldHave(text("Submit")).hover().click();


        $("#name").shouldHave(text(userName)).shouldBe(visible);


    }
}