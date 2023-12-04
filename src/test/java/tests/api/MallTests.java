package tests.api;

import io.github.cdimascio.dotenv.Dotenv;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import models.CreateNewMallBodyModel;
import specs.MallSpec;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.core.StringContains.containsString;

@Tag("api")
@Epic("Моллы")
@Story("Cоздание и редактирование молла в админке")
@Feature("Mall")
public class MallTests extends MallSpec{
    Dotenv dotenv = Dotenv.load();
    String MALL_NAME = "apiAutoTest";
    String token = dotenv.get("X-ACCESS-TOKEN");
    @Test
    @DisplayName("Получение списка моллов")
    @Owner("A.Babushkin")
    void getMallTest() {
        given(mallRequestSpec)
                .when()
                .header("X-ACCESS-TOKEN", token)
                .get()
                .then()
                .spec(mallResponseSpec)
                .body(containsString("Автотестовый"));
    }
    @Test
    @DisplayName("Получение молла по id или slug")
    @Owner("A.Babushkin")
    void getMallByIdOrSlugTest() {
        given(mallRequestSpec)
                .when()
                .get("654e4883692dcbead88b41b2")
                .then()
                .spec(mallResponseSpec)
                .body(containsString("Автотестовый"));
    }
    @Test
    @DisplayName("Получение списка магазинов по моллу")
    @Owner("A.Babushkin")
    void getShopsByMallTest() {
        given(mallRequestSpec)
                .when()
                .get("653eb60ed879ec023a0cfc4a/dataset/shops")
                .then()
                .spec(mallResponseSpec);
    }
    @Test
    @DisplayName("Получение списка категорий по моллу")
    @Owner("A.Babushkin")
    void getCategoriesByMallTest() {
        given(mallRequestSpec)
                .when()
                .get("653eb60ed879ec023a0cfc4a/dataset/categories")
                .then()
                .spec(mallResponseSpec);
    }
    @Test
    @DisplayName("Создание молла")
    @Owner("A.Babushkin")
    void createNewMallShortTest() {
        CreateNewMallBodyModel authdata = new CreateNewMallBodyModel();
        authdata.setName(MALL_NAME);
        authdata.setCountry("5fac2682be66361d643f0fba");
        authdata.setStatus("active");
        given(mallRequestSpec)
                .body(authdata)
                .header("X-ACCESS-TOKEN", token)
                .when()
                .post()
                .then()
                .spec(createNewMallResponseSpec);
    }
    @Test
    @DisplayName("Удаление молла")
    @Owner("A.Babushkin")
    void  deleteMallTest() {
        given(mallRequestSpec)
                .header("X-ACCESS-TOKEN", token)
                .when()
                .delete("654dbede692dcbead88b4119")
                .then()
                .spec(mallResponseSpec);
    }
    @Test
    @DisplayName("Удаление тестовых моллов по имени")
    @Owner("A.Babushkin")
    public void testDeleteMallsByName() {
        // Получаем id магазинов с названием MALL_NAME
        List<String> mallIds = getMallIdsByName(MALL_NAME);
        // Удаляем магазины по их id
        for (String mallId : mallIds) {
            given(mallRequestSpec)
                    .when()
                    .header("X-ACCESS-TOKEN", token)
                    .delete(mallId)
                    .then()
                    .spec(mallResponseSpec);
        }
    }
    private List<String> getMallIdsByName(String mallName) {
        // Выполняем GET-запрос для получения списка торговых центров
        String responseBody = given(mallRequestSpec)
                .when()
                .header( "X-ACCESS-TOKEN", token)
                .get()
                .then()
                .spec(mallResponseSpec)
                .extract().body().asString();
        // Парсим JSON и извлекаем id торговых центров с названием MALL_NAME
        return from(responseBody).getList("findAll { it.name == '" + mallName + "' }._id");
    }
}


