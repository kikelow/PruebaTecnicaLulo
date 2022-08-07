package co.test.lulobank.questions;

import co.test.lulobank.dto.deleteEmployee.DeletedEmployeeResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmployeeDelete implements Question {
    @Override
    public DeletedEmployeeResponseBody answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().as(DeletedEmployeeResponseBody.class);
    }

    public static Question<DeletedEmployeeResponseBody> isDeleted(){
        return new EmployeeDelete();
    }
}
