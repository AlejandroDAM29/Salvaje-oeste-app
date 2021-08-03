package com.example.pacmultimedia

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.view.View
import android.widget.Button
import android.widget.EditText
import layout.BBDD_Helper
import layout.Estructura_BBDD.Estructura_BBDD.NOMBRE_COLUMNA1
import layout.Estructura_BBDD.Estructura_BBDD.NOMBRE_COLUMNA2
import layout.Estructura_BBDD.Estructura_BBDD.TABLE_NAME

/*Esta clase se usa para rescatar la edad del vaquero que solicita el usuario a través del nombre
* Su funcionamiento es muy similar a la clase Insertar*/
class Resultado : AppCompatActivity() {

    //Campos de clase
    lateinit var botonConsulta: Button
    lateinit var textoNombre:EditText
    lateinit var textoEdad:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Creo esta variable para empezar a manipular los datos de la BBDD
        var helper = BBDD_Helper(this)

        //Identifico los botones del layout de esta actividad
        botonConsulta = findViewById(R.id.boton_search)
        textoNombre =  findViewById(R.id.texto_nombre_consulta)
        textoEdad = findViewById(R.id.texto_edad_consulta)

        //Esta acción se ejecuta al pulsar sobre el boton Buscar de la interfaz gráfica de esta actividad
        botonConsulta.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val db = helper.readableDatabase

                // Devuelve un objeto con las características de un resultSet con las columnas de la tabla
                val projection = arrayOf(
                    NOMBRE_COLUMNA1, NOMBRE_COLUMNA2)

                //Aquí es donde se escribe el criterio de búsqueda. Es un array porque pueden haber varios criterios
                val selection = "${NOMBRE_COLUMNA2} = ?"
                val selectionArgs = arrayOf(textoNombre.getText().toString())

                //Ejecuto la Query a través de esta consulta
                val cursor = db.query(
                    TABLE_NAME,
                    projection,
                    selection,
                    selectionArgs,
                    null,
                    null,
                    null
                )


                val itemIds = mutableListOf<String>()
                with(cursor) {
                    //Mientras que cursor siga teniendo datos, se adelantará una posición en el cursor
                    while (moveToNext()) {
                        textoEdad.setText(cursor.getString(0))
                    }//Termina bucle while

                }//Termina cursor


            }//Termina el método onClick

        }//Termina el objeto View.OnClickListener

        )//Termina la funcion de setOnClickListener


    }//Termina función onCreate


    //Se utiliza para volver a la activity principal
    fun volverPrincipal(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        onBackPressed()
    }

}