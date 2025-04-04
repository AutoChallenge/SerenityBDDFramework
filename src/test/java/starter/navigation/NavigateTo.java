package starter.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;

public class NavigateTo {
    public static Performable theWebFormHomePage() {
        return Task.where("{0} opens the webForm home page",
                Open.browserOn().the(WebFormGoHomePage.class));
    }
}
