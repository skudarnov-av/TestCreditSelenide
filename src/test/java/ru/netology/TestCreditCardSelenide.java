package ru.netology;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCreditCardSelenide {
    @BeforeEach
    void shouldOpenBrowser() {
        open("http://localhost:9999");
    }

    @Test
    public void test() {
        $("[data-test-id=name] input").val("Скударнов Александр");
        $("[data-test-id=phone] input").val("+79226099999");
        $("[data-test-id=agreement]").click();
        $("[type=\"button\"]").click();
        $("[data-test-id=order-success]").shouldHave(exactText(("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время")));

    }
}
