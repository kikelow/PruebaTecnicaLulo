package co.test.lulobank.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class StatusCode implements Question {
    @Override
    public Integer answeredBy(Actor actor) {
        return SerenityRest.lastResponse().statusCode();
    }

    public static Question<Integer> was(){
        return new StatusCode();
    }

}
