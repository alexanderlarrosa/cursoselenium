Feature: Booking test

  Scenario Outline:
    Given Estoy en el sitio de booking
    When Ingreso la busqueda de <lugar>
    Then Valido que la info de <lugar> sea correcta

    Examples:
      | lugar |
      |Ciudad1|
      |Ciudad2|
      |Ciudad3|

 Scenario:
   Given Estoy en el sitio de booking
   When Ingreso la busqueda de atracciones turistimas
   Then Valido que la informacion sea correcta