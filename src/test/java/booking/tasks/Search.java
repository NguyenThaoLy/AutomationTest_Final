package booking.tasks;

import booking.abilities.DateBooking;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import booking.ui.BookingPage;

public class Search implements Task {

    private final String destination;

    protected Search(String destination) {
        this.destination = destination;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(destination)
                     .into(BookingPage.DESTINATION_FIELD),
                Click.on(BookingPage.OPPTION_DES)
        );
    }

    public static Performable withKeyword(String destination) {
        return instrumented(Search.class, destination);
    }

}
