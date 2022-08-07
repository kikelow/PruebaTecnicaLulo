package co.test.lulobank.questions;

import co.test.lulobank.dto.getEMployee.Employee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class EmployeeSearchById implements Question {

    @Override
    public Employee answeredBy(Actor actor) {
        return SerenityRest.lastResponse().body().as(Employee.class);
    }

    public static Question<Employee > hasFieldEqualTo() {
        return new EmployeeSearchById();
    }

}
