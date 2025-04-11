Conversor de Moneda
Este proyecto es una aplicación en Java que permite convertir entre diversas monedas a partir de una cantidad en dólares estadounidenses (USD). El conversor obtiene las tasas de cambio en tiempo real desde una API de tipo de cambio, lo que asegura que las conversiones estén siempre actualizadas.

Descripción del Proyecto
La aplicación permite al usuario elegir entre varias monedas (como el peso argentino, boliviano, brasileño, chileno, colombiano y el dólar estadounidense) para convertir una cantidad de USD ingresada. El programa utiliza la API exchangerate-api.com para obtener las tasas de cambio actuales.

Arquitectura del Proyecto
El proyecto se divide en las siguientes clases:

ConversorApp.java
Este es el archivo principal que ejecuta la aplicación. Muestra el menú, solicita entradas al usuario y muestra los resultados de la conversión.

Conversor.java
Contiene la lógica para mostrar el menú de opciones y realizar la conversión de monedas utilizando las tasas obtenidas de la API externa.

ExchangeRateApiResponse.java
Clase utilizada para representar la respuesta de la API de tipo de cambio.

ExchangeRateResponse.java
Esta clase también representa una respuesta similar, con la estructura adaptada para recibir la información de las tasas de cambio y las monedas disponibles.

Configuración de API:
El proyecto hace uso de una API externa de tasas de cambio que requiere una clave de API para funcionar. Esta clave debe ser configurada en el archivo Conversor.java.

Requisitos
Java 11 o superior para compilar y ejecutar la aplicación.

Una clave de API de exchangerate-api.com para obtener las tasas de cambio. Necesitas reemplazar la clave API dentro del archivo Conversor.java.
