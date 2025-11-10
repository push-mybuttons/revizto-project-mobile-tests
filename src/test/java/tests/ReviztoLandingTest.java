package tests;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Epic("Мобильное тестирование Revizto")
@Feature("Лендинг страница")
@Owner("MariiaP")
public class ReviztoLandingTest extends BaseTest {

    @Test
    @Story("Проверка основных элементов лендинга")
    @DisplayName("Проверка заголовка и основного контента")
    @Severity(SeverityLevel.CRITICAL)
    void checkReviztoLandingContent() { 
        step("Проверяем заголовок с BIM", () -> {
            SelenideElement h1 = $("h1");
            h1.shouldHave(text("Unifying BIM Intelligence across 2D and 3D"));
        });

        step("Проверяем слоган", () -> {
            SelenideElement h2 = $("h2");
            h2.shouldHave(text("Integrated Collaboration Platform"));
        });

        step("Проверяем кнопку Request Demo", () -> {
            SelenideElement demoButton = $("a.button");
            demoButton.should(exist).shouldBe(visible);
            demoButton.shouldHave(text("Request a Demo"));
            demoButton.shouldHave(attribute("href", mobileConfig.baseUrl() + "/en/demo-request/"));
        });
    }

    @Test
    @Story("Проверка навигации")
    @DisplayName("Проверка элементов навигации и интерфейса")
    @Severity(SeverityLevel.CRITICAL)
    void checkNavigationAndInterface() {
        step("Проверяем наличие навигации", () -> {
            SelenideElement mobileMenuButton = $("button.mobilenav");
            mobileMenuButton.should(exist).shouldBe(visible);
            mobileMenuButton.click();
            $("#menu_box").should(exist).shouldBe(visible);
        });

        step("Проверяем наличие логотипа", () -> {
            SelenideElement logo = $(".site-branding img.custom-logo");
            logo.should(exist).shouldBe(visible);
            String logoSrc = logo.getAttribute("src");
            assertTrue(logoSrc.contains("logo.svg"));
        });

        step("Проверяем наличие кнопки Sign in и ссылки на страницу signin", () -> {
            SelenideElement signInButton = $("#login_link");
            signInButton.should(exist).shouldBe(visible);
            signInButton.shouldHave(text("Sign in"));
            signInButton.shouldHave(attribute("href", mobileConfig.workSpaceUrl()));
        });
    }

    @Test
    @Story("Проверка интерактивных элементов")
    @DisplayName("Проверка выпадающего меню Solutions")
    @Severity(SeverityLevel.NORMAL)
    void checkSolutionsDropdownMenu() {
        step("Проверяем основной элемент Solutions", () -> {
            SelenideElement solutionsLink = $(".submenu-title");
            solutionsLink.should(exist).shouldBe(visible);
            solutionsLink.$("span").shouldHave(text("Solutions"));
        });

        step("Проверяем иконку стрелки и кликаем", () -> {
            SelenideElement arrowIcon = $(".submenu-title .icon-arrow-down");
            arrowIcon.should(exist);
            arrowIcon.click();
        });
  
        step("Проверяем, что подменю открылось", () -> {
            SelenideElement openSubMenu = $(".sub-menu.show");
            openSubMenu.should(appear);
            openSubMenu.$$(".nav-element").shouldHave(size(4));
            openSubMenu.$(".nav-element a[href*='architects'] span").shouldHave(text("Architects"));
            openSubMenu.$(".nav-element a[href*='engineers'] span").shouldHave(text("Engineers"));
            openSubMenu.$(".nav-element a[href*='contractors'] span").shouldHave(text("Contractors"));
            openSubMenu.$(".nav-element a[href*='owners'] span").shouldHave(text("Owners"));
        });
    }
}
