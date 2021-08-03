package com.example.pacmultimedia

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

//Esta clase es un servicio, ya que hereda de service, y se usa para reproducir la música en segundo plano
class MyServiceMusica: Service() {

    //Declaro el objeto MediaPlayer en global para usarlo en los diferentes métodos
    var mediaPlayer:MediaPlayer?=null

    //Este es el método que está obligado a implementarse al heredar de service
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }


    //Aquí es donde creo y doy valor al objeto MediaPlayer
    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this,R.raw.musica_fondo)
        mediaPlayer?.isLooping = true
        mediaPlayer?.setVolume(100F,100F)
    }


    //En este método, iniciaré MediaPlayer y sonará la música
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mediaPlayer?.start()
        return START_STICKY
    }

    //Este método parará la música
    override fun onDestroy() {
        super.onDestroy()
        if(mediaPlayer?.isPlaying==true){
            mediaPlayer?.stop()
        }
        //Código para liberar recursos que está usando MediaPlayer
        mediaPlayer?.release()
        mediaPlayer = null

    }


}