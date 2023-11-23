package tests.kioskInterfase;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import java.util.List;
import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.get;

@Tag("kiosk")
public class WayPathTest {

    // Инициализация объекта Dotenv для чтения переменных окружения из файла .env
    Dotenv dotenv = Dotenv.load();
    // Получение значения переменной окружения TERMINAL-TOKEN
    String terminalToken = dotenv.get("TERMINAL-TOKEN");
    String baseURL = "https://api.tangovision.dev/";

    @Test
    public void wayPathTest() {
        // Получить список всех магазинов в молле по ID молла
        Response response = get(baseURL + "shop?mall=645e7f994439659ffb384413");
        List<String> allID = response.path("_id");
        // Вывести в консоль количество магазинов и список ID
        int count = allID.size();
        System.out.println("Количество магазинов: " + count);
        System.out.println(allID);
            // Для каждого значения из списка allID выполнить следующие действия:
        for (String shopID : allID) {
            String targetURL = "https://32363462-review-feature-85-7hr53h.tangovision.dev/app/map?shop=" + shopID + "&ignoreClick=true&token=" + terminalToken;
            // Открыть страницу с текущим значением shopId
            open(targetURL);
        }
    }
}

