package booking.abilities;

import booking.ui.BookingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class VisitorBooking implements Interaction {
    private int adults;
    private int childrens;
    private int rooms;

    public VisitorBooking(int adult, int children, int room) {
        this.adults = adult;
        this.childrens = children;
        this.rooms = room;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BookingPage.VISIT_FIELD)
        );

        for(int i=0;i< adults -2;i++){
            actor.attemptsTo(
                    Click.on(BookingPage.ADULTS)
            );
        }

        for(int i=0;i< childrens;i++){
            actor.attemptsTo(
                    Click.on(BookingPage.CHILDRENS)
            );
        }

        for(int i=0;i< rooms-1;i++){
            actor.attemptsTo(
                    Click.on(BookingPage.ROOM)
            );
        }

        actor.attemptsTo(
                Click.on(BookingPage.BUTTON_SEARCH)
        );

    }

    public static ChooseVisitBuilder adults(int adults) {

        return new ChooseVisitBuilder(adults);
    }

    public static class ChooseVisitBuilder{
        private int adult;
        private int children;

        public ChooseVisitBuilder(int adult){
            this.adult = adult;
        }

        public ChooseVisitBuilder child(int children){
            this.children =children;
            return this;
        }

        public Interaction room(int room){
            return instrumented(VisitorBooking.class, this.adult, this.children, room);
        }
    }


}
