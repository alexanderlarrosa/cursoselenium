Feature: Spotify Test

 Scenario Outline:
  Given Estoy en el sitio de Spotify
  When Ingreso en la seccion premium
  Then Veo el plan premium <opcion>

  Examples:
   | opcion |
   | Individual |
   | Duo |
   | Familiar |

  Scenario Outline:
   Given Estoy en el sitio de Spotify
   When Ingreso en Login Page
   Then Ingreso el email <opcion> y valido error
   Examples:
    | opcion |
    |InvalidEmail1|
    |InvalidEmail2|
    |InvalidEmail3|

   Scenario Outline:
    Given Estoy en el sitio de Spotify
    When Ingreso en user agreement page
    Then Valido el link <opcion>

    Examples:
     | opcion |
     |Link1   |
     |Link2   |
     |Link3   |