package com.example.pacmultimedia

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View

//Esta clase es la que va a usar la cámara de fotos a través de la imágen del fotomatón
class Fotomaton : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fotomaton)
    }

    //Esta constante representa la cámara trasera del dispositivo
    val REQUEST_IMAGE_CAPTURE = 1


    /*Este método abre la cámara a través de "takePintureIntent y selecciona
    * la cámara trasera a través de la constante REQUEST_IMAGE_CAPTURE
    * dentro del método startActivityForResult*/
    fun hacerFoto(view: View?) {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)

            }//Termina also de takePictureIntent

        }//Termina also de intent

    }//Termina método hacerFoto


    //Método para volver a la activity principal
    fun volverPrincipal(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        onBackPressed()
    }


}