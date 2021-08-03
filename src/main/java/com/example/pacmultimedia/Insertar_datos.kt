package com.example.pacmultimedia

import android.content.ContentValues
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import layout.BBDD_Helper
import layout.Estructura_BBDD
import layout.Estructura_BBDD.Estructura_BBDD.NOMBRE_COLUMNA1
import layout.Estructura_BBDD.Estructura_BBDD.NOMBRE_COLUMNA2
import layout.Estructura_BBDD.Estructura_BBDD.TABLE_NAME

//esta clase sirve para insertar datos en la base de datos.
class Insertar_datos : AppCompatActivity() {

    //Campos de clase: los datos se extraerán de lo que el usuario escriba en los dos EditText
    lateinit var botonInsertar: Button
    lateinit var textoEdad:EditText
    lateinit var textoNombre:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insertar_datos)

        //Hago uso de la clase que usa el helper para manejar la BBDD
        var helper = BBDD_Helper(this)

        //Identifico los botones del layout de esta actividad
        botonInsertar = findViewById(R.id.boton_ingreso)
        textoEdad = findViewById(R.id.texto_edad_ingreso)
        textoNombre = findViewById(R.id.texto_nombre_ingreso)


        //Esta acción se ejecuta al pulsar sobre el boton Insertar de la interfaz gráfica de esta actividad
        botonInsertar.setOnClickListener(object:View.OnClickListener{

            //Este método debe ser implementado obligatoriamente por OnClickListener
            override fun onClick(v: View?) {

                //Preapra al programa para insertar datos en la BBDD
                val db = helper.writableDatabase

                // Introduzco los datos de los EditText en las columnas de mi BBDD
                val values = ContentValues().apply {
                    put(NOMBRE_COLUMNA1, textoEdad.getText().toString())
                    put(NOMBRE_COLUMNA2, textoNombre.getText().toString())
                }
                // Aquí obtengo la clave primaria del siguiente elemento introducido
                val newRowId = db?.insert(TABLE_NAME, null, values)


                //Para obtener el texto con la clave del registro que se acaba de añadir
                var mensaje_Toast:String = getText(R.string.registro_guardado) as String

                //Para estar seguro de que he insertado los datos, que me lo muestre por pantalla
                var mensaje = Toast.makeText(applicationContext,mensaje_Toast+" "+newRowId, Toast.LENGTH_LONG)
                mensaje.setGravity(Gravity.CENTER,0,0)
                mensaje.show()
            }

        })
    }
    fun volverPrincipal(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        onBackPressed()
    }
}