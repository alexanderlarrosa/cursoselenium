Feature: AirBnB Test

  Scenario Outline:
    Given Estoy en el sitio de airbnb
    When Ingreso los datos de busqueda de <lugar>
    Then Valido que la informacion de <lugar> sea correcta

    Examples:
      | lugar |
      |Ciudad1|
      |Ciudad2|
      |Ciudad3|

  Scenario:
    Given Estoy en el sitio de airbnb
    When Ingreso en experiencias
    And Ingreso los datos de busqueda de experiencia
    Then Valido que luegar y fechas sean correctos

  Scenario:
    Given Estoy en el sitio de airbnb
    Then Muestro lista lugares cercanos