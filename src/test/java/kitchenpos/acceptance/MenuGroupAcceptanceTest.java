package kitchenpos.acceptance;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import kitchenpos.support.AcceptanceTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static kitchenpos.acceptance.support.MenuGroupSteps.메뉴그룹등록_요청;
import static kitchenpos.acceptance.support.MenuGroupSteps.메뉴그룹조회_요청;
import static org.assertj.core.api.Assertions.assertThat;

public class MenuGroupAcceptanceTest extends AcceptanceTest {
    @Test
    void 메뉴그룹등록() {
        final ExtractableResponse<Response> response = 메뉴그룹등록_요청("한마리치킨");

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        assertThat(response.jsonPath().getString("id")).isNotNull();
        assertThat(response.jsonPath().getString("name")).isNotNull();
    }

    @Test
    void 메뉴그룹조회() {
        메뉴그룹등록_요청("한마리치킨");
        메뉴그룹등록_요청("두마리치킨");

        final ExtractableResponse<Response> response = 메뉴그룹조회_요청();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getList("name")).contains("한마리치킨", "두마리치킨");
        assertThat(response.jsonPath().getList("id")).hasSize(2);
    }
}
