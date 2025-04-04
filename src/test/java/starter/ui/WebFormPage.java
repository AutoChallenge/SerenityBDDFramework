package starter.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class WebFormPage extends PageObject {

    public static final Target TEXT_INPUT = Target.the("Text input")
            .locatedBy("#my-text-id");

    public static final Target PASSWORD_INPUT = Target.the("Password input")
            .locatedBy("//input[@name='my-password']");

    public static final Target TEXTAREA = Target.the("Textarea")
            .locatedBy("//textarea[@name='my-textarea']");

    public static final Target SELECT_MENU = Target.the("Dropdown select")
            .locatedBy("//select[@name='my-select']");

    public static final Target DATALIST_INPUT = Target.the("Datalist input")
            .locatedBy("//input[@name='my-datalist']");

    public static final Target FILE_INPUT = Target.the("File input")
            .locatedBy("//input[@name='my-file']");

    public static final Target CHECKBOX_1 = Target.the("Checked checkbox")
            .locatedBy("#my-check-1");

    public static final Target CHECKBOX_2 = Target.the("Default checkbox")
            .locatedBy("#my-check-2");

    public static final Target RADIO_1 = Target.the("Checked radio")
            .locatedBy("#my-radio-1");

    public static final Target RADIO_2 = Target.the("Default radio")
            .locatedBy("#my-radio-2");

    public static final Target COLOR_PICKER = Target.the("Color picker")
            .locatedBy("//input[@name='my-colors']");

    public static final Target DATE_PICKER = Target.the("Date picker")
            .locatedBy("//input[@name='my-date']");

    public static final Target RANGE_SLIDER = Target.the("Range slider")
            .locatedBy("//input[@name='my-range']");

    public static final Target SUBMIT_BUTTON = Target.the("Submit button")
            .locatedBy("//button[@type='submit']");

    public static final Target FORM_SUBMISSION_HEADER = Target.the("Form submitted header")
            .locatedBy("//h1[text()='Form submitted']");
}
