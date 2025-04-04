package starter.acceptancetests;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class RuneScapeApiTest {

    @Steps
    starter.api.RuneScapeApiTest runeScapeSteps;

    @Test
    public void shouldReturnGroupDataSuccessfully() {
        runeScapeSteps.sendGetRequest();
        runeScapeSteps.validateResponse();

    }
}
