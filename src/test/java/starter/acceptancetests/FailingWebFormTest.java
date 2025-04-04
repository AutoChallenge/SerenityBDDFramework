package starter.acceptancetests;

import net.serenitybdd.annotations.Screenshots;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.navigation.NavigateTo;
import starter.ui.WebFormPage;

@ExtendWith(SerenityJUnit5Extension.class)
class FailingWebFormTest {

    @CastMember(name = "User")
    Actor actor;

    @Screenshots(onlyOnFailures=true)
    @Test
    public void shouldFailToClickFakeButton() {

        Target FAKE_BUTTON = Target.the("Fake Button").locatedBy("#does-not-exist");

        actor.attemptsTo(
                NavigateTo.theWebFormHomePage(),

                // Wait for form to be visible
                WaitUntil.the(WebFormPage.TEXT_INPUT, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(30).seconds(),

                // Enter value into valid field
                Enter.theValue("User").into(WebFormPage.TEXT_INPUT),

                // ✅ Assert actual field contains expected value
                Ensure.that(WebFormPage.TEXT_INPUT).value().isEqualTo("User123")

        );
    }
}
