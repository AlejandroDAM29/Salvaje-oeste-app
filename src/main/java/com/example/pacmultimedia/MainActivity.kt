package com.example.pacmultimedia


import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
/*Esta es la clase por la que se va a empezar a ejevutar el programa. Forma parte de la primera activity que podrá ver el usuario cuando arranque
* la app. Como campo de clase, se puede encontrar un booleano, que está declarado en un ámbito global para trabajar con el servicio de música a pesar
* de que se pulsen más elementos.*/
class MainActivity : AppCompatActivity() {

    //Este booleano detectará si la música ya está sonando para permitir o no que se arranque el servicio de música.
    var musica_encendida = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        }


    //Método para iniciar el servicio de música
    fun empieza_musica(view: View){
        if(!musica_encendida){
            var mi_servicio = Intent(this,MyServiceMusica::class.java)
            this.startService(mi_servicio)
        }//Fin de if
    }


    //Método para parar el servicio de música
    fun para_musica(view:View){
        var mi_servicio = Intent(this,MyServiceMusica::class.java)
        this.stopService(mi_servicio)
    }


    /*Cambia hacia la segunda actividad, donde se encuentra la base de datos. El objeto media
    * player aparecerá en cada transporte de actividad. Es el sonido de un disparo cuando pulsas un botón.*/
    fun irBBDD(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        var hacia_base = Intent(this,base_datos::class.java)
        startActivity(hacia_base)
    }

    //Cambia a la tercera actividad, la cual hace uso de la camara del teléfono
    fun irFotomaton(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        var hacia_fotomaton = Intent(this,Fotomaton::class.java)
        startActivity(hacia_fotomaton)
    }


    //Cambia a la actividad donde se alamecenan las 6 imágnenes
    fun irGaleria(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        var hacia_galeria = Intent(this,Galeria::class.java)
        startActivity(hacia_galeria)
    }
}