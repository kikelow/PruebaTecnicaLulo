#language: en
Feature: Operaciones sobre el servicio de empleados

Background:
  Given 'Harinson' requiere realizar operaciones sobre el servicio de empleados

#  Scenario: Consultar todos los empleados

#    When consulte todos los empleados
#    Then el codigo de respuesta debera ser 200
#    And el cuerpo presentara la siguiente estructura '{}'

  Scenario Outline: Consutlar empleado por Id
    When consulte el empleado especifico por su id numero <id>
    Then el codigo de respuesta debera ser 200
    And su informacion deberia corresponder con la siguiente, nombre : <nombre>, salario : <salario>, edad : <edad>, perfil de imagen : <perfil_imagen>

    Examples:
      | id | nombre      | salario | edad | perfil_imagen |
      | 1  | Tiger Nixon | 320800  | 61    |               |

#
#  Scenario Outline: Crear empleado
#    Given Harinson requiere crear un empleado
#    When cree el empleado con los datos, nombre : <nombre>, salario : <salario>, y edad : <edad>
#    Then el codigo de respuesta debera ser '200'
#    And se mostrara la confirmacion del registro del empleado
#
#    Examples:
#      | nombre         | salario | edad |
#      | Andres Vasquez | 3000000 | 28   |
#
#
#  Scenario Outline: Eliminar empleado
#    Given que Harinson requiere eliminar un empleado
#    When elimine el empleado con id <id>
#    Then el codigo de respuesta debera ser '200'
#
#
#    Examples:
#
#      | id |
#      |    |

