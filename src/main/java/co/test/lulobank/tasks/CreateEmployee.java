package co.test.lulobank.tasks;

import co.test.lulobank.employees.EmployeesOperationRoutes;
import co.test.lulobank.request.CreateEmployeeRequest;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.questions.RestQueryFunction;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateEmployee implements Task {

    private String name;
    private String salary;
    private String age;

    public static CreateEmployee createEmployeeWith(String name, String salary, String age) {
        return instrumented(CreateEmployee.class, name, salary, age);
    }


    @Override
    public <T extends Actor> void performAs(T t) {
        Post.to(EmployeesOperationRoutes.CREATE_EMPLOYEE)
                .with(request -> request.contentType(ContentType.JSON)
                        .body(String.format(CreateEmployeeRequest.CREATE_EMPLOYEE_REQUEST, name, salary, age)));
    }
}
