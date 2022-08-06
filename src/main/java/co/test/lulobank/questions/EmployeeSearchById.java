package co.test.lulobank.questions;

import co.test.lulobank.dto.Employee;
import co.test.lulobank.dto.EmployeeDto;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmployeeSearchById implements Question {

    @Override
    public EmployeeDto answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().as(EmployeeDto.class);
    }

    public static Question<EmployeeDto> hasFieldEqualTo() {
        return new EmployeeSearchById();
    }

}
