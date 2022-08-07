package co.test.lulobank.questions;

import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmployeesSearch implements Question {

    @Override
    public ResponseBody answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body();
    }

    public static Question<ResponseBody> hasAllItems() {
        return new EmployeesSearch();
    }
}
