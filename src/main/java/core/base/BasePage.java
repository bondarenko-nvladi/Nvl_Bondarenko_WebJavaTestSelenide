package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    //примеры общих элементов, которые могут использоваться на разных страницах
    protected SelenideElement headerlogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");

    //Метод для поиска по сайту
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    //Пример общего метода для клика по иконке уведомлений
    public void openNotifications() {
        vkServices.click();
    }

    //клик на логотип ОК
    public void clickLogo() {
        headerlogo.shouldBe(visible).click();
    }

    //Другие общие методы, например, для проверки загрузки страницы, авторизации и т.д
}
