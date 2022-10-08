package com.phg.dicerolller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // obtener en una variable el boton con la clase R que es la base de todas
        val RollButton: Button = findViewById(R.id.roll_button)
        val ResultText: TextView = findViewById(R.id.result_text_Numero)
        /* lo que estamos viendo es que es creamos una variable que es del tipo de la view
        * que tenemos dado que nuestro botn se encgloba dentro de una view con la sintaxis
        * de los : Button y luego lo enganchamos encontrandolo
        * por id que es lo que le hemos puesto en el diseño
        * de la vista el metodo findViewById nos permite agarrar el id de un boton
        * la super clase R conoce ya los id por eso la seleccionamos por el atributo id
        * y seleccionamos el del boton*/

        // Una vez teneida esa variable con el . podmeos modificar todos sus atributos
        // como el del texto por ejemplo

        RollButton.text = "Let ` s Roll"

        // llamamos a la funcion que desencandenara el evento
        // que queremos que se produzca cuando clickemos en el boton

        //DarElClick(RollButton)

        /* Vamos ha hacer una funcion que muestre un numero random
        * en el componente TextView que tenemos en nuestra pantalla
        * pero con el evento del boton*/

        CambiarTextoTextView(RollButton)

        // Funcion que cuando le das click al boton te genera un numero Random en el Texview
        //NumeroRandom(RollButton, ResultText)

        /*Bien ahora me surge otra duda porque cuando le doy de nuevo al boton
        * la funcion no se me vuelve a ejecutar la primera hipotesis
        * es que no hemos utilizado la libreria correcta
        * para generar el numero random
        * la otra es que al no estar el metodo OnCreate que es el que guarda la isntancia
        * el evento setOnClickListener no puede volver a ejecutarlo pero deberia ejecutarse
        * Por lo tanto tenemos que comporbar que leches estamos haciendo mal
        * La otra hipotesis es que solo ejecuta lo que esta fuera
        * del evento una sola vez por tanto podriamos comprobarlo tambien
        * poniendolo el codigo dentro del evento
        * por tanto comprobado que con la libreria no se ejecuta
        * probemos a poner el codigo dentro del evento*/
    }

    private fun NumeroRandom(Rollbutton: Button, ResultText: TextView) {
        // Le decimos al botn que cuando se pulse con el setOnclickListener me ponga el
        // numero random en el TexView
        /* Bien hemos comprobado que cuando apretamos al boton
        * lo que esta fuera del evento solo se ejecuta una vez
        * al cargar la funcion pero cuando apretamos el boton
        * no se vuelve a ejecutar lo que esta fuera de la funcion
        * sino que solo se ejecuta el codigo que esta dentro
        * del evento*/
        Rollbutton.setOnClickListener {
            /* le decimos que la propiedad text es igual
            * al string parseado del numero random
            * que es pasado*/
            val numero_random: Int = Random().nextInt(6) + 1
            val pasado: String = numero_random.toString()
            ResultText.text = pasado
        }
    }

    private fun CambiarTextoTextView(RollButton: Button) {
        // Coger en una variable el componente TextView por el metodo findViewById
        val resultText: TextView = findViewById(R.id.result_text_Numero)
        /* Cogemos la propiedad del text y la igualamos
        * a un String pero podemos meterlo dentro del
        * setOnClickListener y dentro de este cambiamos el
        * boton del TextView*/
        RollButton.setOnClickListener {
            resultText.text = "Dice Rolled"
        }

        /* Acabamos de notar un comportamiento anomalo
        * cuando tenemos dos funciones independientes que ejecutan un evento
        * de boton como el setOnClickListener  bien partimos de la hipotesis
        * que tenemso dos funciones la primera va a lanzar un mensaje
        * de tipo Toast por pantalla y la segunda tiene el mismo tipo
        * de evento pero cambiando el TextView la primera esta mas arriba del codigo
        * y la segunda mas abajo la hipotesis rige en que la primera tendria
        * que lanzar el mensaje de Toast por pantalla y luego ejecutar la segunda
        * y cambiar el texto pero no es asi solo ejecuta la ultima*/

    }

    private fun DarElClick(Rollbutton: Button) {
        /* Para el evento podemos utilizar la clase Toast esta suelta unos mensajitos
        * en forma temporal en la patanlla que son temporales
        * el metodo que vamos a utilizar es Toast.makeText pero envuelto
        * en un evento que tiene el boton que se llama setOnClickListener {}
        * y dentro de este cuando hagamos el click ejecutara esa funcion
        * de manera que imprimira la funcion del Toast este metodo del Toast tiene tres parametros
        * el primero es el contexto que se refiere a nuestra Activity que esta envuelta la clase
        * el segundo es el String con el texto y el tercero es la duracion del texto en si*/
        Rollbutton.setOnClickListener {
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        }

        // EL punto show() que es una funcion es para que se ejecute en la pantalla

        /* Como vemos la funcion transmite la informacion correctamente importantisimo
        * IMPORTANTITISMO sin el .SHOW() AL FINAL NO MOSTRARA EL TOAST POR LA PANTALLA
        * DEL MOVIL*/
    }
}