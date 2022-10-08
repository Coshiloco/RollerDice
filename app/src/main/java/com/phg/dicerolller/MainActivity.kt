package com.phg.dicerolller

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {


    /*
    * las definimos privadas para que solo accesibles dentro de la clase
    * el lateinit sirve para que no se deje como null sino para que
    * la inicializemos mas delante en el codigo
    * var es para definir variables y val es para definir
    * las constantes
    * y como ya hemos visto en kotlin los : y el tipo de dato
    * */

    private lateinit var rollButton: Button
    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Aqui cojemos los botones por id
        * y los asiganamos a las variables
        * de clase */
        rollButton = findViewById(R.id.roll_button)
        resultText = findViewById(R.id.result_text_number)

        /* Aqui cambiamos la propiedad del texto
        * del Button y del TextView*/
        rollButton.text = "Let ` s Roll"
        resultText.text = "Roll the dice"

        /*Esta funcion es una lambda eso significa
        * que esta abreviada
        * co,o argumento tiene la vista y los parenteis
        * la clave efectivamente es que un boton con el evento
        * puede responder a una accion o a multiples acciones
        * importante del TOast el show() si no no se muestra
        * en pantallas y llamamos a la funcion del genrear
        * su numero random que es importante*/
        rollButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Dice Rolled", Toast.LENGTH_SHORT).show()
            showRandomNumber()
        }
    }

    private fun showRandomNumber() {
        /* Esta funcion tiene otra lamda funciona como el map de javascript
        * es decir como un callback donde recibimos como parametro
        * de randomNumber que por defecto es el its el resultado del bloque
        * que es nuestro primer parametro que lo que nos genera es el numero
        * random */
        (Random().nextInt(6) + 1).let { randomNumber ->
            resultText.text = randomNumber.toString()
        }
    }
}