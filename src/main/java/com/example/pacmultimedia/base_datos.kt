package com.example.pacmultimedia

import android.content.ContentValues
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import layout.BBDD_Helper
import layout.Estructura_BBDD

class base_datos : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_datos)

        //Este bloque de código hace que se muestre un Toast que pide la elección de uno de los botones de la activity
        var mensaje = Toast.makeText(applicationContext,getText(R.string.mensaje_bases), Toast.LENGTH_LONG)
        mensaje.setGravity(Gravity.CENTER,0,0)
        mensaje.show()

    }


    //Volver a la actividad principal
    fun volverPrincipal(view: View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        onBackPressed()
    }

    //Método para crear la tabla de la base de datos
    fun creaTabla(view:View){
        var helper = BBDD_Helper(this)

        //Con esta línea ya disponemos al programa para hacer un ingreso de datos
        val db = helper.writableDatabase

        //Como solo queremos crear la tabla, se pasan datos nulos
        var dato1:String?=null
        var dato2:String?=null

        //Se aplican los datos a la tabla
        val values = ContentValues().apply {
            put(Estructura_BBDD.Estructura_BBDD.NOMBRE_COLUMNA1, dato1)
            put(Estructura_BBDD.Estructura_BBDD.NOMBRE_COLUMNA2, dato2)
        }

        //Para estar seguro de que he insertado los datos, se muestran por pantalla mediante un Toast
        var mensaje = Toast.makeText(applicationContext,getText(R.string.Tabla_creada), Toast.LENGTH_LONG)
        mensaje.setGravity(Gravity.CENTER,0,0)
        mensaje.show()
    }//Fin del método CrearTabla


    //Te lleva hacia la actividad donde se ingresan los datos en la BBDD
    fun haciaIngresos(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        var hacia_ingresos = Intent(this,Insertar_datos::class.java)
        this.startActivity(hacia_ingresos)
    }


    //Te lleva hacia la actividad donde se consultan los datos la tabla
    fun haciaConsultas(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        var hacia_consultas = Intent(this,Resultado::class.java)
        this.startActivity(hacia_consultas)
    }



}