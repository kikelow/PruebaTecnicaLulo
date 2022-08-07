package stepsdefinitions;

import co.test.lulobank.dto.creteEmployee.CreateEmployeeData;
import co.test.lulobank.dto.creteEmployee.CreateEmployeeDto;
import co.test.lulobank.dto.getEMployee.Employee;
import co.test.lulobank.dto.getEMployee.EmployeeData;
import co.test.lulobank.questions.*;
import co.test.lulobank.tasks.CreateEmployee;
import co.test.lulobank.tasks.DeleteEmployee;
import co.test.lulobank.tasks.GetEmployeeById;
import co.test.lulobank.tasks.GetEmployees;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.vavr.API;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;


import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class OperationServicesEmployeesStepDefinitions {

    private String name;
    private String salary;
    private String age;
    private String employeeId;

    Actor actor;

    private EnvironmentVariables environmentVariables;

    @Given("{string} requiere realizar operaciones sobre el servicio de empleados")
    public void harinsonRequiereObtenerTodosLosEmpleados(String actorName) {
        actor = Actor.named(actorName);
        actor.whoCan(
                CallAnApi.at(environmentVariables.optionalProperty("restapi.baseurl").get())
        );
    }

    @When("realizo la operacionde consulte todos los empleados")
    public void consulteTodosLosEmpleados() {
        actor.attemptsTo(GetEmployees.obtainEmployees());
    }

    @Then("el codigo de respuesta debera ser 200")
    public void elCodigoDeRespuestaDebera() {
        actor.should(
                seeThat("El codigo de respuesta de la peticion ",
                        StatusCode.was(), equalTo(HttpServletResponse.SC_OK))
        );
    }


    @And("se mostraran todos los empleados")
    public void elCuerpoPresentaraLaSiguienteEstructura() {
        List<LinkedHashMap<String, Object>> employeeList = EmployeesSearch.hasAllItems().answeredBy(actor).path("data");
        for (LinkedHashMap<String,Object> employee: employeeList) {
            employee.forEach((k,v) -> assertThat(v,Matchers.notNullValue()));
        }
    }


    @When("realizo la operacion de consulta del empleado por su id numero {int}")
    public void consulteElEmpleadoEspecifico(int employeeId) {
        this.employeeId = String.valueOf(employeeId);
        actor.attemptsTo(
                GetEmployeeById.obtainEmployeeById(employeeId)
        );
    }

    @And("^su informacion deberia corresponder con la siguiente, nombre : (.*), salario : (.*), edad : (.*), perfil de imagen : (.*)$")
    public void suInformacionDeberiaCorresponderConLaSiguienteNombreNombreSalarioSalarioEdadEddadPerfilDeImagenPerfil_imagen(String name, int salary, int age, String imageProfile) {
        EmployeeData employee = EmployeeData.builder().id(Integer.parseInt(employeeId)).employeeName(name).employeeSalary(salary).employeeAge(age).profileImage(imageProfile).build();
        actor.should(
                seeThat("que los obtejos son iguales",x -> new EmployeeSearchById().answeredBy(actor).getData() , Matchers.equalTo(employee))
        );
 }


    @When("^realizo la operacion de creacion de empleado con los datos, nombre : (.*), salario : (.*), y edad : (.*)$")
    public void creeElEmpleadoConLosDatosNombreNombreSalarioSalarioYEdadEdad(String name, String salary, String age) {
        this.name = name;
        this.salary = salary;
        this.age = age;

        actor.attemptsTo(
                CreateEmployee.createEmployeeWith(name, salary, age)
        );
    }

    @And("se mostrara la confirmacion del registro del empleado con los datos registrados, el status {string} y mensaje {string}")
    public void seMostraraLaConfirmacionDelRegistroDelEmpleado(String status, String message) {
        assertThat("El estado de la operacion es ", EmployeeCreated.hasBeenregistered().answeredBy(actor).getStatus(), Matchers.equalTo(status));
        assertThat("El nombre del empleado es igual a ", EmployeeCreated.hasBeenregistered().answeredBy(actor).getData().getName(), Matchers.equalTo(name));
        assertThat("El salario del empleado es igual a ", EmployeeCreated.hasBeenregistered().answeredBy(actor).getData().getSalary(), Matchers.equalTo(salary));
        assertThat("La edad del empleado es igual a ", EmployeeCreated.hasBeenregistered().answeredBy(actor).getData().getAge(), Matchers.equalTo(age));
        assertThat("La edad del empleado es igual a ", EmployeeCreated.hasBeenregistered().answeredBy(actor).getData().getId(), Matchers.notNullValue());
        assertThat("El mensaje de la operacion es ", EmployeeCreated.hasBeenregistered().answeredBy(actor).getMessage(), Matchers.equalTo(message));
    }


    @When("realizo la operacion para eliminar un empleado con id {int}")
    public void elimineElEmpleadoConIdId(int employeeId) {
        this.employeeId = String.valueOf(employeeId);
        actor.attemptsTo(
                DeleteEmployee.withId(employeeId)
        );
    }

    @And("se mostrara la confirmacion de eliminacion del empleado, con el estado {string} y el mensaje {string}")
    public void seMostraraLaConfirmacionDeEliminacionDelEmpleadoConElEstadoSuccessYElMensajeSuccessfullyRecordHasBeenDeleted(String status, String message) {

        assertThat("Estado de eliminacion del empleado ", EmployeeDelete.isDeleted().answeredBy(actor).getStatus(), Matchers.equalTo(status));
        assertThat("Estado de eliminacion del empleado ", EmployeeDelete.isDeleted().answeredBy(actor).getData(), Matchers.equalTo(employeeId));
        assertThat("Mensaje de eliminacion del empleado ", EmployeeDelete.isDeleted().answeredBy(actor).getMessage(), Matchers.equalTo(message));

    }
}
