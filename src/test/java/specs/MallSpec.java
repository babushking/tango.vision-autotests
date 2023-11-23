package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class MallSpec {
    public static RequestSpecification mallRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().method()
            .log().headers()
            .log().body()
            .baseUri("https://api.tangovision.dev/")
            .basePath("mall/")
            .contentType(JSON);
    public static ResponseSpecification mallResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .log(LogDetail.HEADERS)
            .expectStatusCode(200)
            .build();
    public static ResponseSpecification createNewMallResponseSpec = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .log(LogDetail.HEADERS)
            .expectStatusCode(201)
            .build();
}

