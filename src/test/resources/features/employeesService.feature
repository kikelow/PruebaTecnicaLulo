#language: en
Feature: Operaciones sobre el servicio de empleados

  Background:
    Given 'Harinson' requiere realizar operaciones sobre el servicio de empleados

  Scenario: Consultar todos los empleados

    When realizo la operacionde consulte todos los empleados
    Then el codigo de respuesta debera ser 200
    And se mostraran todos los empleados

  Scenario Outline: Consutlar empleado por Id
    When realizo la operacion de consulta del empleado por su id numero <id>
    Then el codigo de respuesta debera ser 200
    And su informacion deberia corresponder con la siguiente, nombre : <nombre>, salario : <salario>, edad : <edad>, perfil de imagen : <perfil_imagen>

    Examples:
      | id | nombre      | salario | edad | perfil_imagen |
      | 1  | Tiger Nixon | 320800  | 61   |               |


  Scenario Outline: Crear empleado
    When realizo la operacion de creacion de empleado con los datos, nombre : <nombre>, salario : <salario>, y edad : <edad>
    Then el codigo de respuesta debera ser 200
    And se mostrara la confirmacion del registro del empleado con los datos registrados, el status 'success' y mensaje 'Successfully! Record has been added.'

    Examples:
      | nombre         | salario | edad |
      | Andres Vasquez | 3000000 | 28   |


  Scenario Outline: Eliminar empleado
    When realizo la operacion para eliminar un empleado con id <id>
    Then el codigo de respuesta debera ser 200
    And se mostrara la confirmacion de eliminacion del empleado, con el estado 'success' y el mensaje 'Successfully! Record has been deleted'

    Examples:

      | id |
      | 68 |

