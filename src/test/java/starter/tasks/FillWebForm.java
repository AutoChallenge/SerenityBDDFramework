package starter.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import common.JsonReader;
import common.SecurityUtils;
import starter.ui.WebFormPage;

import java.io.File;
import java.nio.file.Path;
import java.util.Map;

public class FillWebForm {

    public static Task completely() {
        return Tasks.instrumented(FillWebFormTask.class);
    }

    public static class FillWebFormTask implements Task {
        @Override
        public <T extends Actor> void performAs(T actor) {

            Map<String, String> testData = JsonReader.readJson("src/test/resources/testdata/formdata.json");

            String username = testData.get("username");
            String passwordEncrypted = testData.get("password");
            String password = SecurityUtils.decrypt(passwordEncrypted);
            String comment = testData.get("comment");
            String dropdown = testData.get("dropdown");
            String datalist = testData.get("datalist");
            String color = testData.get("color");
            String date = testData.get("date");
            String range = testData.get("range");

            Path filePath = new File("src/test/resources/sample.txt").toPath();

            actor.attemptsTo(
                    Enter.theValue(username).into(WebFormPage.TEXT_INPUT),
                    Ensure.that(WebFormPage.TEXT_INPUT).value().isEqualTo(username),

                    Enter.theValue(password).into(WebFormPage.PASSWORD_INPUT),
                    Ensure.that(WebFormPage.PASSWORD_INPUT).value().isEqualTo(password),

                    Enter.theValue(comment).into(WebFormPage.TEXTAREA),
                    Ensure.that(WebFormPage.TEXTAREA).value().contains("Some comments"),

                    SelectFromOptions.byVisibleText(dropdown).from(WebFormPage.SELECT_MENU),
                    Ensure.that(WebFormPage.SELECT_MENU).selectedValue().contains("2"),

                    Enter.theValue(datalist).into(WebFormPage.DATALIST_INPUT),
                    Ensure.that(WebFormPage.DATALIST_INPUT).value().isEqualTo(datalist),

                    Upload.theFile(filePath).to(WebFormPage.FILE_INPUT),
                    Ensure.that(WebFormPage.FILE_INPUT).attribute("value").isNotEmpty(),

                    Click.on(WebFormPage.CHECKBOX_2),
                    Ensure.that(WebFormPage.CHECKBOX_2).attribute("checked").isEqualTo("true"),

                    Click.on(WebFormPage.RADIO_2),
                    Ensure.that(WebFormPage.RADIO_2).attribute("checked").isEqualTo("true"),

                    Enter.theValue(color).into(WebFormPage.COLOR_PICKER),
                    Ensure.that(WebFormPage.COLOR_PICKER).value().isEqualTo(color.toLowerCase()),

                    Enter.theValue(date).into(WebFormPage.DATE_PICKER),
                    Ensure.that(WebFormPage.DATE_PICKER).value().isEqualTo(date),

                    Enter.theValue(range).into(WebFormPage.RANGE_SLIDER),
                    Ensure.that(WebFormPage.RANGE_SLIDER).value().isEqualTo(range),

                    Click.on(WebFormPage.SUBMIT_BUTTON),
                    Ensure.that(WebFormPage.FORM_SUBMISSION_HEADER).isDisplayed()
            );
        }
    }
}
