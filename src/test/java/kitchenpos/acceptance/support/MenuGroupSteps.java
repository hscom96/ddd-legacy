package kitchenpos.acceptance.support;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class MenuGroupSteps {
    public static ExtractableResponse<Response> 메뉴그룹등록_요청(String name) {
        Map<String, String> params = new HashMap<>();
        params.put("name", name);

        return RestAssured
            .given().log().all()
            .body(params)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .when().post("/api/menu-groups")
            .then().log().all().extract();
    }

    public static ExtractableResponse<Response> 메뉴그룹조회_요청() {
        return RestAssured
            .given().log().all()
            .when().get("/api/menu-groups")
            .then().log().all().extract();
    }
}
