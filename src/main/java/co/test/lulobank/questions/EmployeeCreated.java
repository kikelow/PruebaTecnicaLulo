package co.test.lulobank.questions;

import co.test.lulobank.dto.creteEmployee.CreateEmployeeDto;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmployeeCreated implements Question {

    @Override
    public CreateEmployeeDto answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().as(CreateEmployeeDto.class);
    }

    public static Question<CreateEmployeeDto> hasBeenregistered(){
        return new EmployeeCreated();
    }

}
