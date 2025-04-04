package starter.api;

import net.serenitybdd.annotations.Step;
import static net.serenitybdd.rest.SerenityRest.*;

import static org.hamcrest.Matchers.equalTo;

public class RuneScapeApiTest {

    private final String BASE_URL = "https://secure.runescape.com/m=group_hiscores/v1/groups";

    @Step("Send GET request to RuneScape API")
    public void sendGetRequest() {
        given()
                .queryParam("groupSize", 2)
                .queryParam("size", 1)
                .queryParam("bossId", 1)
                .queryParam("page", 0)
                .when()
                .get(BASE_URL)
                .then()
                .statusCode(200)
                .log().all(); // Optional: for console output
    }

    @Step("Validate the number of group members in the response")
    public void validateResponse() {
        then().body("content[0].members.size()", equalTo(2));
    }
}
