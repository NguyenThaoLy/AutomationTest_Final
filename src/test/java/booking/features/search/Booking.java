package booking.features.search;

import booking.abilities.DateBooking;
import booking.abilities.VisitorBooking;
import booking.features.question.BookingQuestion;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import booking.tasks.Search;

import java.time.LocalDate;
import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.hasItem;

@RunWith(SerenityRunner.class)
public class Booking {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true)
    public WebDriver herBrowser;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
    }

    @Test
    public void search_destination_in_booking() {

        LocalDate now = LocalDate.now();

        givenThat(anna).wasAbleTo(Open.url("https://www.booking.com/"));

        when(anna).attemptsTo(
                Search.withKeyword("Phú Quốc"),
                DateBooking.checkinTime(now.plusDays(7)).checkoutTime(now.plusDays(10)),
                VisitorBooking.adults(4).child(3).room(2)
        );

        then(anna).should(seeThat("The number of matched rooms should be ",BookingQuestion.getResult(), equalTo("270")));
    }


}