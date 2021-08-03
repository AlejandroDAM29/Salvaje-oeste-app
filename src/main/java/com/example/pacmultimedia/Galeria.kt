package com.example.pacmultimedia

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

//Esta clase es la que contendrá las imágenes de la galería
class Galeria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_galeria)

    }

    //Método para volver a la clase principal
    fun Volver(view:View){
        var mediaPlayer: MediaPlayer = MediaPlayer.create(this, R.raw.disparo);
        mediaPlayer.start()
        onBackPressed()
    }
}