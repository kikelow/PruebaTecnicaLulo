package co.test.lulobank.tasks;

import co.test.lulobank.employees.EmployeesOperationRoutes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetEmployeeById implements Task {

    private int employeeId;

    public GetEmployeeById(int employeeId){
        this.employeeId = employeeId;
    }

    public static GetEmployeeById obtainEmployeeById(int employeeId){
        return instrumented(GetEmployeeById.class,employeeId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String pathEmployeeById = String.format(EmployeesOperationRoutes.GET_EMPLOYEES_BY_ID,employeeId);
        actor.attemptsTo(
                Get.resource(pathEmployeeById)
        );
    }
}
