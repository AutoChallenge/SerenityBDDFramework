package starter.acceptancetests;


import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.navigation.NavigateTo;
import starter.tasks.FillWebForm;
import starter.ui.WebFormPage;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenFillingWebForm {

    @CastMember(name = "User")
    Actor actor;

    @Test
    void shouldFillAndSubmitWebFormSuccessfully() {
        actor.attemptsTo(
                NavigateTo.theWebFormHomePage(),
                WaitUntil.the(WebFormPage.TEXT_INPUT, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(60).seconds(),
                FillWebForm.completely()

        );
    }
}
