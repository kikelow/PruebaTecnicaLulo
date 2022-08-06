package stepsdefinitions;

import co.test.lulobank.dto.Employee;
import co.test.lulobank.questions.EmployeeSearchById;
import co.test.lulobank.questions.StatusCode;
import co.test.lulobank.tasks.GetEmployeeById;
import co.test.lulobank.tasks.GetEmployees;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;


import javax.servlet.http.HttpServletResponse;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class OperationServicesEmployeesStepDefinitions {

    Actor actor;
    private EnvironmentVariables environmentVariables;


    @Given("{string} requiere realizar operaciones sobre el servicio de empleados")
    public void harinsonRequiereObtenerTodosLosEmpleados(String actorName) {
        actor = Actor.named("Harinson");
        actor.whoCan(
                CallAnApi.at(environmentVariables.optionalProperty("restapi.baseurl").get())
        );
    }

    @When("consulte todos los empleados")
    public void consulteTodosLosEmpleados() {
        actor.attemptsTo(GetEmployees.obtainEmployees());
    }

    @Then("el codigo de respuesta debera ser 200")
    public void elCodigoDeRespuestaDebera() {
        actor.should(
                seeThat("El codigo de respuesta de la peticion es ",
                        StatusCode.was(), equalTo(HttpServletResponse.SC_OK))
        );
    }


    @And("el cuerpo presentara la siguiente estructura {string}")
    public void elCuerpoPresentaraLaSiguienteEstructura() {
    }


    @When("consulte el empleado especifico por su id numero {int}")
    public void consulteElEmpleadoEspecifico(int employeeId) {
        actor.attemptsTo(
                GetEmployeeById.obtainEmployeeById(employeeId)
        );
    }

    @And("^su informacion deberia corresponder con la siguiente, nombre : (.*), salario : (.*), edad : (.*), perfil de imagen : (.*)$")
    public void suInformacionDeberiaCorresponderConLaSiguienteNombreNombreSalarioSalarioEdadEddadPerfilDeImagenPerfil_imagen(String name, int salary, int age, String imageProfile) {
        assertThat("El nombre del empleado es igual a ", EmployeeSearchById.hasFieldEqualTo().answeredBy(actor).getData().getEmployeeName(), Matchers.equalTo(name));
        assertThat("El salario del empleado es igual a ", EmployeeSearchById.hasFieldEqualTo().answeredBy(actor).getData().getEmployeeSalary(), Matchers.equalTo(salary));
        assertThat("La edad del empleado es igual a ", EmployeeSearchById.hasFieldEqualTo().answeredBy(actor).getData().getEmployeeAge(), Matchers.equalTo(age));
        assertThat("La imagen de perfil del empleado es igual a ", EmployeeSearchById.hasFieldEqualTo().answeredBy(actor).getData().getProfileImage(), Matchers.equalTo(imageProfile));
    }

//    @And("su informacion deberia corresponder con la siguiente, nombre : {string}, salario : {string}, edad : {string}, perfil de imagen : {string}")
//    public void suInformacionDeberiaCorresponderConLaSiguienteNombreNombreSalarioSalarioEdadEdadPerfilDeImagenPerfil_imagen() {
//    }

//    @Given("Harinson requiere crear un empleado")
//    public void harinsonRequiereCrearUnEmpleado() {
//    }
//
//    @When("cree el empleado con los datos, nombre : <nombre>, salario : <salario>, y edad : <edad>")
//    public void creeElEmpleadoConLosDatosNombreNombreSalarioSalarioYEdadEdad() {
//    }
//
//    @And("se mostrara la confirmacion del registro del empleado")
//    public void seMostraraLaConfirmacionDelRegistroDelEmpleado() {
//    }
//
//    @Given("que Harinson requiere eliminar un empleado")
//    public void queHarinsonRequiereEliminarUnEmpleado() {
//    }
//
//    @When("elimine el empleado con id <id>")
//    public void elimineElEmpleadoConIdId() {
//    }

}
