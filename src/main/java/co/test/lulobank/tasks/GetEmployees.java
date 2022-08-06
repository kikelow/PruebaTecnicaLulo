package co.test.lulobank.tasks;

import co.test.lulobank.employees.EmployeesOperationRoutes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetEmployees implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(EmployeesOperationRoutes.GET_ALL_EMPLOYEES)
        );
    }

    public static GetEmployees obtainEmployees(){
        return instrumented(GetEmployees.class);
    }
}
