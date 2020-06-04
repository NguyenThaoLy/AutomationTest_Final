package booking.features.question;

import booking.ui.BookingPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class BookingQuestion  implements Question<String> {

    public static Question<String> getResult() {
        return new BookingQuestion();
    }
    @Override
    public String answeredBy(Actor actor){
        String results = Text.of(BookingPage.RESULT)
                .viewedBy(actor)
                .asString();
        String[] result = results.split(" ");
        return result[2];
    }
}
