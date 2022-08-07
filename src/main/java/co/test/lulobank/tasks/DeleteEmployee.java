package co.test.lulobank.tasks;

import co.test.lulobank.employees.EmployeesOperationRoutes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteEmployee implements Task {

    private int empployeeId;

    public DeleteEmployee(int employeeId){
        this.empployeeId = employeeId;
    }

    public static DeleteEmployee withId(int empployeeId){
        return instrumented(DeleteEmployee.class,empployeeId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String pathDeleteEmployee = String.format(EmployeesOperationRoutes.DELETE_EMPLOYEE,empployeeId);
        actor.attemptsTo(
                Delete.from(pathDeleteEmployee)
        );
    }
}
